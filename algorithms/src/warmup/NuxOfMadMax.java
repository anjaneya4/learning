package warmup;

public class NuxOfMadMax {
	
	private String[] arr = new String[Integer.MAX_VALUE/40]; 
	@Override
	public void finalize(){
		long mem_inital = Runtime.getRuntime().freeMemory();
		//Thread name is 'Finalizer'
		System.out.println(Thread.currentThread().getName() + " is killing me... WITNESSSSSS!!!!");
		long mem_final = Runtime.getRuntime().freeMemory();
		System.out.println("Memory freed after deleting this object = " + String.valueOf(mem_final - mem_inital));
		throw new UnsupportedOperationException();
	}

}
