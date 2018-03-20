import java.util.PrimitiveIterator.OfDouble;
import java.util.logging.Logger;

public class RecursionExamples {

	static String binToDecimalAns = "";

	public static void main(String[] args) {

		System.out.println(decToBin(392));

	}

	/**
	 * Calculate factorial using recursion
	 * 
	 * @param n
	 *            To number to calculate the factorial for
	 * @return 
	 * 			the factorial of n
	 */
	public static int factorial(int n) {
		return n <= 1 ? 1 : n * factorial(n - 1);
	}

	/**
	 * Return the sum of all numbers between 0 and n using recursion
	 * 
	 * @param n
	 *            The number to add the sums of
	 * @return
	 * 			the sum of all numbers
	 */
	public static int sum(int n) {
		return n <= 0 ? 0 : n + sum(n - 1);
	}

	/**
	 * Return a to the power of b using recursion
	 * 
	 * @param a
	 *            The first number
	 * @param b
	 *            The degree
	 * @return
	 * 			the exponent value of a^b
	 */
	public static long exponent(int a, int b) {
		// The exponent value of 2^5 for instance is 2 * 2 * 2 * 2 * 2
		// We just keep multiplying until we reach 1
		return b <= 0 ? 1 : a * exponent(a, b - 1);
	}

	/**
	 * Convert decimal to binary
	 * 
	 * @param num
	 * 				The decimal
	 * @return
	 * 				Binary version of decimal
	 * 		
	 */
	public static long decToBin(int num) {
		// If number is greater than 0
		// Then divide it by two and then add the modulus 2 of the value to the string
		if (num > 0) {
			decToBin(num / 2);
			binToDecimalAns += (num % 2);
		}

		// Convert the string to long and return it
		try {
			return Long.parseLong(binToDecimalAns);
		} catch (Exception exception) {
			// We get a Number format exception because the string is empty.
		}
		// It never gets here, so we can return 0
		return 0;
	}

	/**
	 * Convert binary to decimal
	 * 
	 * @param n
	 *            The binary value
	 * @return
	 * 				The decimal equivalent of binary
	 */
	public static long binToDec(long n) {
		// Use another method to do the conversion as it's easier to
		// work with string
		return binaryToDecimalHelper(String.valueOf(n)); 
	}

	/**
	 * Helper to convert binary to decimal
	 * 
	 * @param binary
	 *            The binary in string
	 * @return
	 * 			The decimal in string
	 */
	public static int binaryToDecimalHelper(String binary) {
		// Get the length
		int length = binary.length();

		if (length == 0) {
			return 0;
		}
		// The first "digit"
		String beginning = binary.substring(0, 1);
		// the rest of the input
		String end = binary.substring(1);
		return Integer.parseInt(beginning) * (int) Math.pow(2, length - 1) + binaryToDecimalHelper(end);
	}

}
