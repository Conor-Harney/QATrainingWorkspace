import java.util.Random;
public class Employee {
	private int id;
	private String Name;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int work() {
		int effort, minEffort, maxEffort;
		minEffort = 2;
		maxEffort = 100;
		Random r = new Random();
		effort = r.nextInt((maxEffort - minEffort) + 1) + minEffort;
		return effort;
	}
}
