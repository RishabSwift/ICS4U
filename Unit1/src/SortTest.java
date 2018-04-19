
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortTest {

	@Test
	void testSelectionInt() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Sort.selectionSort(a);
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}

	@Test
	void testSelectionDouble() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Sort.selectionSort(a);
		double[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testSelectionString() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Sort.selectionSort(a);
		String[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testInsertionInt() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Sort.insertionSort(a);
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}

	@Test
	void testInsertionDouble() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Sort.insertionSort(a);
		double[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testInsertionString() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Sort.insertionSort(a);
		String[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(!a[i].equals( b[i]))
				fail();
		}
	}
	
	@Test
	void testBubbleInt() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Sort.bubbleSort(a);
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}

	@Test
	void testBubbleDouble() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Sort.bubbleSort(a);
		double[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testBubbleString() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Sort.bubbleSort(a);
		String[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testQuickInt() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Sort.quickSort(a);
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}

	@Test
	void testQuickDouble() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Sort.quickSort(a);
		double[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testQuickString() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Sort.quickSort(a);
		String[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testMergeInt() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Sort.mergeSort(a);
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}

	@Test
	void testMergeDouble() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Sort.mergeSort(a);
		double[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	@Test
	void testMergeString() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Sort.mergeSort(a);
		String[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] != b[i])
				fail();
		}
	}
	
	
	@Test
	void testLinearSearchStringFound() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		int found = Search.linearSearch(a, "Rabbit");
		assertEquals(3, found);
	}

	@Test
	void testLinearSearchStringNotFound() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		int found = Search.linearSearch(a, "Kangaroo");
		assertEquals(-1, found);
	}
	
	@Test
	void testLinearSearchDoubleFound() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		int found = Search.linearSearch(a, 6.8);
		assertEquals(3, found);
	}

	@Test
	void testLinearSearchDoubleNotFound() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		int found = Search.linearSearch(a, 2.9);
		assertEquals(-1, found);
	}
	
	@Test
	void testLinearSearchIntFound() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		int found = Search.linearSearch(a, 6);
		assertEquals(3, found);
	}

	@Test
	void testLinearSearchIntNotFound() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		int found = Search.linearSearch(a, 2);
		assertEquals(-1, found);
	}
	
	@Test
	void testBinarySearchStringFound() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Arrays.sort(a);
		int found = Search.linearSearch(a, "Rabbit");
		assertEquals(2, found);
	}

	@Test
	void testBinarySearchStringNotFound() {
		String[] a = {"cat", "dog", "Mouse", "Rabbit", "cow", "Cat"};
		Arrays.sort(a);
		int found = Search.binarySearch(a, "Kangaroo");
		assertEquals(-1, found);
	}
	
	@Test
	void testBinarySearchDoubleFound() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Arrays.sort(a);
		int found = Search.binarySearch(a, 6.8);
		assertEquals(5, found);
	}

	@Test
	void testBinarySearchDoubleNotFound() {
		double[] a = {9.6, 5.0, 3.1, 6.8, 3.1, 3.8, 4.9, 7.5};
		Arrays.sort(a);
		int found = Search.binarySearch(a, 4.8);
		assertEquals(-1, found);
	}
	
	@Test
	void testBinarySearchIntFound() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Arrays.sort(a);
		int found = Search.binarySearch(a, 6);
		assertEquals(4, found);
	}

	@Test
	void testBinarySearchIntNotFound() {
		int[] a = {9, 5, 3, 6, 1, 8, 4, 7};
		Arrays.sort(a);
		int found = Search.binarySearch(a, 2);
		assertEquals(-1, found);
	}
	
	
}
