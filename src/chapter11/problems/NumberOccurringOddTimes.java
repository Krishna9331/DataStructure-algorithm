package chapter11.problems;

/**
 * Created by mishrk3 on 3/30/2017.
 */

/**
 * Given an array of positive integers, all numbers occurs even time except one occurs odd times. Find the odd occurring
 * element.
 */
public class NumberOccurringOddTimes {

	public int findOddOccurringElement(int[] elements) {
		int x = 0;
		for (int i = 0; i < elements.length; i++) {
			x ^= elements[i];
		}
		return x;
	}

	public static void main(String[] args) {

		NumberOccurringOddTimes noot = new NumberOccurringOddTimes();

		int[] elements = {
				1, 2, 3, 2, 3, 1, 3
		};

		int result = noot.findOddOccurringElement(elements);
		System.out.println("The odd occurring element is:" + result);
	}
}
