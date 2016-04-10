package sort.efficient;

import data.DataFactory;
import sort.simple.Sort;

public class HeapSort extends Sort {

	@Override
	public void sort(int[] numbers) {
		heapSort(numbers);
	}
	
	private void heapSort(int[] numbers){
//		print(numbers);
		heapify(numbers);
		sortHeap(numbers);
//		print(numbers);
	}
	
	private void sortHeap(int numbers[]){
		int i = 0;
		while(i <= numbers.length - 1){
			int temp = numbers[0];
			numbers[0] = numbers[numbers.length - 1 - i];
			numbers[numbers.length - 1 - i] = temp;
			siftDown(numbers, numbers.length - 1 - i - 1);
			i++;
		}
	}
	
	private void siftDown(int[] numbers, int upperBound){
		int index = 0;
		while(index < upperBound){
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			int largest = index;
			if(leftChildIndex <= upperBound && numbers[largest] < numbers[leftChildIndex]){
				largest = leftChildIndex;
			}
			if( rightChildIndex <= upperBound && numbers[largest] < numbers[rightChildIndex]){
				largest = rightChildIndex;
			}
			if(index != largest){
				int temp = numbers[index];
				numbers[index] = numbers[largest];
				numbers[largest] = temp;
				index = largest;
			}
			else{
				break;
			}
		}
	}
	
	private void heapify(int[] numbers){
		for(int i = numbers.length/2 - 1;  i >= 0; i--)
			maxHeapify(numbers, i);
	}
	
	private void maxHeapify(int[] numbers, int index){
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;
		int largest = index;
		
		if(leftChildIndex <= numbers.length - 1 && numbers[largest] < numbers[leftChildIndex]){
			largest = leftChildIndex;
		}
		if(rightChildIndex <= numbers.length -1 && numbers[largest] < numbers[rightChildIndex]){
			largest = rightChildIndex;
		}
		if(largest != index){
			int temp = numbers[index];
			numbers[index] = numbers[largest];
			numbers[largest] = temp;
			maxHeapify(numbers, largest);
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(10000, 500000);
		new HeapSort().doSort(numbers);
	}

}
