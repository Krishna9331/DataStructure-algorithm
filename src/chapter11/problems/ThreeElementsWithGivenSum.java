package chapter11.problems;

/**
 * Created by mishrk3 on 4/3/2017.
 */

import chapter10.QuickSort;

/**
 * Given an array of n elements find the two elements whose sum is equal to K.<br/>
 */
public class ThreeElementsWithGivenSum {

	public void findElements(int[] elements, int s) {
		QuickSort qs = new QuickSort();
		qs.sort(elements);

		for (int k = 0; k < elements.length; k++) {
			for (int i = k + 1, j = elements.length - 1; i < j;) {
				if (elements[k] + elements[i] + elements[j] == s) {
					System.out.println(elements[i] + " " + elements[j] + " " + elements[k]);
					return;
				} else if (elements[k] + elements[i] + elements[j] < s) {
					i = i + 1;
				} else {
					j = j - 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreeElementsWithGivenSum tewgs = new ThreeElementsWithGivenSum();

		int[] elements = {
				3, 4, 5, 7, 8, 11, 1, 2, 6, 22, 17, 19
		};
		System.out.println("Three elements with sum 15 are");
		tewgs.findElements(elements, 15);
		System.out.println("Three elements with sum 29 are");
		tewgs.findElements(elements, 29);
		System.out.println("Three elements with sum 52 are");
		tewgs.findElements(elements, 52);
	}
}
