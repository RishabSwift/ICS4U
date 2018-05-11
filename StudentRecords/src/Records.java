import java.io.*;
import java.util.*;

/**
 * This class is the main class that runs the program.
 * It is responsible for adding, removing, loading and saving students.
 *
 * @author Rishab Bhatt
 */
public class Records {

    // current user input
    public String input = "";

    // instance of record class
    private static Records record;

    private File file;

    // all students in a array list
    public List<Student> students = new ArrayList<Student>();

    // if user has typed exit to exit program
    private boolean exit = false;

    /**
     * Run the program
     *
     * @param args
     */
    public static void main(String[] args) {
        // Ask what they want to do

        record = new Records();

        record.beginProgram();

    }


    /**
     * Start the program
     */
    private void beginProgram() {

        while (!exit) {
            Messages.startMessage(record);

            Messages.getInput("Add|Search|Sort|Load|Save|Exit");

            switch (input.toLowerCase()) {

                // Add a new student
                case "add":

                    Student student = addStudent();

                    students.add(student);

                    Messages.addedStudentMessage();

                    // After adding, user can go home or view the student
                    Messages.getInput("View|Home");

                    // They can view the student or go home
                    switch (input.toLowerCase()) {

                        case "view":

                            Messages.showStudent(student);
                            viewStudentPage(student);

                            break;

                        case "home":
                            break;

                        default:
                            break;
                    }
                    break;

                // Save the students to file
                case "save":

                    Messages.saveStudentsMessage();

                    Messages.getInput("Yes|Cancel|Exit");

                    switch (input.toLowerCase()) {
                        // Save and override
                        case "yes":

                            // Delete the user data file and save it again
                            deleteUserDataFile();

                            for (Student s : students) {
                                writeFile(encodeStudent(s));
                            }

                            Messages.showMessage("Students have been saved successfully!");
                            Messages.showMessage("");

                            break;

                        // Cancel save
                        case "cancel":
                            students.clear();
                            loadFile();
                            Messages.showMessage("Any unsaved students have been removed!");
                            Messages.showMessage("");
                            break;

                        // Exit and go to main menu
                        case "exit":
                            Messages.showMessage("No changes were saved. You can still save it if you wish ");
                            Messages.showMessage("");
                            break;
                    }

                    break;

                // Sort using the user's first/last name
                case "sort":

                    if (students.size() == 0) {
                        Messages.showMessage("There are no students to sort!");
                        Messages.showMessage("Try adding a few students or loading from file!");
                        Messages.showMessage("");
                        break;
                    }
                    Collections.sort(students);

                    for (Student s : students) {
                        s.toString();
                    }

                    break;

                // Search for a user
                case "search":
                    Messages.searchStudentMessage();
                    Messages.getInput(Validation.Type.STUDENT_NUMBER);

                    // If the student is found
                    boolean foundStudent = false;
                    // Loop through and search for user
                    for (Student s : students) {
                        if (s.getStudentNumber().equals(input)) {
                            foundStudent = true;
                            Messages.showStudent(s);
                            viewStudentPage(s);
                            break;
                        }
                    }

                    if (!foundStudent) {
                        Messages.showMessage("A student with that ID does not exist!");
                        Messages.showMessage("");
                        break;
                    }


                    break;

                // Load user from file
                case "load":

                    Messages.loadStudentMessage();

                    if (students.size() > 0) {
                        Messages.loadStudentWarning();
                        Messages.getInput("Yes|No");

                        // If they do not want to load students
                        if (input.equals("no")) {
                            break;
                        }
                    }

                    // Clear the student records first
                    students.clear();
                    // Load from file and save it to the student array list

                    loadUsers();
                    break;

                // Exit program
                case "exit":
                    exit = true;
                    break;
                default:

                    break;
            }
        }

        Messages.showExitMessage();

    }

    /**
     * Add new student
     *
     * @return added student
     */
    private Student addStudent() {
        Student student = new Student();

        Messages.addStudentMessage();

        Messages.showMessage("What grade is the student currently in?");
        student.setGrade(Messages.getInput(Validation.Type.GRADE));

        Messages.showMessage("Enter the student's first name");
        student.setFirstName(Messages.getInput(Validation.Type.ALPHA));

        // todo: name the "student" in message to their name for better gui
        Messages.showMessage("Enter the student's last name", student);
        student.setLastName(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's middle name initials (leave blank if none)", student);
        student.setMiddleInitials(Messages.getInput(Validation.Type.ALPHA_NONE));

        Messages.showMessage("Enter the student's student ID", student);
        student.setStudentNumber(Messages.getInput(Validation.Type.STUDENT_NUMBER));

        Messages.showMessage("Enter the student's phone number", student);
        student.setPhoneNumber(Messages.getInput(Validation.Type.PHONE));

        Messages.showMessage("Enter the student's email address", student);
        student.setEmail(Messages.getInput(Validation.Type.EMAIL));

        Messages.showMessage("Enter the student's street address", student);
        student.setStreetAddress(Messages.getInput(Validation.Type.ALPHA_NUM));

        Messages.showMessage("Enter the student's city", student);
        student.setCity(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's province", student);
        student.setProvince(Messages.getInput(Validation.Type.PROVINCE));

        Messages.showMessage("Enter the student's postal code", student);
        student.setPostalCode(Messages.getInput(Validation.Type.POSTAL_CODE));

        return student;
    }

    /**
     * Load students from a file
     */
    private void loadUsers() {

        Messages.showMessage("Loading student records from a file...");
        Messages.showMessage("");

        record.loadFile();

        Messages.showMessage(String.format("Total students: %d", students.size()));

        Messages.showMessage("");

        for (Student student : students) {
            student.toString();
        }
    }

    /**
     * Load the file
     */
    private void loadFile() {


        // The fil ename
        file = new File("user_data.txt");

        // If file does not exist, we make a new file
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Look at the file and parse each line as a user and store it in the array list
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                // Decode teh student
                Student student = decodeStudent(st);
                students.add(student);
            }


            // Handle exceptions...
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Write a string to the file
     *
     * @param s string to write
     */
    private void writeFile(String s) {

        file = new File("user_data.txt");

        // If file does not exist, we make a new file
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // Initialize bufferwriter to start writing process
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            // Add string to the end of the file
            writer.append(s);
            writer.newLine();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Encode a student for saving (all information in one line
     *
     * @param student Student to encode
     * @return encoded student
     */
    public String encodeStudent(Student student) {

        // All information is seperated by a pipe "|"
        String s = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",
                student.getFirstName(),
                student.getLastName(),
                student.getMiddleInitials(),
                student.getStudentNumber(),
                student.getGrade(),
                student.getPhoneNumber(),
                student.getEmail(),
                student.getStreetAddress(),
                student.getCity(),
                student.getProvince(),
                student.getPostalCode());
        return s;
    }

    /**
     * Decode the student
     *
     * @param encodedStudent the encoded student string
     * @return Student object after being decoded
     */
    public Student decodeStudent(String encodedStudent) {

        // Split the string by pipe
        String[] studentInfo = encodedStudent.split("\\|");
        int size = studentInfo.length;

        // Create a new object
        Student student = new Student();

        // Add it to object
        try {
            student.setFirstName(studentInfo[0]);
            student.setLastName(studentInfo[1]);
            student.setMiddleInitials(studentInfo[2]);
            student.setStudentNumber(studentInfo[3]);
            student.setGrade(studentInfo[4]);
            student.setPhoneNumber(studentInfo[5]);
            student.setEmail(studentInfo[6]);
            student.setStreetAddress(studentInfo[7]);
            student.setCity(studentInfo[8]);
            student.setProvince(studentInfo[9]);
            student.setPostalCode(studentInfo[10]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            // There was an error setting user information because there is not enough information in the file about a user
            // It's probably missing some user information
            System.err.println("There was an error reading student information. This student will be skipped.");
        }
        return student;
    }

    /**
     * Delete the user data file
     */
    private void deleteUserDataFile() {

        file = new File("user_data.txt");

        // If file exists, delete the file
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * View the student page.
     * When viewing a student, it provides options such as "delete" or "home"
     *
     * @param student Student to take actions on
     */
    private void viewStudentPage(Student student) {
        Messages.showStudentOptions();
        Messages.getInput("Delete|Home");

        switch (input.toLowerCase()) {
            case "delete":
                students.remove(student);
                student = null;

                Messages.showStudentDeletedMessage();
                Messages.showMessage("");
                break;
        }

    }
}
