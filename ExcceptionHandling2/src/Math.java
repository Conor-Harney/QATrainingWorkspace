
public class Math {
	
	public void Div(int a, int b) throws MyExp
	{
		if(a>b)
		{
			MyExp xyz = new MyExp(); 
			throw xyz;
		}
		else {
			System.out.println(a/b);
		}
	}

}
