
public class LevelGoldUser extends User {
	
	
	public LevelGoldUser() {
		super();
		
	}
	
	public void accessWineBar(String order)
	{
		switch (order) {
		case "Red wine":
			System.out.println("User" + ID + "received red wine ");
		default:
			System.out.println("User " + ID + " received water in a glass");
		}
		
	}

}
