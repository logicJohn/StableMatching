package matching;

public class MedSchool {
	
	private int NumOfSchools = 0;
	
	public String NameOfSchool;
	public int NumOfStudents;
	public int MaxNumOfStudents;
	
	public MedSchool () {
		this.NameOfSchool = "None";
		this.NumOfStudents = 0;
		this.MaxNumOfStudents = 0;
		NumOfSchools++;
	}
	
	
	public MedSchool (String name, int maxNumber) {
		this.NameOfSchool = name;
		this.NumOfStudents = 0;
		this.MaxNumOfStudents = maxNumber;
		NumOfSchools++;
	}
	
	public MedSchool (String name) {
		MedSchool x = new MedSchool ();
		x.NameOfSchool = name;
	}

	public boolean isFull () {
		if(this.NumOfStudents >= this.MaxNumOfStudents) {
			return true;
		}
		return false;
	}
	
	public String getName () {
		return this.NameOfSchool;
	}
	
	public void addStudent () {
		this.NumOfStudents++;
	}
	
	public void printSchoolInfo () {
		System.out.print("School Name: " + this.NameOfSchool);
		System.out.print(" Number of Students: " + this.NumOfStudents);
		System.out.println(" Max Num of Students: " + this.MaxNumOfStudents);
	}
}
