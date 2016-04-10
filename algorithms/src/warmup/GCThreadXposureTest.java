package warmup;

public class GCThreadXposureTest {

	public static void main(String... args){
		new NuxOfMadMax();
		while(true){
			new NuxOfMadMax();
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
