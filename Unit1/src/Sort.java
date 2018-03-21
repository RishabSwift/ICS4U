import java.util.Arrays;

/**
 * This class contains sort algorithms: selection, insertion and bubble
 * It also contains a helpful swap method to swap two elements in an array
 * @author Rishab Bhatt
 *
 */
public class Sort {

	public static void main(String[] args) {

		// to check
		String[] is = { "hell", "up", "xeon", "hello", "she", "said", "fuuu", "you", "lolz" };
		// int[] is = { 1, 3, 5, 19, 0, 32, 3294, 34, 59 };
		// double[] is = { 3.35, 3.1, 5.5, 3.1, 0.5, 0.1, 3.2, 32.5, 34.4 };
		System.out.printf("Unsorted  : %s\n", Arrays.toString(is));
		bubbleSort(is);
		System.out.printf("Sorted bro: %s", Arrays.toString(is));

	}

	/**
	 * Sort an integer array using selection sort
	 * 
	 * @param array
	 *            integer array to sort
	 * 
	 */
	public static void selectionSort(int[] array) {
		// The minimum array index
		int min;
		// Loop through the array to keep track of how many passes we have
		for (int i = 0; i < array.length; i++) {
			min = i; // Set the first minimum index equal to i

			// loop through the array for sorting
			for (int j = i + 1; j < array.length; j++) {
				// check if the current value of array at index j is equal to the minimum value
				// we have above.
				if (array[j] < array[min]) {
					min = j;
				}
			}

			// If the minimum value's index is not equal i, it means we must swap
			if (min != i) {
				swap(array, i, min);
			}
		}
	}

	/**
	 * Sort a double array using selection sort
	 * 
	 * @param array
	 *            double array to sort
	 */
	public static void selectionSort(double[] array) {
		// The minimum array index
		int min;
		// Loop through the array to keep track of how many passes we have
		for (int i = 0; i < array.length; i++) {
			min = i; // Set the first minimum index equal to i

			// loop through the array for sorting
			for (int j = i + 1; j < array.length; j++) {
				// check if the current value of array at index j is equal to the minimum value
				// we have above
				if (array[j] < array[min]) {
					min = j;
				}
			}

			// If the minimum value's index is not equal i, it means we must swap
			if (min != i) {
				swap(array, i, min);
			}
		}
	}

	/**
	 * Sort a String array using selection sort
	 * 
	 * @param array
	 *            string array to sort
	 */
	public static void selectionSort(String[] array) {
		// The minimum array index
		int min;
		// Loop through the array to keep track of how many passes we have
		for (int i = 0; i < array.length; i++) {
			min = i; // Set the first minimum index equal to i

			// loop through the array for sorting
			for (int j = i + 1; j < array.length; j++) {
				// check which of two values at index "j" and index "min" comes first
				// alphabetically
				if (array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}

			// If the minimum value's index is not equal i, it means we must swap
			if (!array[i].equals(array[min])) {
				swap(array, i, min);
			}
		}
	}

	/**
	 * Sort an integer array using selection sort
	 * 
	 * @param array
	 *            integer array to sort
	 */
	public static void insertionSort(int[] array) {
		int num; // the temporary variable to store the min value

		// Loop through the array to keep track of how many passes we make
		for (int i = 1; i < array.length; i++) {
			int j = i;
			num = array[i]; // set num to the current array value at index i

			// Loop backwards to the first element while checking if the element
			// adjacent to it is higher or not
			while (j > 0 && num < array[j - 1]) {
				// Swap
				array[j] = array[j - 1];
				j--;
			}
			array[j] = num;
		}
	}

	/**
	 * Sort a double array using selection sort
	 * 
	 * @param array
	 *            double array to sort
	 */
	public static void insertionSort(double[] array) {
		double num; // the temporary variable to store the min value

		// Loop through the array to keep track of how many passes we make
		for (int i = 1; i < array.length; i++) {
			int j = i;
			num = array[i]; // set num to the current array value at index i

			// Loop backwards to the first element while checking if the element
			// adjacent to it is higher or not
			while (j > 0 && num < array[j - 1]) {
				// Swap
				array[j] = array[j - 1];
				j--;
			}
			array[j] = num;
		}
	}

	/**
	 * Sort a String array using insertion sort
	 * 
	 * @param array
	 *            string array to sort
	 */
	public static void insertionSort(String[] array) {
		String str; // the temporary variable to store the "min" value — in ascending order
		for (int i = 1; i < array.length; i++) {
			int j = i;
			str = array[i]; // set str to the current array value at index i

			// Loop backwards to the first element while checking if the element
			// adjacent to it is higher or not alphabetically
			while (j > 0 && str.compareTo(array[j - 1]) < 0) {
				// Swap
				array[j] = array[j - 1];
				j--;
			}
			array[j] = str;
		}
	}

	/**
	 * Sort an integer array using bubble sort
	 * 
	 * @param array
	 *            integer array to sort
	 */
	public static void bubbleSort(int[] array) {
		// Loop through the array to keep track of passes
		for (int i = 0; i < array.length; i++) {
			// Loop through the same array
			for (int j = 1; j <= array.length - 1; j++) {
				// Keep comparing the value to the one beside it until it is brought to the top
				// of the array
				if (array[j] < array[j - 1]) {
					// And swap...
					swap(array, j, j - 1);
				}
			}
		}
	}

	/**
	 * Sort a double array using bubble sort
	 * 
	 * @param array
	 *            double array to sort
	 */
	public static void bubbleSort(double[] array) {
		// Loop through the array to keep track of passes
		for (int i = 0; i < array.length; i++) {
			// Loop through the same array
			for (int j = 1; j <= array.length - 1; j++) {
				// Keep comparing the value to the one beside it until it is brought to the top
				// of the array
				if (array[j] < array[j - 1]) {
					// And swap...
					swap(array, j, j - 1);
				}
			}
		}
	}

	/**
	 * Sort a String array using bubble sort
	 * 
	 * @param array
	 *            string array to sort
	 */
	public static void bubbleSort(String[] array) {
		// Loop through the array to keep track of passes
		for (int i = 0; i < array.length; i++) {
			// Loop through the same array
			for (int j = 1; j <= array.length - 1; j++) {
				// Keep comparing the value to the one beside it (which one comes last in
				// alphabetical order) until it is brought to the top of the array
				if (array[j].compareTo(array[j - 1]) < 0) {
					// And swap...
					swap(array, j, j - 1);
				}
			}
		}
	}

	/**
	 * Swap two elements in an int array with each other
	 * 
	 * @param array
	 *            String array to swap
	 * @param index1
	 *            array index to swap with
	 * @param index2
	 *            array index to swap to
	 */
	private static void swap(int[] array, int index1, int index2) {
		// Set a temporary variable and set its value to the first index
		int temp = array[index1];
		// Swap the values
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Swap two elements in a double array with each other
	 * 
	 * @param array
	 *            String array to swap
	 * @param index1
	 *            array index to swap with
	 * @param index2
	 *            array index to swap to
	 */
	private static void swap(double[] array, int index1, int index2) {
		// Set a temporary variable and set its value to the first index
		double temp = array[index1];
		// Swap the values
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Swap two elements in a String array with each other
	 * 
	 * @param array
	 *            String array to swap
	 * @param index1
	 *            array index to swap with
	 * @param index2
	 *            array index to swap to
	 */
	private static void swap(String[] array, int index1, int index2) {
		// Set a temporary variable and set its value to the first index
		String temp = array[index1];
		// Swap the values
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
