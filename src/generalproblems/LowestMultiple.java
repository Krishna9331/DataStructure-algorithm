package generalproblems;

/**
 * Created by mishrk3 on 5/19/2017.
 */

/**
 * find the smallest multiple that divides evenly into all numbers from 1 through n
 */
public class LowestMultiple {

	/**
	 * The logic for below method is if we know that solution for n is x, the solution for n+1 must be divisible by x.
	 * Hence in place of iterating through each natural number we can just iterate over multiple of x.<br/>
	 * e.g. we know the lowest common multiple for 1 to 4 is 12, but if we see lcm for 1 to 5 is 60 which is divisible
	 * by 12 again 1 to 6 is also 60 and for 1 to 7 it is 420 which is divisible by 60 and of course by 12 as well.
	 * 
	 * @param n
	 *            the number for which we have to find lowest common multiple from 1 to n
	 * @return the lowest common multiple
	 */
	public int findLowestMultiple(int n) {
		int result = 1;
		int prev;
		for (int i = 1; i < n + 1; i++) {
			prev = result;
			while (result % i > 0) {
				result += prev;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LowestMultiple lm = new LowestMultiple();
		int result = lm.findLowestMultiple(10);
		System.out.println("lowest multiple for 1 to 10 is: " + result);

		int result1 = lm.findLowestMultiple(4);
		System.out.println("lowest multiple for 1 to 4 is: " + result1);

		int result2 = lm.findLowestMultiple(5);
		System.out.println("lowest multiple for 1 to 5 is: " + result2);

		int result3 = lm.findLowestMultiple(6);
		System.out.println("lowest multiple for 1 to 6 is: " + result3);

		int result4 = lm.findLowestMultiple(7);
		System.out.println("lowest multiple for 1 to 7 is: " + result4);
	}
}
