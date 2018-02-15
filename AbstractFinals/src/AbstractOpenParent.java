
public abstract class AbstractOpenParent {
	//this is an abstract class that will have to be overwritten 
	int i, o, u;
	public abstract void abstractMethodOne();
	public void normalParentMethodOne(int x)
	{
		i = x;
		System.out.println("Parent: normalParentMethodOne");
	}
	public abstract void abstractMethodTwo(int y, int z);
	
}
