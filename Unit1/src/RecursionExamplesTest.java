
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursionExamplesTest {

	@Test
	void testSum() {
		int total = RecursionExamples.sum(10);
		assertEquals(55, total);
	}

	@Test
	void testSum1() {
		int total = RecursionExamples.sum(1);
		assertEquals(1, total);
	}
	
	@Test
	void testSum0() {
		int total = RecursionExamples.sum(0);
		assertEquals(0, total);
	}
	
	@Test
	void testFactorial() {
		long total = RecursionExamples.factorial(5);
		assertEquals(120, total);
	}

	@Test
	void testFactorial1() {
		long total = RecursionExamples.factorial(1);
		assertEquals(1, total);
	}
	
	@Test
	void testFactorial0() {
		long total = RecursionExamples.factorial(0);
		assertEquals(1, total);
	}
	
	@Test
	void testExponent() {
		long total = RecursionExamples.exponent(5,3);
		assertEquals(125, total);
	}

	@Test
	void testExponent1() {
		long total = RecursionExamples.exponent(2,1);
		assertEquals(2, total);
	}
	
	@Test
	void testExponent0() {
		long total = RecursionExamples.exponent(2,0);
		assertEquals(1, total);
	}
	
	@Test
	void testBinToDec() {
		long total = RecursionExamples.binToDec(100101);
		assertEquals(37, total);
	}
	
	@Test
	void testBinToDec1s() {
		long total = RecursionExamples.binToDec(1111111);
		assertEquals(127, total);
	}
	
	@Test
	void testBinToDec1() {
		long total = RecursionExamples.binToDec(10000000);
		assertEquals(128, total);
	}
	
	@Test
	void testDecToBin() {
		double total = RecursionExamples.decToBin(37);
		assertEquals(100101, total);
	}
	
	@Test
	void testDecToBin1s() {
		double total = RecursionExamples.decToBin(127);
		assertEquals(1111111, total);
	}
	
	@Test
	void testDecToBin1() {
		double total = RecursionExamples.decToBin(128);
		assertEquals(10000000, total);
	}
	
}
