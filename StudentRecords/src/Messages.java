import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is responsible for showing different messages such as welcome messages, and also getting user input form user
 */
public class Messages {

    // Debug Mode
    public static boolean DEBUG = true;
    private static Records record;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * The start message that is shown when the application is run for the first time
     * @param record Records instance
     */
    public static void startMessage(Records record) {
        Messages.record = record;
        showMessage("--------------------------------", 10);
        showMessage("Welcome to the Student database!");
        showMessage("--------------------------------", 10);
        showMessage("You can add, view or search for a student.");
        showMessage("Type in:");
        showMessage("    Add     to add a new student", 0, 300);
        showMessage("    Search  to search for a student", 0, 300);
        showMessage("    Load    to load students from a file", 0, 300);
        showMessage("    Save    to save all added/deleted students to file", 0, 300);
        showMessage("    Exit    to end application", 0, 300);
        showMessage("");
    }

    public static void addStudentMessage() {
        showMessage("--------------------------------", 10);
        showMessage("Add a new student");
        showMessage("--------------------------------", 10);
        showMessage("");
    }

    public static void addedStudentMessage() {
        showMessage("Student has been added successfully!");
        showMessage("Type in:");
        showMessage("    View   to see this student", 0, 300);
        showMessage("    Home   to go back to main menu", 0, 300);
        showMessage("");
    }

    public static void loadStudentMessage() {
        showMessage("--------------------------------", 10);
        showMessage("Load Students");
        showMessage("--------------------------------", 10);
        showMessage("");
    }

    public static void saveStudentsMessage() {
        showMessage("Do you want to save all the changes you have made for students?");
        showMessage("This will save any new or deleted students.");
        showMessage("Type in:");
        showMessage("    Yes     to save all students", 0, 300);
        showMessage("    Cancel  to cancel any changes made", 0, 300);
        showMessage("    Exit    to go back to main menu", 0, 300);
        showMessage("");
    }

    public static void showStudent(Student student) {
        showMessage(String.format("Name:       %s", student.getFullName()));
        showMessage(String.format("Grade:      %s", student.getGrade()));
        showMessage(String.format("Student #:  %s", student.getStudentNumber()));
        showMessage(String.format("Address:    %s", student.getFormattedAddress()));
        showMessage(String.format("Email:      %s", student.getEmail()));
        showMessage(String.format("Phone:      %s", student.getPhoneNumber()));
        showMessage("");
    }

    public static void showStudentOptions() {
        showMessage("Type in:");
        showMessage("    Delete   to delete this student", 0, 300);
        showMessage("    Home     to go back to main menu", 0, 300);
    }

    public static void showExitMessage() {
        showMessage("--------------------------------", 10);
        showMessage("Have a good day!");
        showMessage("--------------------------------", 10);
    }

    public static void showStudentDeletedMessage() {
        showMessage("This student has been deleted successfully!");
    }
    /**
     * Get user input from console while checking if it's a valid input by validating it
     * @param validationType check if input passes the given validation type
     * @return user input
     */
    public static String getInput(Validation.Type validationType) {
        System.out.print("> ");
        try {
            String input = br.readLine();
            showMessage("");


            Validation validation = new Validation();
            validation.validate(input, validationType);
            record.input = input;
            return input;
        } catch (IOException ex) {
            return null;
        }
    }


    /**
     * Get user input from console while checking if it contains the accepted input
     * @param acceptedAnswers the accepted answers that the input must contain (seperated by pipe "|")
     * @return user input
     */
    public static String getInput(String acceptedAnswers) {
        System.out.print("> ");
        try {
            String input = br.readLine();
            showMessage("");

            Validation validation = new Validation();
            validation.validate(input, acceptedAnswers);
            record.input = input;
            return input;
        } catch (IOException ex) {
            return null;
        }
    }

    /**
     * Show a message by animating it
     *
     * @param message
     */
    public static void showMessage(String message) {
        animateString(message, 0, 50, false);
    }

    public static void showMessage(String message, int speed) {
        animateString(message, speed, 100, false);
    }

    public static void showMessage(String message, int speed, int pause) {
        animateString(message, speed, pause, false);
    }

    /**
     * Print a character to console
     *
     * @param character Character to print
     * @param sameLine  If it should print the character in the same line
     */
    private static void printToConsole(char character, boolean sameLine) {
        if (sameLine) {
            System.out.print(character);
        } else {
            System.out.println(character);
        }
    }

    /**
     * Print text to console
     *
     * @param string Text to print
     */
    private static void printToConsole(String string) {
        System.out.println(string);
    }


    /**
     * Animate string so it prints character by character
     *
     * @param text       text to animate
     * @param speed      speed of the animation
     * @param pauseTimer How long it should pause for in milliseconds after printing the string
     */
    private static void animateString(String text, int speed, int pauseTimer, boolean sameLine) {

        try {

            for (int i = 0; i < text.length(); i++) {

                if (!DEBUG) {
                    Thread.sleep(speed);
                }

                printToConsole(text.charAt(i), true);

                // if text has a period and text after it, it probably means
                // that there are more than one sentences in the text
                // Pause for a moment after the period before showing another
                // sentence
                if ((text.charAt(i) == '.' || text.charAt(i) == '!')) {
                    // this if statement ensures that we don't get an
                    // ArrayOutOfBounds exception
                    if (text.length() != i + 1 && text.charAt(i + 1) == ' ') {
                        if (!DEBUG) {
                            Thread.sleep(500);
                        }
                    }
                }

            }

            if (!sameLine) {
                // Print a new line after
                printToConsole("");
            }

            if (!DEBUG) {
                if (pauseTimer > 0) {
                    Thread.sleep(pauseTimer);
                } else {
                    Thread.sleep(1000);
                }
            }

        } catch (InterruptedException ie) {
            // if something goes wrong just print it normally
            printToConsole(text);
        }
    }

}
