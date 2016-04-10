package warmup;

public class RecursiveMultiplier {

	public static void testMultiply() {
		System.out.println(calculateProduct(1234 , 5678));
	}

	private static int calculateProduct(int first, int second) {
		int product = 0;
		if (areNumbersOfEvenLength(first, second)) {
			int length = String.valueOf(first).length();
			int a = getFirstHalf(first);
			int b = getSecondHalf(first);
			int c = getFirstHalf(second);
			int d = getSecondHalf(second);
			int poweredMultiplier = raiseTenTo(length);
			int poweredSemiMultiplier = raiseTenTo(length / 2);
			product = poweredMultiplier * calculateProduct(a, c) //10^n * ac
					+ poweredSemiMultiplier * (calculateProduct(a, d) + calculateProduct(b, c)) //10^(n/2) * (ad + bc) 
					+ calculateProduct(b, d); //bd
		} else {
			product = first * second;
		}
		System.out.println("Product of " + first + " and " + second + " is: " + product);
		return product;
	}

	private static int raiseTenTo(int index) {
		int retVal = 10;
		for (int i = 2; i <= index; i++) {
			retVal *= 10;
		}
		return retVal;
	}

	private static int getFirstHalf(int num) {
		int length = String.valueOf(num).length();
		String subString = String.valueOf(num).substring(0, length / 2);
		return Integer.valueOf(subString);
	}

	private static int getSecondHalf(int num) {
		int length = String.valueOf(num).length();
		String subString = String.valueOf(num).substring(length / 2, length);
		return Integer.valueOf(subString);
	}

	private static boolean areNumbersOfEvenLength(int first, int second) {
		int lengthFirst = String.valueOf(first).length();
		int lengthSecond = String.valueOf(second).length();
		if (lengthFirst == lengthSecond && isNumbersOfEvenLength(first)
				&& isNumbersOfEvenLength(second)) {
			return true;
		}
		return false;
	}

	private static boolean isNumbersOfEvenLength(int num) {
		int lengthNum = String.valueOf(num).length();
		if (lengthNum > 1 && lengthNum % 2 == 0) {
			return true;
		}
		return false;
	}
}
