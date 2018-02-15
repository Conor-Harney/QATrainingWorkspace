
public class Source {
	public static void main(String args[])
	{
		ChildClassExtendingAbstractOpenParent childOne = new ChildClassExtendingAbstractOpenParent();
		childOne.abstractMethodOne();
		System.out.println();
		
		childOne.abstractMethodTwo(3);
		System.out.println();
		
		childOne.abstractMethodTwo(4,5);
		System.out.println();
		
		childOne.normalParentMethodOne(3);
		System.out.println();
		
		childOne.normalChildMethodOne(9);
		System.out.println();
		
		
		FinalClass fc1 = new FinalClass();
		fc1.normalMethod();
		System.out.println();
		
		fc1.finalMethodOne();
		System.out.println();
		
	}
}
