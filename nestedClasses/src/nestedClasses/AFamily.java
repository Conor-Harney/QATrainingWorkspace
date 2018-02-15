package nestedClasses;

public class AFamily {
	private int memberID = 0;
	private Parent[] members = new Parent[30];

	public AFamily() {
		
	}

	public int addMember(Parent member) {
		members[memberID] = member;
		memberID++;
		return (memberID - 1);
	}

	public void printType(int id) {
		members[id].printType();
	}

}
