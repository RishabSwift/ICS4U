import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validation class is responsible for input validation and data parsing
 *
 * @author Rishab Bhatt
 */
public class Validation {


    // ENABLE TO BYPASS ALL VALIDATIONS
    private boolean DEBUG = false;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * The different validation types
     */
    public static enum Type {
        ALPHA, ALPHA_NUM, ALPHA_NONE, NUM, EMAIL, PROVINCE, POSTAL_CODE, PHONE, STUDENT_NUMBER, GRADE
    }

    /**
     * The different provinces
     */
    private enum Provinces {
        AB, BC, MB, NM, NL, NT, NS, NU, ON, PE, QC, SK, YT
    }

    /**
     * Validate the user input by checking if it's a certain type (e.g. a phone number)
     *
     * @param input User input
     * @param type  Type of validation
     */
    public void validate(String input, Type type) {
        while (!inputIsValid(input, type)) {
            Messages.showMessage(errorMessages(type), 30, 0);
            System.out.print("> ");
            try {
                input = br.readLine();
            } catch (IOException ex) {

            }
            Messages.showMessage("");
        }

        Messages.input = input;
    }

    /**
     * Validate user input by checking if they have entered only what they are allowed to enter.
     * For example, if you ask a user to pick between two colors (like "red" and "blue"), they can only type in one of those
     * The accepted input is a strong that contains the many different accepted input seperated by a pipe "|"
     * E.g. acceptedInput = "blue|gray"
     *
     * @param input         User input
     * @param acceptedInput what the user can enter
     */
    public void validate(String input, String acceptedInput) {
        while (!stringContains(input, acceptedInput)) {
            Messages.showMessage("Error! You can only enter \"" + acceptedInput.replace("|", "\" or \"") + "\".");
            System.out.print("> ");
            try {
                input = br.readLine();
            } catch (IOException ex) {

            }

            Messages.showMessage("");
        }

        Messages.input = input;
    }

    /**
     * Internal validation method that validates different type of input
     *
     * @param input User input
     * @param type  Validation Type
     * @return true if validation passes
     */
    private boolean inputIsValid(String input, Type type) {

        if (DEBUG) return true;

        switch (type) {
            case ALPHA:
                return isAlphabetic(input);
            case NUM:
                return isNumeric(input);
            case ALPHA_NUM:
                return isAlphabetic(input) || isNumeric(input) || input.contains(" ");
            case ALPHA_NONE:
                return isAlphabetic(input) || input.equals(""); // input can be alpha or empty
            case EMAIL:
                return isEmail(input);
            case PROVINCE:
                return isProvince(input);
            case POSTAL_CODE:
                return isPostalCode(input);
            case PHONE:
                return isNumeric(input) && input.length() == 10;
            case STUDENT_NUMBER:
                return input.length() == 9;
            case GRADE:
                return isValidGrade(input);
            default:
                return true;
        }
    }

    /**
     * There are different validation types, and this handles the error messages should each validation go wrong
     *
     * @param type validation type
     * @return the error message
     */
    private String errorMessages(Type type) {
        switch (type) {
            case ALPHA:
                return "Error! Please ensure you are only entering alphabetical characters!";
            case NUM:
                return "Error! Please ensure you are only entering numbers!";
            case ALPHA_NUM:
                return "Error! Please ensure you are only entering alphanumeric characters!";
            case EMAIL:
                return "Error! Please enter a valid email address!";
            case PROVINCE:
                return "Error! Please enter a valid province! (e.g. \"ON\" or \"Ontario\")";
            case POSTAL_CODE:
                return "Error! Please enter a valid postal code (e.g. \"M4X1H8\")!";
            case PHONE:
                return "Error! Please enter a valid phone number!";
            case STUDENT_NUMBER:
                return "Error! Please enter a valid student number! It is 9 digits in length";
            case GRADE:
                return "Error! This student must be in grades 9-12";
            default:
                return "Error! Please enter a valid input!";
        }
    }


    /**
     * Check if the given input only contains alphabetic characters
     *
     * @param input user input to check
     * @return true if characters are only alphabetic
     */
    private boolean isAlphabetic(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the given input is a number
     *
     * @param input user input to check
     * @return true if it's a number
     */
    private boolean isNumeric(String input) {
        // Need this try-catch block to catch any errors while parsing
        // If there is an error while parsing the long value, then we know it's not a number
        // If there is no issue, then it's a number
        try {
            long number = Long.parseLong(input);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }


    /**
     * Check if a given input is an email address by using regular expressions
     *
     * @param input input email address
     * @return true if email
     */
    private boolean isEmail(String input) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Check if the given input is a province.
     *
     * @param input short or full form of province
     * @return true if given input is a province
     */
    private boolean isProvince(String input) {
        input = input.toLowerCase();
        return stringContains(input, "ab|alberta")
                || stringContains(input, "bc|british columbia")
                || stringContains(input, "mb|manitoba")
                || stringContains(input, "nb|new brunswick")
                || stringContains(input, "nl|newfoundland and labrador")
                || stringContains(input, "nt|northwest territories")
                || stringContains(input, "ns|nova scotia")
                || stringContains(input, "nu|nunavut")
                || stringContains(input, "on|ontario")
                || stringContains(input, "pe|prince edward island")
                || stringContains(input, "qc|quebec")
                || stringContains(input, "sk|saskatchewan")
                || stringContains(input, "yt|yukon");
    }

    /**
     * If a string is one of the accepted inputs
     * For example, if you ask for a province then they can either enter "ON" or "ontario". Both are valid.
     * So the acceptedInputs would be "ON|Ontario" (separated by pipe "|")
     *
     * @param input          Input to check
     * @param acceptedInputs Accepted strings separated by |
     * @return true if string contains the accepted inputs
     */
    private boolean stringContains(String input, String acceptedInputs) {
        input = input.toLowerCase();
        acceptedInputs = acceptedInputs.toLowerCase();
        String[] acceptedInputList = acceptedInputs.split("\\|");
        List<String> acceptedList = Arrays.asList(acceptedInputList);
        return acceptedList.contains(input);
    }

    // to get province from file string
    public String getProvince(String province) {
        province = province.toUpperCase();
        switch (province) {
            case "AB":
                return "Alberta";
            case "BC":
                return "British Columbia";
            case "MB":
                return "Manitoba";
            case "NM":
                return "New Brunswick";
            case "NL":
                return "Newfoundland and Labrador";
            case "NT":
                return "Northwest Territories";
            case "NS":
                return "Nova Scotia";
            case "NU":
                return "Nunavut";
            case "ON":
                return "Ontario";
            case "PE":
                return "Prince Edward Island";
            case "QC":
                return "Quebec";
            case "SK":
                return "Saskatchewan";
            case "YT":
                return "Yukon";
            default:
                return "None";
        }
    }

    /**
     * Check if the given input is a postal code
     *
     * @param input Postal code
     * @return true if it's postal code
     */
    private boolean isPostalCode(String input) {
        // get rid of the space if they entered one in the middle
        input.replace(" ", "");
        // check if it's 6 characters long
        if (input.length() != 6) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            // The postal code alternates between number and letter (first one being the letter)
            if (i % 2 == 1) {
                if (!Character.isDigit(input.charAt(i))) {
                    return false;
                }
            } else {
                if (!Character.isLetter(input.charAt(i))) {
                    return false;
                }
            }

        }
        // If we get this far, that means it's a valid postal code
        return true;
    }

    /**
     * Check if the input is a grade (number between 9-12)
     *
     * @param input user input
     * @return true if user is in grades 9-12
     */
    private boolean isValidGrade(String input) {
        if (!isNumeric(input)) {
            return false;
        }

        // Convert to integer
        int grade = Integer.parseInt(input);
        // Check if user is in grade 9-12
        return grade >= 9 && grade <= 12;

    }

}
