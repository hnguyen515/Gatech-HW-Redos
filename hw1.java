import java.util.*;
import java.lang.*;
import java.io.File;
import java.io.PrintStream;
import java.io.FileWriter;

    
public class hw1 {
    public static void main (String[] args) throws Exception {

	// GPA initialization
	System.out.println("Welcome to GPA Calculator!");
	boolean cont = processInput();
	while (cont) {
	    // Main loop control
	    cont = processInput();
	}
    }

    // Accademic info & GPA calculation
    static boolean processInput() throws Exception {
	System.out.print("Please enter the semester: ");
	Scanner sc = new Scanner(System.in);
	String sem = sc.next();
	sem = sem + sc.next();
	FileWriter writer = new FileWriter(sem + ".txt");
	writer.write(sem + " Semester\n\n");
	boolean rep = true;
	String ans = "";
	int cred = 0;
	int grade = 0;
	float gpa = 0;
	int n = 0;
	while (rep == true) {
		System.out.print("Please enter the course name: ");
		String name = sc.next();
		writer.write("Course: " + name + "\n");
		System.out.print("Please enter the course's credit number: ");
		cred = sc.nextInt();
		writer.write("Credit: " + Integer.toString(cred) + "\n");
		System.out.print("Please enter your grade (A = 4, B = 3, etc.): ");
		grade = sc.nextInt();
		writer.write("Grade earned: " + Integer.toString(grade) + "\n");
		gpa = (gpa*n + grade*cred) / (n + cred);
		n = n + cred;
		System.out.printf("Current GPA is: %.2f\n", gpa);
		System.out.print("Would you like to enter another course? (Y/N): ");
		ans = sc.next();
		if (ans.equals("Y") || ans.equals("y")) {
		    rep = true;
		}
		else {
		    rep = false;
		    String val = String.format(java.util.Locale.US,"%.2f", gpa);
		    writer.write("Cummulative GPA: " + val);
		}
	    }
	System.out.print("Would you like to enter another semester? (Y/N): ");
	ans = sc.next();
	writer.close();
	if (ans.equals("Y") || ans.equals("y")) {
	    return true;
	} else { return false;}
    }
}
