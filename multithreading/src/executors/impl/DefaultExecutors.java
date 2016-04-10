package executors.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import task.factory.ExplosiveActionFactory;
import task.factory.SuicidalActionFactory;
import task.factory.TrivialActionFactory;

/**
 * This class contains a demonstration of the default executors supplied by the
 * Java standard libraries.
 * 
 * @author anjaneya
 *
 */
public class DefaultExecutors {

	public static void testSingleThreadPoolExecutor() {
		Executor exec = Executors.newSingleThreadExecutor();
		exec.execute(TrivialActionFactory.getInstance().makeAction());
	}

	public static void testFixedThreadPoolExecutor() {
		Executor exec = Executors.newFixedThreadPool(3);
		exec.execute(TrivialActionFactory.getInstance().makeAction());
		exec.execute(TrivialActionFactory.getInstance().makeAction());
		exec.execute(ExplosiveActionFactory.getInstance().makeAction());
	}

	public static void testCachedThreadPoolExecutor() {
		Executor exec = Executors.newCachedThreadPool();
		// very dangerous: blows up the whole system
		// exec.execute(ExplosiveTaskFactory.getInstance().makeTask());
		exec.execute(TrivialActionFactory.getInstance().makeAction());
	}
	
	public static void testSingleScheduledThreadPoolExecutor() {
		Executor exec = Executors.newSingleThreadScheduledExecutor();
		exec.execute(TrivialActionFactory.getInstance().makeAction());
	}
	
	
	//this is WRONG way to invoke scheduled executors.. doesn't work well.
	//also, we are giving it spinning runnables.. TimerTasks are suppsed to 
	//have logic for one iteration ONLY.
	public static void testScheduledThreadPoolExecutor() {
		Executor exec = Executors.newScheduledThreadPool(5);
		exec.execute(TrivialActionFactory.getInstance().makeAction());
		exec.execute(TrivialActionFactory.getInstance().makeAction());
	}
	
	// task will throw exception but executor will resurect that thread.
	//new thread which spawns will have a separate thread name.
	//If Timer was instead used, the Timer wouldn' catch the unchecked
	//exception from the task logic and just kill the thread, pretending
	//that the underlygng TimerTask has been Cancelled! Besides, only one 
	//thread is associated with a single Timer Object.
	//IMP: WRONG!!! We needed a Reliable Scheduled Thread Pool Executor which handled the exception
	// @Code ReliableScheduledThreadPoolExecutor
	public static void testScheduledThreadPoolExecutorTerminator() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
//		scheduler.scheduleAtFixedRate(TimerTaskFactory.getInstance().makeTask(), 0, 2, TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(SuicidalActionFactory.getInstance().makeAction(), 0, 2, TimeUnit.SECONDS);
	}
}
