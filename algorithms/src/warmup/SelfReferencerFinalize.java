package warmup;

public class SelfReferencerFinalize {
	
	private SelfReferencerFinalize self = this;

	public SelfReferencerFinalize() {
		super();
	}
	
	@Override
	public void finalize(){
		System.out.println("Oops, Finalizer GC'd me!");
	}
}
