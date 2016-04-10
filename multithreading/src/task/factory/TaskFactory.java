package task.factory;

import java.util.concurrent.Callable;

/**
 * 
 * Paramaterized {@code Callable} manufacturer interface.
 * 
 * @author anjaneya
 *
 * @param <C> The result of the {@code Callable}
 */
public interface TaskFactory<C> {
	public Callable<C> makeTask();
}
