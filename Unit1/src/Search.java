/**
 * This class contains search algorithms (binary and linear)
 * This class can sort an int, double or String array (array must be sorted for binary search)
 *  @author Rishab Bhatt
 */
public class Search {

    public static void main(String[] args) {
        String[] array = {"Hello", "there", "what", "zow"};
//        int[] array = {1, 3, 4, 48, 92, 100, 8758};
//        double[] array = {1.44, 3.14, 4.0, 6.8};

        System.out.println(binarySearch(array, "zow"));
    }

    /**
     * Search for a number in an int array (sequential search)
     *
     * @param array int array to search in
     * @param key   number to search for
     * @return index of found number
     */
    public static int linearSearch(int[] array, int key) {
        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            // Check if the current number at index i is equal to the key
            if (array[i] == key) {
                // If it is, return the index
                return i;
            }
        }
        // Return -1 if not found
        return -1;
    }

    /**
     * Search for a number in a double array (sequential search)
     *
     * @param array double array to search in
     * @param key   number to search for
     * @return index of found number
     */
    public static int linearSearch(double[] array, double key) {
        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            // Check if the current number at index i is equal to the key
            if (array[i] == key) {
                // If it is, return the index
                return i;
            }
        }
        // Return -1 if not found
        return -1;
    }

    /**
     * Search for a number in a String array (sequential search)
     *
     * @param array int array to search in
     * @param key   word to search for
     * @return index of found word
     */
    public static int linearSearch(String[] array, String key) {
        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            // Check if the current number at index i is equal to the key
            if (array[i].equals(key)) {
                // If it is, return the index
                return i;
            }
        }
        // Return -1 if not found
        return -1;
    }

    /**
     * Binary search for a sorted integer array
     * @param array sorted int array
     * @param key number to search for
     * @return index of found number
     */
    public static int binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length);
    }
    /**
     * Binary search for a sorted double array
     * @param array sorted double array
     * @param key number to search for
     * @return index of found number
     */
    public static int binarySearch(double[] array, double key) {
        return binarySearch(array, key, 0, array.length);
    }

    /**
     * Binary search for a sorted String array
     * @param array sorted String array
     * @param key word to search for
     * @return index of found word
     */
    public static int binarySearch(String[] array, String key) {
        return binarySearch(array, key, 0, array.length);
    }

    /**
     *
     * @param array Binary search for a sorted int array
     * @param key number to search for
     * @param start index of where to start from in an array
     * @param end index of where to end in an array
     * @return index of found number
     */
    private static int binarySearch(int[] array, int key, int start, int end) {
        // Make sure the end index is greater than 0 (basically not 0)
        if (end > 0) {
            // The middle index of the array
            int mid = (start + end) / 2;

            // Check if the middle number in the array is equal to the key
            if (array[mid] == key) {
                return mid;
            }

            // Check if the key is greater than the middle number
            if (key > array[mid]) {
                // If it is, then search from the mid + 1 up to the end
                return binarySearch(array, key, mid + 1, end);
            }

            // If the key is less than the mid, do recursion on the array from start to the mid - 1
            return binarySearch(array, key, start, mid - 1);
        }

        // Return -1 if not found
        return -1;
    }

    /**
     *
     * @param array Binary search for a sorted double array
     * @param key number to search for
     * @param start index of where to start from in an array
     * @param end index of where to end in an array
     * @return index of found number
     */
    private static int binarySearch(double[] array, double key, int start, int end) {
        // Make sure the end index is greater than 0 (basically not 0)
        if (end > 0) {
            // The middle index of the array
            int mid = (start + end) / 2;

            // Check if the middle number in the array is equal to the key
            if (array[mid] == key) {
                return mid;
            }

            // Check if the key is greater than the middle number
            if (key > array[mid]) {
                // If it is, then search from the mid + 1 up to the end
                return binarySearch(array, key, mid + 1, end);
            }

            // If the key is less than the mid, do recursion on the array from start to the mid - 1
            return binarySearch(array, key, start, mid - 1);
        }

        // Return -1 if not found
        return -1;
    }

    /**
     *
     * @param array Binary search for a sorted String array
     * @param key word to search for
     * @param start index of where to start from in an array
     * @param end index of where to end in an array
     * @return index of found word
     */
    private static int binarySearch(String[] array, String key, int start, int end) {
        // Make sure the end index is greater than 0 (basically not 0)
        if (end > 0) {
            // The middle index of the array
            int mid = (start + end) / 2;

            // Check if the middle number in the array is equal to the key
            if (array[mid].equals(key)) {
                return mid;
            }

            // Check if the key is greater than the middle number
           if (array[mid].compareTo(key) < 0) {
                // If it is, then search from the mid + 1 up to the end
                return binarySearch(array, key, mid + 1, end);
            }

            // If the key is less than the mid, do recursion on the array from start to the mid - 1
            return binarySearch(array, key, start, mid - 1);
        }

        // Return -1 if not found
        return -1;
    }
}
