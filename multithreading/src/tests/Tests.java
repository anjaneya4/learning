package tests;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import data.DataFactory;
import executors.impl.DefaultExecutors;
import executors.impl.ReliableScheduledThreadPoolExecutor;
import warmup.MaxHeapInsertTest;
import warmup.RecursiveMultiplier;
import warmup.TimerTests;

public class Tests {

	public static final int testCaseToRun = 15;
	public static final Level logLevel = Level.SEVERE;

	public Object testASysout(Object input) {
		System.out.println("tested sysout successfully!");
		return null;
	}

	public static void main(String[] args) {
		TestCases.fromIndex(testCaseToRun).execute();
	}

	enum TestCases {
		TEST_A_SYSOUT(0, "SYSTEM OUT PRINTLN TEST") {
			public Object executeTest() {
				return new Tests().testASysout(null);
			}
		},
		TEST_SINGLE_THREAD_POOL_EXECUTOR(1, "SINGLE THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				DefaultExecutors.testSingleThreadPoolExecutor();
				return null;
			}
		},
		TEST_FIXED_THREAD_POOL_EXECUTOR(2, "FIXED THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				DefaultExecutors.testFixedThreadPoolExecutor();
				return null;
			}
		},
		TEST_CACHED_THREAD_POOL_EXECUTOR(3, "CACHED THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				DefaultExecutors.testCachedThreadPoolExecutor();
				return null;
			}
		},
		TEST_SIMPLE_TIMER_TASK(4, "SIMPLE TIMER TASK TEST") {
			public Object executeTest() {
				TimerTests.testSimpleTimerTask();
				return null;
			}
		},
		TEST_SCHEDULED_SINGLE_THREAD_POOL_EXECUTOR(5, "SCHEDULED SINGLE THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				DefaultExecutors.testSingleScheduledThreadPoolExecutor();
				return null;
			}
		},
		TEST_SCHEDULED_THREAD_POOL_EXECUTOR(6, "SCHEDULED THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				DefaultExecutors.testScheduledThreadPoolExecutor();
				return null;
			}
		},
		TEST_SCHEDULED_THREAD_POOL_EXECUTOR_TERMINATE(7, "SCHEDULED SUICIDAL-TASK THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				DefaultExecutors.testScheduledThreadPoolExecutorTerminator();
				return null;
			}
		},
		TEST_RELIABLE_SCHEDULED_THREAD_POOL_EXECUTOR_TERMINATE(8, "RELIABLE SCHEDULED SUICIDAL-TASK THREAD POOL EXECUTOR TEST") {
			public Object executeTest() {
				ReliableScheduledThreadPoolExecutor.testReliableScheduledThreadPoolExecutor();
				return null;
			}
		},
		TEST_FUTURE_TASK_THRED_INTERRUPTION(9, "FUTURE-TASK THREAD INTERRUPTION TEST") {
			public Object executeTest() {
				TestOrchestrator.orchestrateFutureCancellation();
				return null;
			}
		},
		TEST_FUTURE_TASK_GET_WAIT(10, "FUTURE-TASK WAIT GET INVOKE TEST") {
			public Object executeTest() {
				TestOrchestrator.orchestrateFutureTaskGet();
				return null;
			}
		},
		TEST_FUTURE_GET_WAIT(11, "FUTURE WAIT GET INVOKE TEST") {
			public Object executeTest() {
				TestOrchestrator.orchestrateFutureGet();
				return null;
			}
		},
		TEST_PRIORITY_basic_QUEUE(12, "PRIORITY QUEUE BASIC TEST") {
			public Object executeTest() {
				QueueTests.testPriorityQueue();
				return null;
			}
		},
		TEST_MAX_HEAP_INSERT_REPAIR(13, "MAX HEAP INSERT REPAIR TEST") {
			public Object executeTest() {
				MaxHeapInsertTest.testInsertIntoHeap();
				return null;
			}
		},
		TEST_RECURSIVE_MULTIPLY_INTEGERS(14, "RECURSIVE MULTIPLY INTERGERS TEST") {
			public Object executeTest() {
				RecursiveMultiplier.testMultiply();
				return null;
			}
		},
		TEST_INTEGERS_DATA_FACTORY(15, "INTEGERS DATA FACTORY TEST") {
			public Object executeTest() {
				System.out.println(Arrays.toString(DataFactory.getFactory().getArrayOfDistinctIntegers(10)));
				return null;
			}
		};

		protected abstract Object executeTest();

		public Object execute() {
			logTestStart();
			if (logLevel == Level.FINE) {
				// sysout("");
			}
			Object result = executeTest();
			if (logLevel == Level.FINE) {
				System.out.print("TEST RESULT: ");
				log(result);
			}
			logTestEnd();
			return result;
		}

		protected void logTestStart() {
			log("============***START***============");
			log("TestCase: " + this.index + ", Name: " + this.value);
			log("============***********============");
		}

		protected void logTestEnd() {
			log("============***END***============");
		}

		private int index;
		private String value;

		private TestCases(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return this.index;
		}

		private static void log(Object str) {
			if (str == null) {
				str = "<NULL>";
			}
			Logger.getAnonymousLogger().log(Level.INFO, str.toString());
		}

		public static TestCases fromIndex(int index) {
			for (TestCases testCase : TestCases.values()) {
				if (index == testCase.getIndex()) {
					return testCase;
				}
			}
			throw new NoSuchMethodError("Invalid index; No such testcase exists! TestCase Index: " + testCaseToRun);
		}

	}
}
