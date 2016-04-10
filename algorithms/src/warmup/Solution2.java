package warmup;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Question:
 * https://www.hackerrank.com/contests/101feb14/challenges/sherlock-and-pairs
 * 
 * @author anjaneya
 *
 */
public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int[] arr = new int[N];
			 for (int j = 0; j < N; j++) {
				 arr[j] = in.nextInt();
			}
			 System.out.println(getNoOfPairsSmartly(arr));
		}
	}

	private static int getNumberOfSpecialPairsBruteForce(int[] arr){
		int length = arr.length;
		int count = 0;
		for(int i = 0; i < length; i++){
			for(int j = i+1; j < length; j++){
				if(arr[i] == arr[j]){
					System.out.println("i = " + i + ", j = " + j + ", val = " + arr[i] );
					count += 2;
				}
			}
		}
		return count;
	}
	
	private static BigInteger getNoOfPairsSmartly(int[] arr){
		BigInteger count = BigInteger.ZERO;
		Map<Integer, Integer> mMap = new HashMap<Integer, Integer>();
		Set<Integer> keys = new HashSet<Integer>();
		for(int i : arr){
			if(mMap.containsKey(i)){
				mMap.put(i, mMap.get(i) + 1);
				keys.add(i);
			} else{
				mMap.put(i, 1);
			}
		}
		for(int key : keys){
			int entry = mMap.get(key);
			count = count.add(new BigInteger(String.valueOf(entry)).multiply(new BigInteger(String.valueOf(entry - 1))));
		}
		return count;
	}
}
