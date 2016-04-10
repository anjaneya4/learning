package warmup;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InitTestSub extends InitTestSuper{

	public InitTestSub() {
		super();
		try{
			InitTestSuper parent = new InitTestSuper();
		} catch(RuntimeException  e){
			Logger.getAnonymousLogger().log(Level.SEVERE, "Object not propery initialized..");
		}
	}
	
	public static void testInitialization(){
		InitTestSub a = new InitTestSub();
	}
	
	public static void main(String[] args){
		testInitialization();
	}

}
