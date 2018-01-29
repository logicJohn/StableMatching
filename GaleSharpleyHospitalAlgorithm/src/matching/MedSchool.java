package matching;

/**
 *  
 * @author johnnie Hernandez
 *
 */
public class MedSchool {
	
	private int NumOfSchools = 0;
	private int totalNumberOfSlots = 0;
	private int totalNumberOfSlotsFilled = 0;
	
	private String NameOfSchool;
	private int NumOfStudents;
	private int MaxNumOfStudents;
	
	/**
	 * 
	 */
	public MedSchool () {
		this.NameOfSchool = "None";
		this.NumOfStudents = 0;
		this.MaxNumOfStudents = 0;
		NumOfSchools++;
	}
	
	/**
	 * Constructs a medical university object.
	 * @param name The name of the school, case sensitive.
	 * @param maxNumber The total number of students the school is accepting.
	 */
	public MedSchool (String name, int maxNumber) {
		this.NameOfSchool = name;
		this.NumOfStudents = 0;
		this.MaxNumOfStudents = maxNumber;
		totalNumberOfSlots += maxNumber;
		NumOfSchools++;
	}
	
	
	/**
	 * Check to see if a school has any more students.
	 * @return True if there are openings.
	 */
	public boolean isFull () {
		if(this.NumOfStudents >= this.MaxNumOfStudents) {
			return true;
		}
		return false;
	}
	
	/**
	 * Get the name of the school.
	 * @return Name of school.
	 */
	public String getName () {
		return this.NameOfSchool;
	}
	
	/**
	 * Add the total number of accepted students to a school by one.
	 */
	public void addStudent () {
		totalNumberOfSlotsFilled++;
		this.NumOfStudents++;
	}
	
	/**
	 * Print the schools, name, accepted students, and 
	 * maximum students being accepted.
	 */
	public void printSchoolInfo () {
		System.out.print("School Name: " + this.NameOfSchool);
		System.out.print(" Number of Students: " + this.NumOfStudents);
		System.out.println(" Max Num of Students: " + this.MaxNumOfStudents);
	}
	
	/**
	 * See if all schools have filled there open slots.
	 * @return
	 */
	public boolean allSlotsFilled () {
		if (totalNumberOfSlots > totalNumberOfSlotsFilled) {
			return true;
		}
		return false;
	}
}
