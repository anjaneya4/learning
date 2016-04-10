package sort.simple;

import data.DataFactory;

public class BubbleSort extends Sort{
	
	public static void main(String[] args){
		int[] numbers = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(10000, 500000);
		new BubbleSort().doSort(numbers);
//		print(numbers);
	}

	public void sort(int[] numbers){
		for(int i = 0; i < numbers.length; i++){
			boolean wasSwapped = false;
			for(int j = 0; j < numbers.length - 1 - i; j++){
				if(numbers[j] > numbers[j + 1]){
					//swap no space complexity
					numbers[j] = numbers[j]  + numbers[j + 1];
					numbers[j + 1] = numbers[j] - numbers[j + 1];
					numbers[j] = numbers[j] -  numbers[j + 1];
					wasSwapped = true;
				} else{
					if(!wasSwapped)wasSwapped = false;
				}
			}
			if(!wasSwapped){
				break;
			}
		}
	}
}
