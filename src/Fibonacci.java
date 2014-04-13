import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Fibonacci numbers
 *
 */
public class Fibonacci {
	
	private static int n = 40; // If there is no command line argument.
	private static List<Integer> T = new ArrayList<Integer>(); // For the recursion memorization.

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				n = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + args[0] + " must be an integer.");
				System.exit(1);
			}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println( i + ". " + ( (fiboR(i) == fiboRM(i) && 
											  fiboIt(i) == fiboRM(i) &&
											  fiboBi(i) == fiboRM(i) ) ? fiboRM(i) : "Houston, we have a problem!" + System.getProperty("line.separator") ) );
		}
	}
	
	/**
	 * 
	 * @param The Nth Fibonacci number what we are looking for
	 * @return The Nth Fibonacci number in the sequence using recursion
	 * @throws IllegalArgumentException if the Nth Fibonacci number is not defined
	 */
	public static int fiboR (int n) {
		if (n < 0) throw new IllegalArgumentException();
		else if (n < 2) return n;
		else return ( fiboR(n-1) + fiboR(n-2) );
	}

	/**
	 * 
	 * @param The Nth Fibonacci number what we are looking for
	 * @return The Nth Fibonacci number in the sequence using recursion memorization
	 * @throws IllegalArgumentException if the Nth Fibonacci number is not defined
	 */
	public static int fiboRM (int n) {
		if (n < 0) throw new IllegalArgumentException();
		if (T.size() <= n) {
			if ( T.size() < 2 ) for (int i = 0; i < 2; i++) T.add(i);
			for (int i = T.size(); i <= n; i++) T.add( T.get(i-1) + T.get(i-2) );
		}
		return T.get(n);
	}
	
	/**
	 * 
	 * @param The Nth Fibonacci number what we are looking for
	 * @return The Nth Fibonacci number in the sequence using recursion memorization, also called dynamic programming
	 * @throws IllegalArgumentException if the Nth Fibonacci number is not defined
	 */
	public static int fiboIt (int n) {
		if (n < 0) throw new IllegalArgumentException();		
		if (n < 2) return n;
		int prev = 0;
		int next = 1;
		int tmp;
		for (int i = 2; i <= n; i++) {
			tmp = next;
			next += prev;
			prev = tmp;
		}
		return next;
	}

	/**
	 * Fn = ( (1+sqrt(5)^n) - (1-sqrt(5)^n) ) / ( sqrt(5) * 2^n )
	 * 
	 * @param The Nth Fibonacci number what we are looking for
	 * @return The Nth Fibonacci number in the sequence using the binet formula
	 * @throws IllegalArgumentException if the Nth Fibonacci number is not defined
	 */
	public static int fiboBi (int n) {
		if (n < 0) throw new IllegalArgumentException();
		return (int) ( ( ( Math.pow(1+Math.sqrt(5), n)) - (Math.pow(1-Math.sqrt(5), n) ) ) /
					   ( Math.sqrt(5) * Math.pow(2,n) )
					  );
	}

}