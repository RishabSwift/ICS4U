import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validation class is responsible for input validation and data parsing
 */
public class Validation {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static enum Type {
        ALPHA, NUM, EMAIL, PROVINCE, POSTAL_CODE
    }

    private enum Provinces {
        AB, BC, MB, NM, NL, NT, NS, NU, ON, PE, QC, SK, YT
    }

    public void validate(String input, Type... types) {
        for (Type type : types) {
            while (!validate(input, type)) {
                Messages.showMessage("");
                Messages.showMessage(errorMessages(type), 30, 0);
                System.out.print("> ");
                try {
                    input = br.readLine();
                } catch (IOException ex) {

                }
            }
        }
    }

    public void validate(String input, String acceptedInput) {
        while (!stringContains(input, acceptedInput)) {
            Messages.showMessage("");
            Messages.showMessage("Error! You can only enter \"" + acceptedInput.replace("|", "\" or \"") + "\".");
            System.out.print("> ");
            try {
                input = br.readLine();
            } catch (IOException ex) {

            }
        }
    }

    private boolean validate(String input, Type type) {
        switch (type) {
            case ALPHA:
                return isAlphabetic(input);
            case NUM:
                return isNumeric(input);
            case EMAIL:
                return isEmail(input);
            case PROVINCE:
                return isProvince(input);
            case POSTAL_CODE:
                return isPostalCode(input);
            default:
                return true;
        }
    }

    private String errorMessages(Type type) {
        switch (type) {
            case ALPHA:
                return "Error! Please ensure you are only entering alphabetical characters!";
            case NUM:
                return "Error! Please ensure you are only entering numbers!";
            case EMAIL:
                return "Error! Please enter a valid email address!";
            case PROVINCE:
                return "Error! Please enter a valid province! (e.g. \"ON\" or \"Ontario\")";
            case POSTAL_CODE:
                return "Error! Please enter a valid postal code (e.g. \"M4X1H8\")!";
            default:
                return "Error! Please enter a valid input!";
        }
    }


    private boolean isAlphabetic(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumeric(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }


    private boolean isEmail(String input) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

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
}
