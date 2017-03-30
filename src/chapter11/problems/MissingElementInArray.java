package chapter11.problems;

/**
 * Created by mishrk3 on 3/30/2017.
 */

/**
 * For a given array of integer where each element is in range from 1 to n an one element is missing from the array.
 * Find the missing element.
 */
public class MissingElementInArray {

	public int findMissingElement(int[] elements, int n) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < elements.length; i++) {
			x ^= elements[i];
		}

		for (int i = 1; i <= n; i++) {
			y ^= i;
		}
		return (x ^ y);
	}

	public static void main(String[] args) {
		MissingElementInArray meia = new MissingElementInArray();

		int[] elements = {
				1, 2, 4, 6, 3, 7, 8
		};

		int result = meia.findMissingElement(elements, 8);

		System.out.println("The missing element is: " + result);
	}
}
