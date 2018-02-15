public class AMap {
	char[][] myMap;
	final int X_SIZE = 30;
	final int Y_SIZE = 10;
	public AMap()
	{
		populateMap();
	}
	
	private void populateMap()
	{
		myMap  = new char[Y_SIZE][X_SIZE];
		for(int y = 0; y < Y_SIZE; y++)
		{
			for(int x = 0; x< X_SIZE; x++)
			{
				if(y == 0 || y == Y_SIZE - 1)
				{
					myMap[y][x] = '-';
				}
				else
				{
					myMap[y][x] = '@';
				}
				 
			}
		}
	}
	
	public void printMap()
	{
		for(int y = 0; y < Y_SIZE; y++)
		{
			for(int x = 0; x<X_SIZE; x++)
			{
				System.out.print(myMap[y][x]);
			}
			System.out.println("\n");
		}
	}
	
	public void SetPoint(int x, int y, char data)
	{
		myMap[x][y] = data;
	}

}
