import java.util.Arrays;

/**
 * This class contains sort algorithms: selection, insertion and bubble, quick, merge
 * It also contains a helpful swap method to swap two elements in an array
 * @author Rishab Bhatt
 *
 */
public class Sort {

	public static void main(String[] args) {

		// to check
		String[] is = { "hell", "up", "xeon", "hello", "she", "said", "fuuu", "you", "lolz" };
//		 int[] is = { 2, 1, 3, 4, 8, 5, 7, 6};
//		 double[] is = { 3.35, 3.1, 5.5, 3.1, 0.5, 0.1, 3.2, 32.5, 34.4 };
		System.out.printf("Unsorted  : %s\n", Arrays.toString(is));
		mergeSort(is);
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

	/**
	 * Quick sort algorithm
	 * @param array
	 * 			unsorted int array
	 */
	private static void quickSort(int[] array) {
		quickSort(array, 0, array.length-1);
	}

	/**
	 * Quick sort algorithm
	 * @param array
	 * 			unsorted double array
	 */
	private static void quickSort(double[] array) {
		quickSort(array, 0, array.length-1);
	}

	/**
	 * Quick sort algorithm
	 * @param array
	 * 			unsorted String array
	 */
	private static void quickSort(String[] array) {
		quickSort(array, 0, array.length-1);
	}

	/**
	 * Recursive QuickSort method so arrays can be segmented
	 * @param array
	 * 			integer array
	 * @param start
	 * 			array start index
	 * @param end
	 * 			array end index
	 */
	private static void quickSort(int[] array, int start, int end) {
		// Only sort if start < end (recursive statement)
		if (start >= end) return;
		// Get the pivot index
		int pivot = partition(array, start, end);
		// There are two splits, sort the split recursively
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	/**
	 * Recursive QuickSort method so arrays can be segmented
	 * @param array
	 * 			double array
	 * @param start
	 * 			array start index
	 * @param end
	 * 			array end index
	 */
	private static void quickSort(double[] array, int start, int end) {
		// Only sort if start < end (recursive statement)
		if (start >= end) return;
		// Get the pivot index
		int pivot = partition(array, start, end);
		// There are two splits, sort the split recursively
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	/**
	 * Recursive QuickSort method so arrays can be segmented
	 * @param array
	 * 			String array
	 * @param start
	 * 			array start index
	 * @param end
	 * 			array end index
	 */
	private static void quickSort(String[] array, int start, int end) {
		// Only sort if start < end (recursive statement)
		if (start >= end) return;
		// Get the pivot index
		int pivot = partition(array, start, end);
		// There are two splits, sort the split recursively
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	/**
	 * Partition method used by Quick Sort algorithm
	 * @param array
	 * 			integer array
	 * @param start
	 * 			array index to start partition
	 * @param end
	 * 			array index to end partition
	 * @return
	 * 		pivot index
	 */
	private static int partition(int[] array, int start, int end){

		// The pivot is the very last element in the array (or segment)
		int pivot = array[end];
		// The pivot index for now starts that the beginning
		int pivotIndex = start;

		// Loop through the provided array
		for (int i = start; i < end; i++) {
			// If the element at i is less than or equal to the pivot,
			// a swap must happen in order to move the greater numbers to the right and the lower numbers to the left
			if (array[i] <= pivot) {
				swap(array, i, pivotIndex);
				// Increase the pivot by 1
				pivotIndex++;
			}
		}

		// Swap the pivot index and the end value of the array after a successful partition
		swap(array, pivotIndex, end);
		// Return the pivot index
		return pivotIndex;

	}
	/**
	 * Partition method used by Quick Sort algorithm
	 * @param array
	 * 			double array
	 * @param start
	 * 			array index to start partition
	 * @param end
	 * 			array index to end partition
	 * @return
	 * 		pivot index
	 */
	private static int partition(double[] array, int start, int end) {

		// The pivot is the very last element in the array (or segment)
		double pivot = array[end];
		// The pivot index for now starts that the beginning
		int pivotIndex = start;

		// Loop through the provided array
		for (int i = start; i < end; i++) {
			// If the element at i is less than or equal to the pivot,
			// a swap must happen in order to move the greater numbers to the right and the lower numbers to the left
			if (array[i] <= pivot) {
				swap(array, i, pivotIndex);
				// Increase the pivot by 1
				pivotIndex++;
			}
		}

		// Swap the pivot index and the end value of the array after a successful partition
		swap(array, pivotIndex, end);
		// Return the pivot index
		return pivotIndex;

	}
	/**
	 * Partition method used by Quick Sort algorithm
	 * @param array
	 * 			String array
	 * @param start
	 * 			array index to start partition
	 * @param end
	 * 			array index to end partition
	 * @return
	 * 		pivot index
	 */
	private static int partition(String[] array, int start, int end) {
		// The pivot is the very last element in the array (or segment)
		String pivot = array[end];
		// The pivot index for now starts that the beginning
		int pivotIndex = start;

		// Loop through the provided array
		for (int i = start; i < end; i++) {
			// If the element at i is less than or equal to the pivot,
			// a swap must happen in order to move the greater numbers to the right and the lower numbers to the left
			if (array[i].compareTo(pivot) < 0) {
				swap(array, i, pivotIndex);
				// Increase the pivot by 1
				pivotIndex++;
			}
		}

		// Swap the pivot index and the end value of the array after a successful partition
		swap(array, pivotIndex, end);
		// Return the pivot index
		return pivotIndex;
	}


	/**
	 * Merge sort algorithm
	 * @param array
	 * 			unsorted int array
	 */
	private static int[] mergeSort(int[] array) {
		// If the length is just one, we know tha the array has a single element
		// This is a the statement that stops recursion from overflowing
		if (array.length == 1) {
			return array;
		}
		// Two temporary arrays to store values left and right of the number
		int aLength1 = array.length / 2;
		int aLength2 = array.length - aLength1;
		int leftArray[] = new int[aLength1];
		int rightArray[] = new int[aLength2];

//		for (int i = 0; i < aLength1; i++) {
//			leftArray[i] = array[i];
//		}
//		for (int i = aLength1; i < aLength1 + aLength2; i++) {
//			rightArray[i-aLength1] = array[i];
//		}
		// Copy array to fill the "left" and "right" array
		System.arraycopy(array, 0, leftArray, 0, aLength1);
		System.arraycopy(array, aLength1, rightArray, 0, aLength1 + aLength2 - aLength1);

		// Merge Sort the "left" and "right" arrays further until there is only one element left
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);

		// Merge the two left and right arrays sorted
		// Save the value in the original array variable so it takes change in memory as well
		int[] newArray = merge(leftArray, rightArray);
		System.arraycopy(newArray, 0, array, 0, newArray.length);
		return array;
	}

	/**
	 * Merge sort algorithm
	 * @param array
	 * 			unsorted double array
	 */
	private static double[] mergeSort(double[] array) {
		// If the length is just one, we know tha the array has a single element
		// This is a the statement that stops recursion from overflowing
		if (array.length == 1) {
			return array;
		}
		// Two temporary arrays to store values left and right of the number
		int aLength1 = array.length / 2;
		int aLength2 = array.length - aLength1;
		double leftArray[] = new double[aLength1];
		double rightArray[] = new double[aLength2];

//		for (int i = 0; i < aLength1; i++) {
//			leftArray[i] = array[i];
//		}
//		for (int i = aLength1; i < aLength1 + aLength2; i++) {
//			rightArray[i-aLength1] = array[i];
//		}
		// Copy array to fill the "left" and "right" array
		System.arraycopy(array, 0, leftArray, 0, aLength1);
		System.arraycopy(array, aLength1, rightArray, 0, aLength1 + aLength2 - aLength1);

		// Merge Sort the "left" and "right" arrays further until there is only one element left
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);

		// Merge the two left and right arrays sorted
		// Save the value in the original array variable so it takes change in memory as well
		double[] newArray = merge(leftArray, rightArray);
		System.arraycopy(newArray, 0, array, 0, newArray.length);
		return array;
	}

	/**
	 * Merge sort algorithm
	 * @param array
	 * 			unsorted String array
	 */
	private static String[] mergeSort(String[] array) {
		// If the length is just one, we know tha the array has a single element
		// This is a the statement that stops recursion from overflowing
		if (array.length == 1) {
			return array;
		}
		// Two temporary arrays to store values left and right of the number
		int aLength1 = array.length / 2;
		int aLength2 = array.length - aLength1;
		String leftArray[] = new String[aLength1];
		String rightArray[] = new String[aLength2];

//		for (int i = 0; i < aLength1; i++) {
//			leftArray[i] = array[i];
//		}
//		for (int i = aLength1; i < aLength1 + aLength2; i++) {
//			rightArray[i-aLength1] = array[i];
//		}
		// Copy array to fill the "left" and "right" array
		System.arraycopy(array, 0, leftArray, 0, aLength1);
		System.arraycopy(array, aLength1, rightArray, 0, aLength1 + aLength2 - aLength1);

		// Merge Sort the "left" and "right" arrays further until there is only one element left
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);

		// Merge the two left and right arrays sorted
		// Save the value in the original array variable so it takes change in memory as well
		String[] newArray = merge(leftArray, rightArray);
		System.arraycopy(newArray, 0, array, 0, newArray.length);
		return array;
	}


	/**
	 * Merge two int arrays together
	 * @param array1
	 * 			First array to merge
	 * @param array2
	 * 			Second array to merge
	 * @return
	 * 			merged array
	 */
	private static int[] merge(int[] array1, int[] array2) {
		// Need a new array that is long enough to fit both
		int newArray[] = new int[array1.length + array2.length];
		// The array index of array 1 and 2 — keeping track of where we are to compare
		int array1Index = 0, array2Index = 0;
		// Loop through new array
		for (int i = 0; i < newArray.length; i++) {
			// If the first number in the first array is smaller than the first number in the second array
			if (array1[array1Index] < array2[array2Index]) {
				// If so... add that to the current i position of the new array
				newArray[i] = array1[array1Index];
				// ... increment the array1's index
				array1Index++;

				// If the first array's index is as long as its length.. that means that we must take care of array2
				if (array1Index == array1.length) {
					for (int j = i+1; j < newArray.length; j++) {
						newArray[j] = array2[array2Index];
						array2Index++;
					}
					break;
				}
			} else {
				// Else scenario for array 2
				newArray[i] = array2[array2Index];
				array2Index++;

				if (array2Index == array2.length) {
					for (int j = i+1; j < newArray.length; j++) {
						newArray[j] = array1[array1Index];
						array1Index++;
					}
					break;
				}
			}
		}
		// Return the newly merged array
		return newArray;
	}

	/**
	 * Merge two double arrays together
	 * @param array1
	 * 			First array to merge
	 * @param array2
	 * 			Second array to merge
	 * @return
	 * 			merged array
	 */
	private static double[] merge(double[] array1, double[] array2) {
		// Need a new array that is long enough to fit both
		double newArray[] = new double[array1.length + array2.length];
		// The array index of array 1 and 2 — keeping track of where we are to compare
		int array1Index = 0, array2Index = 0;
		// Loop through new array
		for (int i = 0; i < newArray.length; i++) {
			// If the first number in the first array is smaller than the first number in the second array
			if (array1[array1Index] < array2[array2Index]) {
				// If so... add that to the current i position of the new array
				newArray[i] = array1[array1Index];
				// ... increment the array1's index
				array1Index++;

				// If the first array's index is as long as its length.. that means that we must take care of array2
				if (array1Index == array1.length) {
					for (int j = i+1; j < newArray.length; j++) {
						newArray[j] = array2[array2Index];
						array2Index++;
					}
					break;
				}
			} else {
				// Else scenario for array 2
				newArray[i] = array2[array2Index];
				array2Index++;

				if (array2Index == array2.length) {
					for (int j = i+1; j < newArray.length; j++) {
						newArray[j] = array1[array1Index];
						array1Index++;
					}
					break;
				}
			}
		}
		// Return the newly merged array
		return newArray;
	}

	/**
	 * Merge two int arrays together
	 * @param array1
	 * 			First array to merge
	 * @param array2
	 * 			Second array to merge
	 * @return
	 * 			merged array
	 */
	private static String[] merge(String[] array1, String[] array2) {
		// Need a new array that is long enough to fit both
		String newArray[] = new String[array1.length + array2.length];
		// The array index of array 1 and 2 — keeping track of where we are to compare
		int array1Index = 0, array2Index = 0;
		// Loop through new array
		for (int i = 0; i < newArray.length; i++) {
			// If the first number in the first array is smaller than the first number in the second array
			if (array1[array1Index].compareTo(array2[array2Index]) < 0) {
					// If so... add that to the current i position of the new array
				newArray[i] = array1[array1Index];
				// ... increment the array1's index
				array1Index++;

				// If the first array's index is as long as its length.. that means that we must take care of array2
				if (array1Index == array1.length) {
					for (int j = i+1; j < newArray.length; j++) {
						newArray[j] = array2[array2Index];
						array2Index++;
					}
					break;
				}
			} else {
				// Else scenario for array 2
				newArray[i] = array2[array2Index];
				array2Index++;

				if (array2Index == array2.length) {
					for (int j = i+1; j < newArray.length; j++) {
						newArray[j] = array1[array1Index];
						array1Index++;
					}
					break;
				}
			}
		}
		// Return the newly merged array
		return newArray;
	}



}
