package dp;

import java.util.Arrays;

public class MinimumJumpsExitStairsDP {

	public MinimumJumpsExitStairsDP() {
		// TODO Auto-generated constructor stub
	}
	
	public static void testMinJumps(){
//		Logger.getAnonymousLogger().log(Level.SEVERE, "");
		int length = 10;
		//int[] stepJumps = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(length, 4);
		int[] stepJumps = null;
//		stepJumps = new int[]{1, 4, 3, 2, 5, 4, 4, 1, 2, 2};
		System.out.println("INPUTS:   " + Arrays.toString(stepJumps));
		int result = findMinJumpsToExit(stepJumps);
		System.out.println(result);
	}
	
	private static int findMinJumpsToExit(int[] stepJumps){
		
		int totalSteps = stepJumps.length;
		int[] minJumpsToExitArray = new int[totalSteps];
		for(int i = minJumpsToExitArray.length - 1; i >= 0; i--){
			int minJumpsToExit = Integer.MAX_VALUE - totalSteps*2;
			for(int j = 1; j <= stepJumps[i]; j++){
				if(j + i >= totalSteps){
					minJumpsToExit = 1;
					break;
				} else{
					int requiredJumps = 1 + minJumpsToExitArray[i + j];
					if(minJumpsToExit > requiredJumps){
						minJumpsToExit = requiredJumps;
					}
				}
			}
			minJumpsToExitArray[i] = minJumpsToExit;
		}
		System.out.println("MINSTEPS: " + Arrays.toString(minJumpsToExitArray));
		return minJumpsToExitArray[0];
	}

}
