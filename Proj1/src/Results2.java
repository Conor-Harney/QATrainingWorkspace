
public class Results2 {
	public int phy, che, mat, tot;
	public float per;

	public void doCalculations() {
		phy = 89;
		mat = 89;
		che = 89;
		tot = phy + che + mat;
		per = (float) tot * 100 / 450;
	}

	public void showResults() {
		int subjectsFailed = 0;

		// count subjectsFailed
		if (getGradePercent(phy) < 60)
			subjectsFailed++;
		if (getGradePercent(mat) < 60)
			subjectsFailed++;
		if (getGradePercent(che) < 60)
			subjectsFailed++;

		if (subjectsFailed > 0) {// at least one subject has been failed
			if (subjectsFailed == 1)
				System.out.println("Retake the exam");
			if (subjectsFailed == 2)
				System.out.println("Retake the course");
			if (subjectsFailed == 3)
				System.out.println("Go home");
		} else {// no subjects have been failed
			System.out.println("Total marks: " + tot);
			System.out.println("Persentage: " + per);

			// print grade
			if (per >= 90)
				System.out.println("Grade-A");
			if (per >= 80 && per < 90)
				System.out.println("Grade-B");
			if (per >= 70 && per < 80)
				System.out.println("Grade-C");
			if (per >= 60 && per < 70)
				System.out.println("Grade-D");
		}
	}

	public void showResultsVer2() {
		int subjectsFailed = 0;

		// count subjectsFailed
		if (getGradePercent(phy) < 60)
			subjectsFailed++;
		if (getGradePercent(mat) < 60)
			subjectsFailed++;
		if (getGradePercent(che) < 60)
			subjectsFailed++;

		switch (subjectsFailed) {
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
		default: {
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

	public int getGradePercent(int grade) {
		return ((grade * 100) / 150);
	}

	public int getPhy() {
		return phy;
	}

	public void setPhy(int phy) {
		this.phy = phy;
	}

	public int getChe() {
		return che;
	}

	public void setChe(int che) {
		this.che = che;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}
}
