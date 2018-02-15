
public class ChildClassExtendingAbstractOpenParent extends AbstractOpenParent{

	public void abstractMethodOne() {
		o = 3;
		System.out.println("child: abstractMethodOne");
	}

	public void abstractMethodTwo(int y, int z) {
		o = y;
		u = z;
		System.out.println("child: abstractMethodTwo");
	}
	public void abstractMethodTwo(int z) {
		u = z;
		System.out.println("child: abstractMethodTwo");
	}
	public void normalChildMethodOne(int x)
	{
		i = x;
		System.out.println("child: normalChildMethodOne");
	}

}
