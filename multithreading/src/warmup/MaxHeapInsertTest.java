package warmup;

import java.util.Arrays;

public class MaxHeapInsertTest {

	private static Integer[] theHeap;
	
	private static void initializeHeap(){
		theHeap = new Integer[]{7, 4, 3, 2, -1};
	}
	
	public static void testInsertIntoHeap(){
		int newHeapElement = 12;
		initializeHeap();
		theHeap[theHeap.length - 1] = newHeapElement;
		System.out.println(Arrays.asList(theHeap));
		repairHeap();
	}
	
	private static void repairHeap(){
		int length = theHeap.length;
		int currentItemIndex = length - 1; //arrays are zero-based
		while(isParentSmallerThanMovedElement(currentItemIndex)){
			currentItemIndex = swapWithParent(currentItemIndex);
			System.out.println(Arrays.asList(theHeap));
		}
	}
	
	private static boolean isParentSmallerThanMovedElement(int currentItemIndex){
		int parentIndexOfCurrentItem = (currentItemIndex - 1)/2;
		int currentItem = theHeap[currentItemIndex];
		int parentItem = theHeap[parentIndexOfCurrentItem];
		if(parentIndexOfCurrentItem >= 0){ //if parent even exists...
			if(currentItem > parentItem){
				return true;
			}
		}
		return false;
	}
	
	private static int swapWithParent(int cuttentItemIndex){
		int currentItem = theHeap[cuttentItemIndex];
		int parentItemIndex = (cuttentItemIndex - 1)/2;
		int parentItem = theHeap[parentItemIndex];
		theHeap[parentItemIndex] = currentItem; // this = that
		theHeap[cuttentItemIndex] = parentItem; // that = this
		return parentItemIndex;
	}
	
	
	

}
