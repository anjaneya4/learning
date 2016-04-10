package sort.simple;

import data.DataFactory;

public class InsertionSort extends Sort {

	@Override
	public void sort(int[] numbers) {
		for(int i = 1; i < numbers.length; i++){
			int j = i; 
			while(j > 0 && numbers[j] < numbers[j - 1]){
				int temp = numbers[j];
				numbers[j] = numbers[j - 1];
				numbers[j -1] = temp;
				j--;
			}
		}
	}

	public static void main(String[] args) {
		int[] numbers = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(10000, 500000);
		new InsertionSort().doSort(numbers);
//		print(numbers);
	}

}
