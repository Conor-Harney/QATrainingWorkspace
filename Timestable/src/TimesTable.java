
public class TimesTable {
	
	void loopRange(int T, int R) {
		int counter = 1;
		while(counter <= R)
		{
			System.out.println(T + " times " + counter + " = " + T * counter + "\n");
			counter++;
		}
		
	}
	
	void loopTo(int T)
	{//print T times tables up to max
		final int max = 12;
		int counter = 1;
		while(counter <= max)
		{
			System.out.println(T + " times " + counter + " = " + T * counter + "\n");
			counter++;
			
		}
	}
}
