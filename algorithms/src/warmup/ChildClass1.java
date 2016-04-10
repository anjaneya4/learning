package warmup;

/**
 * Basically, if A subclass tries to override a method 
 * of the Parent class which has been declared as final there.
 * Compilation will fail saying that final method cannot be
 * overridden. Although the method is not original to the parent class,
 * it has been inherited in the parent class from its super class,
 * here, java.lang.Object.clone(): Object
 * :D 
 * 
 * @author anjaneya
 *
 */
public class ChildClass1 extends ParentClass1{

//	@Override
//	public Object clone() throws CloneNotSupportedException{
//		return (ChildClass1)super.clone();
//	}
}
