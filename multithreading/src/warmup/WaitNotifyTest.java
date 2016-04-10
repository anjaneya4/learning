package warmup;

public class WaitNotifyTest {

	final static ProducerConsumer provider = new ProducerConsumer();

	public static String main1(String[] args) {

		Runnable producer = new Runnable(){
			@Override
			public void run(){
				try {
					provider.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable consumer = new Runnable(){
			@Override
			public void run(){
				try {
					provider.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread prod = new Thread(producer);
		Thread cons = new Thread(consumer);
		prod.start();
		cons.start();
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("Producer: " + prod.getState());
				System.out.println("Consumer: " + cons.getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	
	public static void main(String[] args) {
		try{
			dummyMethod();
		} catch(Exception a){
			System.out.println("catch executed!!! ZZzzzzzz!!!");
		} finally{
			System.out.println("finally executed!!! ZZzzzzzz!!!");
		}
	}
	
	private static Object dummyMethod(){
		int a = 2 * 44;
		dummyMethod();
		return new Object();
		
	}
	
	
}
