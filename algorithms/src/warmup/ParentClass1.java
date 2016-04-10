package warmup;

public class ParentClass1 {
	
	public final Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	private static long[] getLongs(){
		return new long[2];
	}
	
	private static int[] getNums(){
		return new int[2];
	}
	
	private static char[] getChars(){
		return new char[2];
	}
	
	private static String[] getStrs(){
		return new String[2];
	}
	
	private static void checkGetNums(){
		Object a = getNums();
		System.out.println(a.getClass().getName());
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a.getClass().getSimpleName());
		System.out.println("=====================");
		Object b = getStrs();
		System.out.println(b.getClass().getName());
		System.out.println(b.getClass().getClassLoader());
		System.out.println(b.getClass().getSimpleName());
		System.out.println("=====================");
		Object c = getLongs();
		System.out.println(c.getClass().getName());
		System.out.println(c.getClass().getClassLoader());
		System.out.println(c.getClass().getSimpleName());
		System.out.println("=====================");
		Object d = getChars();
		System.out.println(d.getClass().getName());
		System.out.println(d.getClass().getClassLoader());
		System.out.println(d.getClass().getSimpleName());
		System.out.println("=====================");
		ChildClass1 c1 = new ChildClass1();
		ChildClass1[] c2 = new ChildClass1[2];
		System.out.println(c1.getClass().getName());
		System.out.println(c1.getClass().getClassLoader());
		System.out.println(c1.getClass().getSimpleName());
		System.out.println(c.getClass().getName());
		System.out.println(c2.getClass().getClassLoader());
		System.out.println(c2.getClass().getSimpleName());
	}
	
	public static void main(String[] args){
		checkGetNums();
	}

}
