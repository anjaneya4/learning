package task.factory;

public interface ActionFactory {
	
	/**
	 * Specifies general conventions for manufaturing a task.
	 * The returned instance is a Runnable.
	 * 
	 * @return the Runnable whch represents the task
	 */
	Runnable makeAction();
	
}
