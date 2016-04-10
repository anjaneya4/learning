package task.factory;

import java.util.concurrent.FutureTask;

public class FutureTaskFactory {

	private FutureTaskFactory() {
		super();
	}

	private static FutureTaskFactory uniqueInstance = null;

	public static synchronized FutureTaskFactory getInstance() {
		if(uniqueInstance == null){
			uniqueInstance = new FutureTaskFactory();
		}
		return uniqueInstance;
	}

	/**
	 * task is to return a string post waiting for 3 seconds.
	 * @return
	 */
	public FutureTask<String> makeLazyFutureTask() {
		FutureTask<String> lazyFuutureTask = new FutureTask<String>(LazyTaskFactory.getInstance().makeTask());
		return lazyFuutureTask;
	}
}
