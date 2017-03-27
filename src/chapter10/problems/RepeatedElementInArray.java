package chapter10.problems;

/**
 * Created by mishrk3 on 3/27/2017.
 */

import chapter10.QuickSort;

/**
 * Given an array verify that if an array has repeated element.
 */
public class RepeatedElementInArray {

	/**
	 * @param elements
	 *            array of integers
	 * @return the repeated element
	 */
	public boolean hasRepeatedElement(int[] elements) {
		QuickSort qSort = new QuickSort();
		qSort.sort(elements);

		for (int i = 0; i < elements.length - 1; i++) {
			if (elements[i] == elements[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		RepeatedElementInArray reia = new RepeatedElementInArray();

		int[] elements = {
				1, 4, 7, 3, 8, 4, 9
		};

		int[] elements1 = {
				1, 4, 7, 3, 8, 11, 9
		};

		System.out.println(reia.hasRepeatedElement(elements));
		System.out.println(reia.hasRepeatedElement(elements1));
	}
}
