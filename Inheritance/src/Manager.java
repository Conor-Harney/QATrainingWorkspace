
public class Manager {
	
	private User user1, user2;
	private LevelGoldUser user3;
	
	public Manager() {
		user1 = new User();
		user2 = new User();
		user3 = new LevelGoldUser();
	}
	
	public void allowUserIn(int id)
	{
		switch(id)
		{
		case 1:
			user1.openMainDoors(1);
			break;
		case 2:
			user2.openMainDoors(1);
			break;
		case 3:
			user3.openMainDoors(1);
			break;
		default:
			user1.openMainDoors(1);
			user2.openMainDoors(1);
			user3.openMainDoors(1);
			break;
			
		}
	}
	public void getDrink(String request, int userid)
	{
		switch(userid) {
		case 1:
			user1.operateLeakingWaterMachine();
			break;
		case 2:
			user2.operateLeakingWaterMachine();
			break;
		case 3:
			user3.accessWineBar(request);
			break;
		}
	}
	

}
