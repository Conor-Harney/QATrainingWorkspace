package mathHelper;

public class math {
	void addition(int a, int b)
	{
		float c  = (float) a + b;
		System.out.println(c);
	}
	void subtraction(int a, int b)
	{
		float c  = (float) a - b;
		System.out.println(c);
	}
	void multiplication(int a, int b)
	{
		float c  = (float) a * b;
		System.out.println(c);
	}
	void devision(int a, int b)
	{
		if(a>b)
		{
			float c  = (float) a / b;
			System.out.println(c);
		}
		else
		{
			System.out.println("Devision not allowed");
		}
	}
}
