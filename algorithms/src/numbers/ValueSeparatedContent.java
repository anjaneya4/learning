package numbers;

import java.util.Arrays;
import java.util.logging.Level;

public class ValueSeparatedContent {

	public static void main(String[] args){
		
		int n = 11;
		int[] arr = getValueSeparatedArray(n);
		printarray(arr);
	}
	
	private static void printarray(int[] arr){
		System.out.println(arr == null ? "Not Possible" : Arrays.toString(arr));
	}
	
	private static int[] getValueSeparatedArray(int n){
		
		int[] arr = new int[2 * n];

		int i = n;
		for(int j = 0; j < 2*n && i > 0 && i <= n;){
			if(isAdjustable(arr, i, j)){
				arr[j] = i;
				arr[j + i + 1] = i;
				i--;
				j = 0;
				printarray(arr);
			} else{
				j++;
				if(j == 2*n - 1){
					if(i == n){
						return null;
					}
					j = resetValuesOf(arr, ++i) + 1;
					printarray(arr);
				}
			}
		}
		return arr;
	}
	
	private static int resetValuesOf(int[] arr, int val){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == val){
				arr[i] = 0;
				arr[i + val + 1] = 0;
				return i;
			}
		}
		return 0;
	}
	
	private static boolean isAdjustable(int[] arr, int val, int pos){
		try{
			if(arr[pos] == 0 && arr[pos + val + 1] == 0){
				return true;
			}
		} catch(ArrayIndexOutOfBoundsException aiobe){
		}
		return false;
	}
}
