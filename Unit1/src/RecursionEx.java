import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RecursionEx {

	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		char letter = ' ';
		System.out.println("Type the characters HELLO* at the -> ");
		getLetter1(letter);

		System.out.println("Type the characters WOW* at the -> ");
		getLetter2();
	}

	public static void getLetter1(char c) throws Exception {
		c = (char) in.read();
		if (c != '*') {
			getLetter1(c);
		}

		System.out.println(c);
	}

	public static void getLetter2() throws Exception {
		char c = (char) in.read();
		if (c != '*') {
			getLetter1(c);
		}

		System.out.println(c);
	}
}
