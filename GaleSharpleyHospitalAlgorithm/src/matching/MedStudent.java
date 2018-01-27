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
		this.name = "John Doe null";
		this.matchedSchool = "no match";
		this.currentPref = 0;
		this.pref1 = "no match";
		this.pref2 = "no match";
		this.pref3 = "no match";
		this.engaged = false;
		this.NumOfStudents++;
	}
	
	
	public MedStudent (String name, String pref1, String pref2, String pref3) {
		MedStudent x = new MedStudent ();
		x.name = name;
		x.pref1 = pref1;
		x.pref2 = pref2;
		x.pref3 = pref3;
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
	
	
	
	
	
	
}
