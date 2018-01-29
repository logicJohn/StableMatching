package matching;

public class MedStudent {

	private int NumOfStudents=0;
	
	private String name;
	private String matchedSchool;
	private int currentPref;
	private String pref1;
	private String pref2;
	private String pref3;
	private boolean engaged;
	
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
	
	/**
	 * Check to see if student has been currently been accepted.
	 * @return true if is currently matched with a school.
	 */
	public boolean isMatched () {
		return this.engaged;
	}
	
	/**
	 * Checks the students preferred list and get the most preferred school.
	 * @return Most preferred school still available.
	 */
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
	
	/**
	 * 
	 * @param pref
	 */
	public void setCurrentPref (int pref) {
		this.currentPref = pref;
	}
	
	/**
	 * Checks to see if the student has currently been accepted.
	 * @param bool Return true if student is matched to a school.
	 */
	public void setMatched (boolean bool) {
		this.engaged = bool;
	}
	
	/**
	 * Sets the current preference of to the next school.
	 */
	public void increasePref () {
		this.currentPref++;
	}
	
	
	/**
	 * Get the name of school that accepted student.
	 * @return Name of school.
	 */
	public String getMatchedSchool () {
		return this.matchedSchool;
	}
	
	
	/**
	 * Sets the student to the accepted school.
	 * @param Name of school that accepted student.
	 */
	public void setMatchedSchool (String temp) {
		this.matchedSchool = temp;
	}
	
	/**
	 * Prints all the information about a student:
	 * Name, preferred Schools, matched schools, and current preference.
	 */
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
