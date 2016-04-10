package task.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Task throws exception in an attempt to kill the thread that carries this
 * task.. Timer folds. ScheduledExecutor doesn't. ShceduledThreadPoolExecutor
 * resurrects the task thread by manufacturing a new thread, keepiing the core
 * pool size intact.
 * 
 * @author anjaneya
 *
 */
public class SuicidalActionFactory implements ActionFactory {

	private static ActionFactory uniqueInstance = null;
	protected static final boolean randomizeSleep = false;
	protected transient static Logger logger = Logger.getAnonymousLogger();
	
	public static synchronized ActionFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SuicidalActionFactory();
			logInfo("Created instance of TaskFactory");
		}
		logInfo("Returned the instance of TaskFactory");
		return uniqueInstance;
	}

	// returns a task which prints a random message.. and the thread name.. and then throws an exception
	//in an attempt to kill itself.
	@Override
	public Runnable makeAction() {
		return new Runnable() {
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				Logger.getAnonymousLogger().log(Level.SEVERE, "Suicidal Task Thread: " + threadName);
				System.out.println("ThreadName: " + threadName + ", RandomcNumber: " + Math.random());
				// witness me!!! WITNEEEESSSSSS !!!
				throw new RuntimeException();
			}
		};
	}
	
	protected static void logInfo(String info) {
		logger.log(Level.INFO, info);
	}

}
