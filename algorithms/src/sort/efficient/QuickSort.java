package sort.efficient;

import data.DataFactory;
import sort.simple.Sort;

public class QuickSort extends Sort {

	@Override
	public void sort(int[] numbers) {
		print(numbers);
		quickSort(numbers, 0, numbers.length - 1);
		print(numbers);
	}
	
	private void quickSort(int[] numbers, int lo, int hi){
		if(lo < hi){
			int p = partition(numbers, lo, hi);
			quickSort(numbers, lo, p - 1);
			quickSort(numbers, p + 1, hi);
		}
		print(numbers);
	}

	private int partition(int[] numbers, int lo, int hi){
		int pivotIndex = hi;
		int i = lo;
		for(int j = lo; j <= hi; j++){
			if(numbers[j] < numbers[pivotIndex]){
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
			}
		}
		int temp = numbers[i];
		numbers[i] = numbers[hi];
		numbers[hi] = temp;
		return i;
	}

	public static void main(String[] args) {
		int[] numbers = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(10, 50);
		new QuickSort().doSort(numbers);
	}

}
