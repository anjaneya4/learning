package data;

import java.util.HashMap;
import java.util.Map;

public class DataFactory {
	
	private static DataFactory uniqueInstance = new DataFactory();
	
	private DataFactory() {
		super();
	}
	
	//not synchronized since this is not a factory method per-se..
	//its simply a getter of the instance which was created by the 
	//static block above, in a thread--safe manner.
	public static DataFactory getFactory(){
		return uniqueInstance;
	}
	
	public int[] getArrayOfIntegers(int length){
		int[] arr = new int[length];
		for(int i = 0; i < length; i++){
			arr[i] = (int) (Math.random() * length);
		}
		return arr;
	}
	public int[] getArrayOfNonZeroPositiveIntegers(int length, int maxNum){
		int[] arr = new int[length];
		for(int i = 0; i < length; i++){
			arr[i] = (int) (Math.random() * maxNum + 1);
		}
		return arr;
	}
	
	public int[] getArrayOfDistinctIntegers(int length){
		Map<Integer, Object> manager = new HashMap<Integer, Object>();
		int[] arr = new int[length];
		for(int i = 0; i < length;){
			int randomNumber = (int) (Math.random() * 10 * length);
			if(!manager.containsKey(randomNumber)){
				arr[i++] = randomNumber;
				manager.put(randomNumber, new Object());
			}
		}
		return arr;
	}

}
