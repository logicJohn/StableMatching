package matching;

public class MedStudent {

	private int NumOfStudents=0;
	
	public String name;
	public String matchedSchool;
	public int currentPref;
	public String pref1;
	public String pref2;
	public String pref3;
	public boolean engaged;
	
	public MedStudent () {
		this.name = "John Doe null ";
		this.matchedSchool = "not matched ";
		this.currentPref = 1;
		this.pref1 = "no match ";
		this.pref2 = "no match ";
		this.pref3 = "no match ";
		this.engaged = false;
		NumOfStudents++;
	}
	
	
	public MedStudent (String name, String pref1, String pref2, String pref3) {
		this.matchedSchool = "no match";
		this.currentPref = 1;
		this.engaged = false;
		NumOfStudents++;
		this.name = name;
		this.pref1 = pref1;
		this.pref2 = pref2;
		this.pref3 = pref3;
	}
	
	
	public MedStudent (String name, String pref1, String pref2) {
		MedStudent x = new MedStudent ();
		x.name = name;
		x.pref1 = pref1;
		x.pref2 = pref2;
	}
	
	
	public MedStudent (String name, String pref1) {
		MedStudent x = new MedStudent ();
		x.name = name;
		x.pref1 = pref1; 
	}
	
	public boolean isMatched () {
		return this.engaged;
	}
	
	public String getSchoolPref () {
		if (this.currentPref == 1) {
			return this.pref1;
		}
		if (this.currentPref == 2) {
			return this.pref2;
		}
		if (this.currentPref == 3) {
			return this.pref3;
		}
		return "no preference";
	}
	
	public int getCurrentPref () {
		return this.currentPref;
	}
	
	public void setCurrentPref (int pref) {
		this.currentPref = pref;
	}
	
	public void setMatched (boolean bool) {
		this.engaged = bool;
	}
	
	public void increasePref () {
		this.currentPref++;
	}
	
	public String getMatchedSchool () {
		return this.matchedSchool;
	}
	
	public void setMatchedSchool (String temp) {
		this.matchedSchool = temp;
	}
	
	public void printStudentInfo () {
		System.out.print("name: " + this.name);
		System.out.print(" matched school: " + this.matchedSchool);
		System.out.print(" currentPref: " + this.currentPref);
		System.out.print(" pref1: " + this.pref1);
		System.out.print(" pref2: " + this.pref2);
		System.out.print(" pref3: " + this.pref3);
		System.out.println(" engaged: " +this.engaged );
		
	}
}
