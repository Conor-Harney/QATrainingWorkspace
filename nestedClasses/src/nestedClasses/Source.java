package nestedClasses;

public class Source {
	
	
	
	public static void main(String args[])
	{
		AFamily family1 = new AFamily();
		System.out.println(family1.addMember(new Parent()));
		family1.printType(0);
		System.out.println(family1.addMember(new Child()));
		family1.printType(1);
		
	}

}
