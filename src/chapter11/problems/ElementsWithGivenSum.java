package chapter11.problems;

/**
 * Created by mishrk3 on 4/3/2017.
 */

import chapter10.QuickSort;

/**
 * Given an array of n elements find the two elements whose sum is equal to K.<br/>
 *
 * Similar problem will be find three index where A[i]^2 + A[j]^2 = A[k]^2. We can just create the another array by
 * doing square of each element and then find two element whose sum is equal to third.
 */
public class ElementsWithGivenSum {

	/**
	 * Time Complexity: O(nlogn) if array is already sorted O(n)<br/>
	 * Space Complexity: O(1)
	 * 
	 * @param elements
	 *            array of integers
	 * @param k
	 *            the number for which two elements has to find such that sum of two numbers is equal to k<br/>
	 *            <pre>
	 *                We first sort the array and start finding the pair by using two pointers(smaller, large) starting
	 *                at 0 and n-1.
	 *                We sum the first and last and compare with k, if sum is greater than k that means we have to
	 *                consider smaller elements, so we reduce the large pointer by 1.
	 *                If sum is smaller than k that means we need larger elements and we increase the smaller pointer.
	 *            </pre>
	 */
	public void findElements(int[] elements, int k) {
		int temp;
		QuickSort qs = new QuickSort();
		qs.sort(elements);
		for (int i = 0, j = elements.length - 1; i < j;) {
			temp = elements[i] + elements[j];
			if (temp == k) {
				System.out.println(elements[i] + " " + elements[j]);
				return;
			} else if (temp < k) {
				i = i + 1;
			} else {
				j = j - 1;
			}
		}
	}

	public static void main(String[] args) {

		ElementsWithGivenSum ewgs = new ElementsWithGivenSum();

		int[] elements = {
				2, 3, 5, 1, 7, 8, 4, 6
		};
		System.out.println("elements with sum 6 are: ");
		ewgs.findElements(elements, 6);
		System.out.println("elements with sum 8 are: ");
		ewgs.findElements(elements, 8);
		System.out.println("elements with sum 9 are: ");
		ewgs.findElements(elements, 9);
		System.out.println("elements with sum 13 are: ");
		ewgs.findElements(elements, 13);
	}
}
