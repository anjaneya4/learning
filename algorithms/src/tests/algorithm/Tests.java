package tests.algorithm;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import dp.MinJumpsExitStairsBruteForce;
import dp.MinimumJumpsExitStairsDP;

public class Tests {

	public static final int testCaseToRun = 2;
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
		TEST_MIN_JUMP_BRUTE_FORCE(1, "BRUTE FORCE MIN JUMP TEST") {
			public Object executeTest() {
				MinJumpsExitStairsBruteForce.testMinJumps();
				return null;
			}
		},
		TEST_MIN_JUMP_DP(2, "DP MIN JUMP TEST") {
			public Object executeTest() {
				MinimumJumpsExitStairsDP.testMinJumps();
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
