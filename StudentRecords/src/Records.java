import java.io.*;
import java.util.*;

public class Records {

    public String input = "";

    private static Records record;

    private File file;

    public List<Student> students = new ArrayList<Student>();

    private boolean exit = false;
    private boolean home = false;

    public static void main(String[] args) {
        // Ask what they want to do

        record = new Records();

        record.beginProgram();

        // Add record

        // search student using a field
    }

    public static void setInput() {

    }

    private void beginProgram() {

//        students.add(new Student("John", "Ver", "", "3339394848", "12", "647222838", "johnv@gmail.com", "250 Wellesley St E", "Toronto", "ON", "M2F3K4"));
//        students.add(new Student("Jason", "Blonde", "", "384444848", "9", "6474982838", "verkie@htmail.com", "250 Hark St E", "Toronto", "ON", "M1J1K3"));
//        students.add(new Student("Victoria", "Lol", "", "3337373", "11", "6479824444", "owown@htmail.com", "230 Shit St E", "Toronto", "ON", "M1J39S"));
//        students.add(new Student("Hawdy", "Blow", "", "3337373", "11", "6479824444", "owown@htmail.com", "230 Shit St E", "Toronto", "ON", "M1J39S"));

        while (!exit) {
            Messages.startMessage(record);

            Messages.getInput("Add|Search|Load|Save|Exit");

            switch (input.toLowerCase()) {

                case "add":

                    Student student = addStudent();

                    students.add(student);

                    Messages.addedStudentMessage();

                    Messages.getInput("View|Home");

                    // They can view the student or go home
                    switch (input.toLowerCase()) {

                        case "view":

                            Messages.showStudent(student);

                            Messages.showStudentOptions();
                            Messages.getInput("Delete|Home");

                            switch (input.toLowerCase()) {
                                case "delete":
                                    students.remove(student);
                                    student = null;

                                    Messages.showStudentDeletedMessage();
                                    break;
                            }

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
                        case "yes":

                            // Delete the user data file and save it again
                            deleteUserDataFile();

                            for (Student s : students) {
                                writeFile(encodeStudent(s));
                            }

                            Messages.showMessage("Students have been saved successfully!");
                            Messages.showMessage("");

                            break;

                        case "cancel":
                            students.clear();
                            loadFile();
                            Messages.showMessage("Any unsaved students have been removed!");
                            Messages.showMessage("");
                            break;


                        case "exit":
                            Messages.showMessage("No changes were saved. You can still save it if you wish ");
                            Messages.showMessage("");
                            break;
                    }

                    break;

                case "load":
                    loadUsers();
                    break;

                case "exit":
                    exit = true;
                    break;
                default:

                    break;
            }
        }

        Messages.showExitMessage();

    }

    private Student addStudent() {
        Student student = new Student();

        Messages.addStudentMessage();

        Messages.showMessage("Enter the student's first name");
        student.setFirstName(Messages.getInput(Validation.Type.ALPHA));

        // todo: name the "student" in message to their name for better gui
        Messages.showMessage("Enter the student's last name");
        student.setLastName(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's middle name initials (leave blank if none)");
        student.setMiddleInitials(Messages.getInput(Validation.Type.ALPHA_NONE));

        Messages.showMessage("Enter the student's student ID");
        student.setStudentNumber(Messages.getInput(Validation.Type.STUDENT_NUMBER));

        Messages.showMessage("Enter the student's phone number");
        student.setPhoneNumber(Messages.getInput(Validation.Type.PHONE));

        Messages.showMessage("Enter the student's email address");
        student.setEmail(Messages.getInput(Validation.Type.EMAIL));

        Messages.showMessage("Enter the student's street address");
        student.setStreetAddress(Messages.getInput(Validation.Type.ALPHA_NUM));

        Messages.showMessage("Enter the student's city");
        student.setCity(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's province");
        student.setProvince(Messages.getInput(Validation.Type.ALPHA));

        Messages.showMessage("Enter the student's postal code");
        student.setPostalCode(Messages.getInput(Validation.Type.POSTAL_CODE));

        Messages.showMessage("Enter the student's grade");
        student.setGrade(Messages.getInput(Validation.Type.GRADE));

        return student;
    }

    private void loadUsers() {
        Messages.loadStudentMessage();

        Messages.showMessage("Loading student records from a file...");
        Messages.showMessage("");

        record.loadFile();

        Messages.showMessage(String.format("Total students: %d", students.size()));

        Messages.showMessage("");

        for (Student student : students) {
            student.toString();
        }
    }

    private void loadFile() {

        file = new File("user_data.txt");

        // If file does not exist, we make a new file
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                Student student = decodeStudent(st);
                students.add(student);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.append(s);
            writer.newLine();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        file = new File("user_data.txt");
//
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public String encodeStudent(Student student) {

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

//        System.out.println(s);
        return s;
    }

    public Student decodeStudent(String decodedStudent) {


        String[] studentInfo = decodedStudent.split("\\|");
        int size = studentInfo.length;

        Student student = new Student();

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

    private void deleteUserDataFile() {

        file = new File("user_data.txt");

        // If file exists, delete the file
        if (file.exists()) {
            file.delete();
        }
    }


}
