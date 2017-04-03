package chapter11.problems;

/**
 * Created by mishrk3 on 4/3/2017.
 */

/**
 * ** Given an array with size having elements in range 1 to n, If n-1 elements are repeating thrice and remaining
 * elements are repeated twice. find the elements which repeated twice.
 */
public class FindTwiceRepeatingElements {

	/**
	 * Time Complexity: O(n)<br/>
	 * Space Complexity: O(1)
	 * 
	 * @param elements
	 *            array of integers
	 * @param n
	 *            the max number in array
	 */
	public void findTwiceRepeating(int[] elements, int n) {
		int x = 0;

		for (int i = 0; i < elements.length; i++) {
			x ^= elements[i];
		}
		for (int i = 1; i <= n; i++) {
			x ^= i;
		}
		System.out.println(x);
	}

	public static void main(String[] args) {

		FindTwiceRepeatingElements ftre = new FindTwiceRepeatingElements();
		int[] elements = {
				1, 1, 2, 2, 2, 3, 4, 3, 5, 3, 4, 4, 5, 5
		};
		ftre.findTwiceRepeating(elements, 5);
	}
}
