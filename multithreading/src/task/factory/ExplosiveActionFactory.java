package task.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import utils.thread.ThreadUtils;

/**
 * The task returned creates more and more thread. Try to execute these tasks in
 * a cached thread pool executor (java dfault configuration) and watch the whole
 * system blow up with new threads spawning every few seconds... and faster
 * later.
 * 
 * @author anjaneya
 *
 */
public final class ExplosiveActionFactory implements ActionFactory {

	private ExplosiveActionFactory() {
		super();
	}

	protected static volatile ActionFactory uniqueInstance = null;
	private transient static Logger logger = Logger.getAnonymousLogger();

	// using double checked locking; fix is implmented: volatile instance will
	// be always flushed on reads and writes by threads
	public static ActionFactory getInstance() {
		if (uniqueInstance == null) {
			synchronized (new Object()) {
				if (uniqueInstance == null) {
					uniqueInstance = new ExplosiveActionFactory();
				}
			}
		}
		return uniqueInstance;
	}

	@Override
	public Runnable makeAction() {
		return new Runnable() {
			@Override
			public void run() {
				while (true) {
					int random = (int) (Math.round(Math.random() * 10));
					if (random < 3) {
						// spawn new threads
						new Thread(TrivialActionFactory.getInstance().makeAction()).start();
						ThreadUtils.sleepQuietly(2000);
					} else {
						// just logs
						String threadName = Thread.currentThread().getName();
						logger.log(Level.SEVERE, "Thread: " + threadName);
						System.out.println("ThreadName: " + threadName + ", RandomcNumber: " + Math.random());
						ThreadUtils.sleepQuietly(2000);
					}
				}
			};
		};
	}

}
