
public class User {
	private static int lastID = 0;  
	int ID;
	
	protected User(){
		lastID++;
		ID = lastID;
	
	}
	
	public void openMainDoors(int doorID)
	{
		System.out.println("User " + ID + " gained access to the building");
		System.out.println("Welcome " + ID);
	}
	public void operateLeakingWaterMachine()
	{
		System.out.println("User " + ID + " received water in a plastic cup");
		System.out.println("User " + ID + " got slightly wet in the process");
	}
	
	public int getID(int id)
	{
		return ID;
	}
	

}
