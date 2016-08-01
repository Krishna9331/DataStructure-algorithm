package dynamicProgramming;

/**
 * Created by mishrk3 on 7/4/2016.
 */

/**
 * Dynamic Programming is way to solve a complex problem by breaking into multiple sub problems and store the result of
 * sub problems to avoid computing the same result again. Mostly two types of problems are preferred to solve using
 * dynamic programming:
 * 1)Overlapping Sub-problems
 * 2)Optimal Substructure
 */
public class Fibonacci {

	/**
	 * Overlapping Solutions:
	 * fib(5) -> fib(4) + fib(3)
	 * now fib(4) -> fib(3) + fib(2)
	 * fib(3) -> fib(2) + fib(1)  and fib(2) -> fib(0) + fib(1)
	 * <br/>
	 * and fib(3) -> continue as above line
	 * <br/>
	 * The first approach to solve the problem is Memoization(Top Down): In this approach it always first check for
	 * the result in the look up table. The lookup table is initialized with null for all the occurrence.
	 */

	private Integer lookup[];

	public Fibonacci(int n) {
		lookup = new Integer[n + 1];
		for (int i = 0; i <= n; i++) {
			lookup[i] = null;
		}
	}

	public int fibTop(int n) {
		if (lookup[n] == null) {
			if (n <= 1) {
				lookup[n] = n;
			} else {
				lookup[n] = fibTop(n - 1) + fibTop(n - 2);
			}
		}
		return lookup[n];
	}

	/**
	 * Tabulation (Bottom Up) solution
	 * program for a given problem builds a table in bottom up fashion and returns the last entry from table.
	 */

	public int fibBottom(int n) {
		int[] lookup = new int[n + 1];
		lookup[0] = 0;
		lookup[1] = 1;

		for (int i = 2; i <= n; i++) {
			lookup[i] = lookup[i - 1] + lookup[i - 2];
		}
		return lookup[n];
	}

	public static void main(String[] args) {
		/**
		 * The 9th value in array is 10th fibonacci number. The first value start with 0 or lookup[0].
		 */
		Fibonacci f = new Fibonacci(9);
		System.out.println("The 10th fibonacci number using Top Down approach: " + f.fibTop(9));
		System.out.println("The 10th fibonacci number using Bottom Up approach: " + f.fibBottom(9));
	}
}
