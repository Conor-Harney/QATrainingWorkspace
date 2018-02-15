
public class WhileToFor {
	void AByATimesLoop()
	{//print '1' 1 time, '2' 2 times etc
		for(int A = 1; A <= 10; A++)
		{
			for(int B = 1;B<=A; B++) {
				System.out.println("A = " + A);
			}
		}
		
	}
	
	void OddsAndEvens()
	{
		for(int A = 1; A <= 10; A++)
		{
			if(A % 2 == 0)
			{//even
				System.out.println(A + "-");
			}
			else
			{//odds
				System.out.println(A + "*");
			}
		}
		
	}
	
	void printTimesTableToMax(int timesTable, int upperLimit) {
		//loop a range of numbers
		for(int counter = 1; counter <= upperLimit; counter++)
		{
			System.out.println(timesTable + " times " + counter + " = " + timesTable * counter + "\n");
			
		}
		
	}
	
	void printTimesTable(int timesTable)
	{//print T times tables up to max
		for(int counter = 1, max = 12;counter <= max; counter++)
		{
			System.out.println(timesTable + " times " + counter + " = " + timesTable * counter + "\n");
		}
	}

}
