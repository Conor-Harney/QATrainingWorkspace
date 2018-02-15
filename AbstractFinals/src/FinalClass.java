
final public class FinalClass {
	//I can not be overwritten;
	
	//abstract public void contradictionMethod(); //I can not be abstract in a final class
	
	public void normalMethod()
	{
		System.out.println("Final: normalMethod");
		System.out.println("I am final as my class is final, \nthus I can not be overwritten!");
	}
	
	final public void finalMethodOne()
	{//This method can not be overwritten, even if the class was not final, as it is declared final.
		System.out.println("Final: finalMethodOne");
		System.out.println("This method can not be overwritten, \neven if the class was not final, as it is declared final.");
	}

}
