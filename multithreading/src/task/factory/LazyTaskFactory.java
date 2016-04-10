package task.factory;

import java.util.concurrent.Callable;

import utils.thread.ThreadUtils;

public class LazyTaskFactory implements TaskFactory<String> {

	private static TaskFactory<String> uniqueInstance = null;
	
	//>>Q: is static initializer a thread safe creation style?
	//>> ANS: YES
	static{
		uniqueInstance = new LazyTaskFactory();
	}
	
	private LazyTaskFactory() {
		super();
	}
	
	public static synchronized TaskFactory<String> getInstance(){
		return uniqueInstance;
	}

	/**
	 * first sleeps for 3 seconds then wakes up and returns a string..
	 * @return
	 */
	@Override
	public Callable<String> makeTask() {
		Callable<String> lazyProgram = new Callable<String>() {
			@Override
			public String call() {
				ThreadUtils.sleepQuietly(3000);
				return "result str.";
			}
		};
		return lazyProgram;
	}
}
