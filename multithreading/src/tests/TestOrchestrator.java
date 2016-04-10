package tests;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import task.factory.FutureTaskFactory;
import task.factory.LazyTaskFactory;
import utils.thread.ThreadUtils;

public class TestOrchestrator {

	// package protected utility methods
	static void orchestrateFutureCancellation() {
		FutureTask<String> lazyTask = FutureTaskFactory.getInstance().makeLazyFutureTask();
		ExecutorService orchestratorExecotur = Executors.newSingleThreadExecutor();
		Future<?> result = orchestratorExecotur.submit(lazyTask);
		ThreadUtils.sleepQuietly(1000);
		result.cancel(true);
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException | CancellationException e) {
			e.printStackTrace();
		}
		orchestratorExecotur.shutdown();
	}

	//when done, we need to get the result from the task, not the future returned by the submit
	static void orchestrateFutureTaskGet() {
		FutureTask<String> lazyTask = FutureTaskFactory.getInstance().makeLazyFutureTask();
		ExecutorService orchestratorExecutor = Executors.newFixedThreadPool(1);
		// Future<?> result = orchestratorExecutor.submit(lazyTask);
		orchestratorExecutor.submit(lazyTask);
		try {
			String resultStr = lazyTask.get();
			System.out.println(resultStr);
		} catch (InterruptedException | ExecutionException | CancellationException e) {
			e.printStackTrace();
		} finally {
			orchestratorExecutor.shutdown();
		}
	}

	//passing a callable instead an instance of a future-task
	static void orchestrateFutureGet() {
		ExecutorService orchestratorExecutor = Executors.newFixedThreadPool(1);
		Future<String> result = orchestratorExecutor.submit(LazyTaskFactory.getInstance().makeTask());
		try {
			String resultString = result.get();
			System.out.println(resultString);
		} catch (InterruptedException | ExecutionException | CancellationException e) {
			e.printStackTrace();
		} finally {
			orchestratorExecutor.shutdown();
		}
	}

}
