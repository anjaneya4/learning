package sort.simple;

import java.util.Arrays;

public abstract class Sort {
	
	protected static boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			int one = numbers[i];
			int two = numbers[i + 1];
			if (two < one) {
				System.out.println("Not Sorted!!!");
				return false;
			}
		}
		System.out.println("Sorted!!!");
		return true;
	}
	
	protected static void print(int[] numbers){
		System.out.println(Arrays.toString(numbers));
	}
	
	protected void doSort(int[] numbers){
		long startTime = System.currentTimeMillis();
		sort(numbers);
		long endTime = System.currentTimeMillis();
		System.out.println(validate(numbers) ? "Time Taken: " + (endTime - startTime) + " ms" : "");
	}
	
	public abstract void sort(int[] numbers);
}
