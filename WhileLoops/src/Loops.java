
public class Loops {

	void AByATimesLoop()
	{//print '1' 1 time, '2' 2 times etc
		int A = 1;
		while(A <= 10)
		{
			int B = 1;
			while(B<=A) {
				System.out.println("A = " + A);
				B++;
			}
			A++;
		}
		
	}
	
	void OddsAndEvens()
	{
		
		int A = 1;
		while(A <= 10)
		{
			if(A % 2 == 0)
			{//even
				System.out.println(A + "-");
			}
			else
			{//odds
				System.out.println(A + "*");
			}
			A++;
		}
		
	}
}
