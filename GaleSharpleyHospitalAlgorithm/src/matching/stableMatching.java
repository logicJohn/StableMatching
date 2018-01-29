package matching;

import java.io.*;

public class stableMatching {

	public static void main (String[] args) {
		
		MedStudent[] students;
		MedSchool[] schools;
		
		students = fillStudentsArrays ("studentList.txt");
		schools = fillSchoolsArrays ("schoolList.txt");
		
		for (int i = 0; i < students.length; i++) {
			students[i].printStudentInfo();
		}
		for (int i = 0; i < schools.length; i++) {
			schools[i].printSchoolInfo();
		}
		
		matchStudents (students, schools);
		
		for (int i = 0; i < students.length; i++) {
			students[i].printStudentInfo();
		}
		for (int i = 0; i < schools.length; i++) {
			schools[i].printSchoolInfo();
		}		
		
		writeMatchSheet (students, schools);
		
		System.out.println("Finished");
		
	}
	
	/**
	 * Reads the file and creates and array of Medical Students (MedStudent).
	 * @param file Name of file containing all students and their preferences.
	 * @return An array of MedStudent. 
	 */
	public static MedStudent[] fillStudentsArrays (String file) {
		MedStudent[] temp;
		String fileName = file;
		String line = null;
		String name = null;
		String pref1 = null;
		String pref2 = null;
		String pref3 = null;
		int counter = 0;
		
		try {
			FileReader fileReader = new FileReader (fileName);
			BufferedReader bufferedReader = new BufferedReader (fileReader);
			if ((line = bufferedReader.readLine()) !=null) {
				System.out.println(line);
				temp = new MedStudent[Integer.parseInt(line)];
			} else {
				bufferedReader.close();
				return new MedStudent[0];
			}
			while ((name = bufferedReader.readLine()) != null) {
				pref1 = bufferedReader.readLine();
				pref2 = bufferedReader.readLine();
				pref3 = bufferedReader.readLine();
				temp[counter] = new MedStudent(name, pref1, pref2, pref3);
				counter++;
			}
			bufferedReader.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println( "Unable to open file '" + fileName + "'");
			return new MedStudent[0];
		}
		catch (IOException ex) {
			System.out.println( "Error reading file '" + fileName + "'");
			return new MedStudent[0];
		}
		return temp;
	}

	/**
	 * Reads the file and creates and array of University.
	 * @param file Name of file containing all Universities and total open students.
	 * @return An array of MedSchools.
	 */
	public static MedSchool[] fillSchoolsArrays (String file) {
		MedSchool[] temp;
		String fileName = file;
		String line = null;
		String schoolName = null;
		String numStudents = null;

		int counter = 0;
		
		try {
			FileReader fileReader = new FileReader (fileName);
			BufferedReader bufferedReader = new BufferedReader (fileReader);
			if ((line = bufferedReader.readLine()) !=null) {
				System.out.println(line);
				temp = new MedSchool[Integer.parseInt(line)];
			} else {
				bufferedReader.close();
				return new MedSchool[0];
			}
			while ((schoolName = bufferedReader.readLine()) != null) {
				numStudents = bufferedReader.readLine();
				temp[counter] = new MedSchool(schoolName, Integer.parseInt(numStudents));
				counter++;
			}
			bufferedReader.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println( "Unable to open file '" + fileName + "'");
			return new MedSchool[0];
		}
		catch (IOException ex) {
			System.out.println( "Error reading file '" + fileName + "'");
			return new MedSchool[0];
		}
		return temp;
	}

	
	
	/**
	 * NOT FINISHED, need to decide how to display/write matches
	 * @param students
	 * @param schools
	 */
	public static void writeMatchSheet (MedStudent[] students, MedSchool[] schools) {
        // The name of the file to open.
        String fileName = "temp2.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("Hello there,");
            bufferedWriter.write(" here is some text.");
            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
	}
	
	
	/**
	 * 	
	 * @param students
	 * @param schools
	 */
	public static void matchStudents (MedStudent[] students, MedSchool[] schools) {
		
		int counter = studentsUnmatched(students);
		System.out.println(counter);
		while (0 <= counter && schools[0].allSlotsFilled()) {
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
			//if this student has a higher pref then another student remove them and add this one
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
	
	/**
	 * 
	 * @param preferedSchool
	 * @param priority
	 * @param students
	 * @return
	 */
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
	
	/**
	 * 
	 * @param schools
	 * @return
	 */
	public static boolean emptySchoolSlots(MedSchool[] schools) {
		for (int i = 0; i < schools.length; i++) {
			if (schools[i].isFull()) {
				return true;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param students
	 * @return
	 */
	public static int studentsUnmatched (MedStudent[] students) {
		for (int i = 0; i < students.length; i++) {
			if (!students[i].isMatched()) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param school
	 * @param schools
	 * @return
	 */
	public static boolean isSchoolEmpty (String school, MedSchool[] schools) {
		for (int i = 0;  i < schools.length; i++) {
			if (school.equals(schools[i].getName())) {
				return !schools[i].isFull();
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param school
	 * @param schools
	 */
	public static void addStudentToSchool (String school, MedSchool[] schools) {
		for (int i = 0; i < schools.length; i++) {
			if (school.equals(schools[i].getName())) {
				schools[i].addStudent();
			}
		}
	}
	
}
