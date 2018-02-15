package adder;

public class addUp {
	public void add(int A)
	{
		
		int num1 = 0;
		
		while(A >= 10)
		{
			A -= 10;
			num1 += 1;
		}
		int i = A + num1;
		System.out.println("Result: " + i);
	}
}
