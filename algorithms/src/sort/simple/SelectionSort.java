package sort.simple;

import data.DataFactory;

public class SelectionSort extends Sort {

	@Override
	public void sort(int[] numbers) {
		for(int i = 0; i < numbers.length - 1; i++){
			int min = numbers[i];
			int k = i + 1;
			for(int j = i + 1; j < numbers.length; j++){
				if(numbers[j] < min){
					min = numbers[j];
					k = j;
				}
			}
			if(numbers[i] > min){
				int temp = numbers[i];
				numbers[i] = min;
				numbers[k] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(10000, 500000);
		new SelectionSort().doSort(numbers);
	}

}
