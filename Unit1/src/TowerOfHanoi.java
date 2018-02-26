import java.util.Scanner;

public class TowerOfHanoi {

	static int totalMoves = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the total number of discs: ");
		
		String discs = scan.next();
		
		// Check if input is valid
		while(!isNumber(discs)) {
			System.out.println("Please enter a valid number!");
			discs = scan.next();
		}
		
		// Solve
		solve(Integer.parseInt(discs), "A", "B", "C");
		
		// Print the total number of moves taken
		System.out.printf("\nTotal moves: %d", totalMoves);
	
	}
	
	/**
	 * Solve
	 * @param n
	 * @param src
	 * @param aux
	 * @param dst
	 */
	public static void solve(int n, String src, String aux, String dst) {
		
		if (n==0) {
			return;
		}
		
		solve(n-1, src, dst, aux);
		System.out.printf("Move from %s to %s\n", src, dst);
		solve(n-1, aux, src, dst);
		
		totalMoves++;
	}
	
	/**
	 * Check if the input they entered is numeric
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str)  
	{  
	  try  
	  {  
	    Integer num = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException ex)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
