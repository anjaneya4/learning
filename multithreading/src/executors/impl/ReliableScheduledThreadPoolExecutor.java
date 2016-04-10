package executors.impl;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import task.factory.SuicidalActionFactory;

/**
 * Error save Scheduled ThreadPool Implementation: catches any exception AND
 * errors from client logic and continues tasks execution even though one fails.
 * 
 * @author anjaneya
 *
 */
public class ReliableScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

	public ReliableScheduledThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
	}

	/**
	 * test: passes a suicidal task to a reiable executor will cause the suicide
	 * to be suppressed and the executor will continue throttling, no matter how
	 * manu times the task throws exceptions.
	 * 
	 */
	public static void testReliableScheduledThreadPoolExecutor() {
		testReliableTaskScheduling(SuicidalActionFactory.getInstance().makeAction());
	}

	public static void testReliableTaskScheduling(Runnable task) {
		ScheduledExecutorService scheduler = new ReliableScheduledThreadPoolExecutor(2);
		scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		return super.scheduleAtFixedRate(wrapRunnable(command), initialDelay, period, unit);
	}

	//eats the exception and doesn't rethrow it.
	private Runnable wrapRunnable(final Runnable aRunnable) {
		Runnable wrapper = new Runnable() {
			@Override
			public void run() {
				try {
					Logger.getAnonymousLogger().log(Level.SEVERE,
							"Wrapped Runnable: now invoing client logic with protection...");
					aRunnable.run();
				} catch (Throwable t) {
					Logger.getAnonymousLogger().log(Level.SEVERE,
							"Throwable caught in client logic. Now Continuing next scheduled task.");
				}
			}
		};
		return wrapper;
	}

	public ReliableScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
		super(corePoolSize, threadFactory);
	}

	public ReliableScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler) {
		super(corePoolSize, handler);
	}

	public ReliableScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory,
			RejectedExecutionHandler handler) {
		super(corePoolSize, threadFactory, handler);
	}

}
