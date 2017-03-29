package chapter11.problems;

/**
 * Created by mishrk3 on 3/28/2017.
 */

import static java.lang.StrictMath.abs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of size n and where all elements in range 0-n-1 write an algorithm to find if an array has duplicate
 * elements. Also note that all elements in array is greater than 0.
 */
public class DuplicateInArray {

	/**
	 * @param elements
	 *            the array of integer
	 * @return true, if array contains duplicate element<br/>
	 *         <pre>Given an array of size n and where all elements in range 0-n-1 write an algorithm to find if an array has
	 *         duplicate elements. Also note that all elements in array is greater than 0.
	 *         Time Complexity: O(n)
	 *         Space Complexity O(1)
	 *         </pre>
	 */
	public boolean hasDuplicate(int[] elements) {
		int n = elements.length;
		for (int i = 0; i < n; i++) {
			if (elements[abs(elements[i])] < 0) {
				return true;
			} else {
				elements[abs(elements[i])] = -elements[abs(elements[i])];
			}
		}
		return false;
	}

	/**
	 * @param elements
	 *            the array of integer
	 * @return true, if array contains duplicate element<br/>
	 *         Time Complexity: O(n)<br/>
	 *         Space Complexity O(n)
	 */
	public boolean hasDuplicateInGeneralizedArray(int[] elements) {
		Set<Integer> set = new HashSet<>();
		for (int i : elements) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DuplicateInArray dia = new DuplicateInArray();
		int[] ele = {
				3, 2, 1, 2, 2, 5
		};

		System.out.println("Duplicate Found in ele: " + dia.hasDuplicate(ele));

		int[] ele1 = {
				3, 4, 2, 7, 1, 8, 99, 2, 23
		};
		System.out.println("Duplicate found in generalized array: " + dia.hasDuplicateInGeneralizedArray(ele1));
	}
}
