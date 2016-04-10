package task.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import utils.thread.ThreadUtils;

/**
 * Manufactures trivial task: a task which simply sysouts and then calls
 * Thread.sleep() in an infinite loop.
 * 
 * @author anjaneya
 *
 */
public final class TrivialActionFactory implements ActionFactory {

	protected TrivialActionFactory() {
		super();
	}

	private static ActionFactory uniqueInstance = null;
	private transient static Logger logger = Logger.getAnonymousLogger();
	private static final boolean randomizeSleep = true;

	/**
	 * "factory factory method": <strong>NOT</strong> using double checked
	 * locking
	 * 
	 * @return
	 */
	public static synchronized ActionFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TrivialActionFactory();
			logInfo("Created instance of TaskFactory");
		}
		logInfo("Returned the instance of TaskFactory");
		return uniqueInstance;
	}

	// returns a task which prints a random message.. and the thread name
	public Runnable makeAction() {
		return new Runnable() {
			@Override
			public void run() {
				while (true) {
					String threadName = Thread.currentThread().getName();
					logger.log(Level.SEVERE, "Thread: " + threadName);
					System.out.println("ThreadName: " + threadName + ", RandomcNumber: " + Math.random());
					int sleepTime;
					if (randomizeSleep) {
						sleepTime = (int) (Math.round(Math.random() * 10000));
					} else {
						sleepTime = 2000;
					}
					ThreadUtils.sleepQuietly(sleepTime);
				}
			}
		};
	}

	private static void logInfo(String info) {
		logger.log(Level.INFO, info);
	}
}
