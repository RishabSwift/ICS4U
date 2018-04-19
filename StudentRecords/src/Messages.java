import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Messages {

    private static boolean DEBUG = true;
    private static Records record;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void startMessage(Records record) {
        Messages.record = record;
        showMessage("--------------------------------", 10);
        showMessage("Welcome to the Student database!");
        showMessage("--------------------------------", 10);
        showMessage("You can add, view or search for a student.");
        showMessage("Type in:");
        showMessage("    Add     to add a new student", 0, 300);
        showMessage("    Search  to search for a student", 0, 300);
        showMessage("    Delete  to delete a student", 0, 300);
        showMessage("    View    to view students using a criteria", 0, 300);
        showMessage("");
    }

    public static String getInput(Validation.Type... validationTypes)  {
        System.out.print("> ");
        try {
            String input = br.readLine();
            Validation validation = new Validation();
            validation.validate(input, validationTypes);
            record.input = input;
            return input;
        } catch (IOException ex) {
            return null;
        }
    }

    public static String getInput(String acceptedAnswers) {
        System.out.print("> ");
        try {
            String input = br.readLine();
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
     * @param character Character to print
     * @param sameLine If it should print the character in the same line
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
     * @param string Text to print
     */
    private static void printToConsole(String string) {
        System.out.println(string);
    }


    /**
     * Animate string so it prints character by character
     *
     * @param text text to animate
     * @param speed speed of the animation
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
