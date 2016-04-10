package warmup;

import java.util.HashSet;
import java.util.Set;

public class DefaultTestExecutor {
	
//	public static void main(String[] args){
//		while(true){
//			if(true){
//				String p  = new SelfReferencerFinalize().toString();
//			}
//			System.out.println("created one instance of SelfReferencerFinalize");
//			try{
//				Thread.sleep(1000);
//				System.gc();
//			} catch(InterruptedException e){
//			}
//		}
//	}

	public static void main(String[] args){
		Set<String> set = new HashSet<String>();
		set.add(null);
		System.out.println(set.size());
		set.add(null);
		System.out.println(set.size());	
		//op:
		//1
		//1

	}

}


