package studentMarker2;

public class Results {
	private int phy, che, mat, tot;

	private float per;

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		if (phy >= 0 && phy <= 150) {
			this.phy = phy;
		} else {
			this.phy = -1;
			System.out.println("invalid number entered into into phy");
		}
	}

	public int getChe() {
		return che;
	}

	public void setChe(int che) {
		if (che >= 0 && che <= 150) {
			this.che = che;
		} else {
			this.che = -1;
			System.out.println("invalid number entered into into che");
		}
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		if (mat >= 0 && mat <= 150) {
			this.mat = mat;
		} else {
			this.mat = -1;
			System.out.println("invalid number entered into into mat");
		}
	}

	public void doCalculations() {

		if (mat != -1 && che != -1 && phy != -1) {
			tot = phy + che + mat;
			per = (float) (tot * 100.0 / 450.0);
			System.out.println(tot);
		} else {
			System.out.println("Calculations not possible");
			if(phy == -1) System.out.println("Invalid value entered in phy");
			if(che == -1) System.out.println("Invalid value entered in che");
			if(mat == -1) System.out.println("Invalid value entered in mat");
		}
	}

	public void showResults() {
		
		if (mat != -1 && che != -1 && phy != -1) 
		{
			int subjectsFailed = 0;
	
			// count subjectsFailed
			if (getGradePercent(phy) < 60)
				subjectsFailed++;
			if (getGradePercent(mat) < 60)
				subjectsFailed++;
			if (getGradePercent(che) < 60)
				subjectsFailed++;
	
			switch (subjectsFailed) 
			{
				case (1): {
					System.out.println("Retake the exam");
					break;
				}
				case (2): {
					System.out.println("Retake the course");
					break;
				}
		
				case (3): {
					System.out.println("Go home");
					break;
				}
				default: 
				{
					System.out.println("Total marks: " + tot);
					System.out.println("Persentage: " + per);
		
					// print grade
					if (per >= 90)
						System.out.println("Grade-A");
					else if (per >= 80 && per < 90)
						System.out.println("Grade-B");
					else if (per >= 70 && per < 80)
						System.out.println("Grade-C");
					else// per>= 60 && per < 70
						System.out.println("Grade-D");
				}
			}
		}
		else 
		{
			System.out.println("Invalid value entered");
		}
	}

	public int getGradePercent(int grade) {
		return ((grade * 100) / 150);
	}
}
