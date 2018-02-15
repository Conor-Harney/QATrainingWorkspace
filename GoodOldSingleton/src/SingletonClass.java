
public class SingletonClass {
	private static SingletonClass instance;
	int a;
	
	private SingletonClass()
	{
		a = 10;
	}
	
	public static SingletonClass getInstance()
	{
		if(instance == null)
			instance = new SingletonClass();
		return instance;
	}
	
	public void message()
	{
		System.out.println(a);
	}

}
