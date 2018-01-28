package matching;

public class stableMatching {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		MedStudent[] students = new MedStudent[100];
		MedSchool[] schools = new MedSchool[10];
		
		fillArrays (students, schools);
		matchStudents (students, schools);
		writeMatchSheet (students, schools);
		
	}
	
	
	public static void fillArrays (MedStudent[] students, MedSchool[] schools) {
		
	}
	
	
	public static void writeMatchSheet (MedStudent[] students, MedSchool[] schools) {
		
	}
	
	
	public static void matchStudents (MedStudent[] students, MedSchool[] schools) {
		
		int counter = studentsUnmatched(students);
		
		while (0 < counter && emptySchoolSlots(schools)) {
			if (students[counter].getCurrentPref() >3 ) {
				students[counter].setMatched(true);
				students[counter].setMatchedSchool("no matches tobad");
			}
			else if (isSchoolEmpty(students[counter].getSchoolPref(), schools)) {
				students[counter].setMatched(true);
				students[counter].setMatchedSchool(students[counter].getSchoolPref());
				addStudentToSchool(students[counter].getSchoolPref(), schools);
			}
			//if the school is full before i move to next level I need to see who else is in the school
			//if this student has a higher pref then anothter student remove them and add this one
			else if (isPrefHigher(students[counter].getSchoolPref(), students[counter].getCurrentPref(), students)) {
				students[counter].setMatched(true);
				students[counter].setMatchedSchool(students[counter].getSchoolPref());
				
			}
			else {
				students[counter].increasePref();
			}
			
			counter = studentsUnmatched(students);
		}
	}
	
	
	public static boolean isPrefHigher(String preferedSchool, int priority, MedStudent[] students) {
		for (int i = 0; i < students.length; i++) {
			if (preferedSchool.equals(students[i].getMatchedSchool())) {
				if (priority < students[i].getCurrentPref()) {
					students[i].setMatched (false);
					students[i].increasePref();
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static boolean emptySchoolSlots(MedSchool[] schools) {
		for (int i = 0; i < schools.length; i++) {
			if (schools[i].isFull()) {
				return false;
			}
		}
		return true;
	}
	
	
	public static int studentsUnmatched (MedStudent[] students) {
		for (int i = 0; i < students.length; i++) {
			if (!students[i].isMatched()) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static boolean isSchoolEmpty (String school, MedSchool[] schools) {
		for (int i = 0;  i < schools.length; i++) {
			if (school.equals(schools[i].getName())) {
				return !schools[i].isFull();
			}
		}
		return false;
	}
	
	
	public static void addStudentToSchool (String school, MedSchool[] schools) {
		for (int i = 0; i < schools.length; i++) {
			if (school.equals(schools[i].getName())) {
				schools[i].addStudent();
			}
		}
		
	}
}
