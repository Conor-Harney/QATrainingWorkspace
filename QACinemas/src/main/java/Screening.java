
public class Screening {
	
	private String m_filmTitle;
	public enum AgeRating{ChildAlowed,ChildNotAlowed}
	AgeRating m_ageRating;
	String m_screen;
	String m_time;
	
	
	public String getFilmTitle() {
		return m_filmTitle;
	}

	public String getScreen() {//return the screen name
		return m_screen;
	}

	public String getTime() {//return the showing time 
		return m_time;
	}

	public Screening(String title, AgeRating ageRating, String screen, String time)
	{
		m_filmTitle = title;
		m_ageRating = ageRating;
		m_screen = screen;
		m_time = time;
	}
	
	public boolean checkChildAloud()
	{//child tickets should not to showings of this kind 
		if(m_ageRating == AgeRating.ChildAlowed) return true;
		else return false;
	}
	
	
	

}
