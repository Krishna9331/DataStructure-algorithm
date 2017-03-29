package chapter11.problems;

/**
 * Created by mishrk3 on 3/28/2017.
 */

import static java.lang.StrictMath.abs;

/**
 * Given an array of size n and where all elements in range 0-n-1 write an algorithm to find if an array has duplicate
 * elements. Also note that all elements in array is greater than 0.
 */
public class DuplicateInArray {

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

	public static void main(String[] args) {
		DuplicateInArray dia = new DuplicateInArray();
		int[] ele = {
				3, 2, 1, 2, 2, 5
		};

		System.out.println("Duplicate Found in ele: " + dia.hasDuplicate(ele));

	}
}
