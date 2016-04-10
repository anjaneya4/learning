package dp;

import java.util.Arrays;

public class MinJumpsExitStairsBruteForce {

	public MinJumpsExitStairsBruteForce() {
		// TODO Auto-generated constructor stub
	}
	
	public static void testMinJumps(){
//		Logger.getAnonymousLogger().log(Level.SEVERE, "");
		int length = 10;
		//int[] stepJumps = DataFactory.getFactory().getArrayOfNonZeroPositiveIntegers(length, length/2);
		int[] stepJumps = null;
		System.out.println("INPUTS: " + Arrays.toString(stepJumps));
		int result = findMinJumpsToExit(stepJumps);
	}
	
	private static int findMinJumpsToExit(int[] stepJumps){
		
		return 0;
	}

}
