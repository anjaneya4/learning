package sort.efficient;

import java.util.Arrays;

import data.DataFactory;
import sort.simple.BubbleSort;
import sort.simple.Sort;

public class MergeSort extends Sort {

	@Override
	public void sort(int[] numbers) {
		mergeSort(numbers, 0, numbers.length);
	}
	
	private void mergeSort(int[] numbers, int low, int high){
		int mid = low + (high - low)/2;
		if(high - low < 2){
			return;
		} else{
			mergeSort(numbers, low, mid);
			mergeSort(numbers, mid, high);
		}
		merge(numbers, low, mid, high);
	}
	
	private void merge(int[] numbers, int low, int mid, int high){
		int[] L = Arrays.copyOfRange(numbers, low, mid);
		int[] R = Arrays.copyOfRange(numbers, mid, high);
		int i = 0;
		int j = 0;
		while(i < L.length && j < R.length){
			if(L[i] < R[j]){
				numbers[low + i + j] = L[i++];
			} else if(L[i] > R[j]){
				numbers[low + i + j] = R[j++];
			} else{
				numbers[low + i + j] = L[i];
				numbers[low + i + j + 1] = R[j];
				i++; 
				j++;
			}
		}
		while(i < L.length){
			numbers[low + i + j] = L[i];
			i++;
		}
		while(j < L.length){
			numbers[low + i + j] = R[j];
			j++;
		}
	}

	public static void main(String[] args) {
		int[] numbers = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(10000, 500000);
		new MergeSort().doSort(numbers);
	}

}
