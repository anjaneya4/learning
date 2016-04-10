package sort;

import java.util.Arrays;

import data.DataFactory;

public class MergeSortTest implements ISortTest{
	
	public void testSort(){
		sort();
	}
	
	public static void main(String[] args){
		new MergeSortTest().testSort();
	}

	public static void sort(){
		int length = 10;
		int[] arrayToSort = DataFactory.getFactory().getArrayOfIntegers(length);
		System.out.println(Arrays.toString(arrayToSort));
		mergeSort(arrayToSort, 0, length);
	}
	
	private static void mergeSort(int[] a, int start, int end){
		//1. break this array until length from start to end is unity
		int mid = (end - start) / 2;
		if(end-start > 1){
			mergeSort(a, start, mid);
			mergeSort(a, mid, end);
		} else {
			return;
		}
		//2. merge
		merge(a, start, mid, end);
	}
	
	private static void merge(int[] a, int start, int mid, int end){
		int i = start;
		int j = mid - 1;
		int[] LEFT = Arrays.copyOfRange(a, start, mid);
		int[] RIGHT = Arrays.copyOfRange(a, mid, end);
		int current = start;
		while(i <= mid && j <= end){
			if(LEFT[i] <= RIGHT[j]){
				a[current++] = LEFT[i];
				i++;
			} else{
				a[current++] = RIGHT[j];
				j++;
			}
		}
	}
	
	private static void swap(int[] a, int first, int second){
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

}
