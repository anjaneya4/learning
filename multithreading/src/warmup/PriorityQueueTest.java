package warmup;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void test(){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(12);
		queue.add(12);
		System.out.println(queue);
		queue.add(4);
		System.out.println(queue);
		queue.add(2);
		System.out.println(queue);
		queue.add(8);
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.remove(12);
		System.out.println(queue);
	}

}
