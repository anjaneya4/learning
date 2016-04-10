package warmup;

import java.util.Scanner;

public class ProducerConsumer {

	public void produce() throws InterruptedException{
		synchronized(this){
			System.out.println("Producer thread running!");
			wait();
			System.out.println("Resumed!");
		}
	}
	
	public void consume() throws InterruptedException{
		Thread.sleep(2000);
		synchronized(this){
			System.out.println("Consumer waiting for return key!");
			new Scanner(System.in).nextLine();
			System.out.println("Return Key was pressed!!");
			notify();
			Thread.sleep(3000);
		}
	}
}
