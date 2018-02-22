import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CCCJ4 {

	public static final boolean DEBUG = false;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();

		while (!line.equals("0")) {

			// Check if they have entered letters
			if (isValidInput(line)) {

				System.out.println(convertToPostfix(line));

				line = scan.nextLine();

			} else {

				System.out.println("Please enter a valid input!");
				line = scan.nextLine();
			}

		}

		if (DEBUG)
			System.out.println("Program Finished");

	}

	/**
	 * Convert prefix to postfix
	 * 
	 * @param line
	 */
	public static String convertToPostfix(String line) {

		// get the prefix in the array so each character is an element in the array
		String[] prefix = line.split(" ");

		// Store the final postfix in stack so we can pop and pus!
		Stack<String> postfix = new Stack<String>();

		String operand1, operand2;

		// Loop through the prefix array backwards and start checking if there is an
		// operator
		for (int i = prefix.length - 1; i >= 0; i--) {

			// If it's not an operator... push the element into the stack
			if (Character.isDigit(prefix[i].charAt(0))) {
				String string = postfix.push(prefix[i]);

				if (DEBUG)
					System.out.println("Just popped " + string);

				// It seems like the character is a operator
			} else {

				// Take the last two and add the operator at the end
				operand1 = postfix.pop();
				operand2 = postfix.pop();

				if (DEBUG)
					System.out.println(" Just popped operator 1 and 2 >> " + operand1 + " & " + operand2);

				// Parse it together
				postfix.push(operand1 + " " + operand2 + " " + prefix[i]);

				if (DEBUG)
					System.out.println("Just pushed " + (operand1 + " " + operand2 + " " + prefix[i]));
			}

		}

		// The stack will now have the final answer at the top of the list...
		// we need to get that and return it
		return postfix.pop();
	}

	/**
	 * If they have entered a valid input i.e. no characters
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isValidInput(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
