
public class Source {
	
	public static void main(String args[])
	{
		MethodOverloader mo1 = new MethodOverloader();
		mo1.printVars();
		System.out.println();
		
		MethodOverloader mo2 = new MethodOverloader(1);
		mo2.printVars();
		System.out.println();
		
		MethodOverloader mo3 = new MethodOverloader(2.384f);
		mo3.printVars();
		System.out.println();
		
	}

}
