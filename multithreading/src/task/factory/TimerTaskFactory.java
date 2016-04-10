package task.factory;

import java.util.TimerTask;

/**
 * Simple factory to manufacture Timer Tasks.
 * 
 * @author anjaneya
 *
 */
public class TimerTaskFactory implements ActionFactory {

	private static TimerTaskFactory uniqueInstance = null;

	public static synchronized ActionFactory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new TimerTaskFactory();
		}
		return uniqueInstance;
	}

	/**
	 * Returns A timertask wrapped in a Runnable reference type. I don't know
	 * what that is necessary here. But it definitely serves well to remind me
	 * that poor Timer HAS TO have a TimerTask inside it and a simple Runnable
	 * JUST WON'T DO. I get to recall this everytime that I invoke this factory
	 * method and I have to case the returned TimerTask into a Runnable every
	 * time I invoke this factory. ;D
	 * 
	 */
	@Override
	public Runnable makeAction() {
		Runnable task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Timer task executing. Random Number: " + Math.random());
			}
		};
		return task;
	}
}
