package warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Question:
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 * 
 * @author anjaneya
 *
 */
public class Solution1 {

	private class Node {
		private int value;	//denotes the integer value of this node
		Node next;	//denotes the next pointer in this level data
		
		public void setValue(int value){
			this.value = value;
//			System.out.println(value);
		}
	}
	
	private List<Node> levelData = new ArrayList<Node>();
	private List<Integer> levelLengths = new ArrayList<Integer>();
	private int[][] arr = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int R = in.nextInt();
		Solution1 sol = new Solution1();
		sol.arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				sol.arr[i][j] = in.nextInt();
			}
		}
		printArray(sol.arr, M, N);
		sol.parseLevelData(M - 1, N - 1, true);	//array indices start from 0
		sol.rotate(R);
		sol.parseLevelData(M - 1, N - 1, false);
		printArray(sol.arr, M, N);
	}
	
	private void rotate(int R){
		int idx = -1;
		for(Node node : levelData){
			idx++;
			int actualRots = R % levelLengths.get(idx);
			for(int i = 1; i <= actualRots; i++){
				node = node.next;
			}
			levelData.set(idx, node);
		}
	}

	private void parseLevelData(int M, int N, boolean extract) {

		int totalLevels = (Math.min(M + 1, N + 1)) / 2;
		for (int level = 0; level < totalLevels; level++) {
			int levelLength = 0;
			Node nodePtr = null;
			Node levelNode = null;
			if(extract){
				nodePtr = new Node();
				levelNode = nodePtr;
				levelData.add(levelNode);
				levelLength++;
			} else{
				nodePtr = levelData.get(level);
			}
			// 1. R
			for(int i = level; i <= N - level -1; i++){
				if(extract){
					nodePtr.setValue(arr[level][i]);
					nodePtr.next = new Node();
					levelLength++;
				} else{
					arr[level][i] = nodePtr.value;
				}
				nodePtr = nodePtr.next;
			}
			// 2. D
			for(int i = level; i <= M - 1 - level; i++){
				if(extract){
					nodePtr.setValue(arr[i][N - level]);;
					nodePtr.next = new Node();
					levelLength++;
				} else{
					arr[i][N - level] = nodePtr.value;
				}
				nodePtr = nodePtr.next;
			}
			// 3. L
			for(int i = N - level; i >= level + 1; i--){
				if(extract){
					nodePtr.setValue(arr[M - level][i]);
					nodePtr.next = new Node();
					levelLength++;
				} else{
					arr[M - level][i] = nodePtr.value;
				}
				nodePtr = nodePtr.next;
			}
			// 4. U
			for(int i = M - level; i >= level + 1; i--){
				if(extract){
					nodePtr.setValue(arr[i][level]);;
					nodePtr.next = (i == level + 1 ? levelNode : new Node());	//complete the circle
					levelLength++;
				} else{
					arr[i][level] = nodePtr.value;
				}
				nodePtr = nodePtr.next;
			}
			if(extract){
				levelLengths.add(levelLength - 1);
			}
		}
	}

	private static void printArray(int[][] arr, int M, int N) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
