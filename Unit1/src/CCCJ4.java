import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CCCJ4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();

		while (!line.equals("0")) {

			// Check if they have entered letters
			if (isValidInput(line)) {

				convertToPostfix(line);

				line = scan.nextLine();

			} else {

				System.out.println("Please enter a valid input!");
				line = scan.nextLine();
			}

		}

		System.out.println("Program Finished");
		
	
	}
	

	/**
	 * If they have entered a valid input i.e. no characters
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValidInput(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void convertToPostfix(String line) {
		
		ArrayList<String> finalAnswer = new ArrayList<String>(); 
		
		// get the prefix in the array so each character is an element in the array
		String[] prefix = line.split(" ");
		
		// Store the final postfix in stack so we can pop and pus!
		Stack<String> postfix = new Stack<String>();
		
		String operand1, operand2;

	
		
		// Loop through the prefix array backwards and start checking if there is an operator
		for (int i = prefix.length - 1; i >= 0; i--) {

			// If it's not an operator... push the element into the stack
			if (Character.isDigit(prefix[i].charAt(0))) {
				String string = postfix.push(prefix[i]);
				System.out.println("Just popped " + string);
				
				// It seems like the character is a operator
			} else {
				
				// Take the last two and add the operator at the end
				operand1 = postfix.pop();
				operand2 = postfix.pop();
				
				System.out.println(" Just popped operator 1 and 2 >> " + operand1 + " & " + operand2);
				
				// Parse it together
				postfix.push(operand1 + " " + operand2 + " " + prefix[i]);
				
				
				System.out.println("Just pushed " + (operand1 + " " + operand2 + " " + prefix[i]));
			}
			
		}
		
		finalAnswer.add(postfix.pop());
		
		for (String s : finalAnswer ) {
			System.out.println(s);
		}
		
		
	}
	

}