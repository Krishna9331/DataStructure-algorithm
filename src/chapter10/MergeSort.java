package chapter10;

import java.util.Arrays;

/**
 * Created by mishrk3 on 3/9/2017.
 */

/**
 * Time complexity: O(nlogn)
 * space complexity: O(n)
 */
public class MergeSort {

	public void sort(int[] numbers) {
		int n = numbers.length;
		mergeSort(numbers, 0, n - 1);
	}

	/**
	 * @param numbers
	 *            integer array
	 * @param start
	 *            starting index
	 * @param last
	 *            last index This method is recursively called twice for dividing the A[0...n] to A[0...n/2] and
	 *            A[n/2+1...n] and sort them recursively again. once that is done it call merge operation for each of
	 *            the division.
	 */
	private void mergeSort(int[] numbers, int start, int last) {
		if (start < last) {
			int r = (start + last) / 2;
			mergeSort(numbers, start, r);
			mergeSort(numbers, r + 1, last);
			merge(numbers, start, r, last);
		}
	}

	/**
	 * @param numbers
	 *            array of integer
	 * @param start
	 *            indices
	 * @param r
	 *            indices
	 * @param last
	 *            indices All the indices holds relationship p <= q < r. This method assume that A[p...q] and A[q+1...r]
	 *            is already sorted and it has to merge it.
	 */
	private void merge(int[] numbers, int start, int r, int last) {
		int n1 = r - start + 1;
		int n2 = last - r;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];

		Double infinity = Double.POSITIVE_INFINITY;
		for (int i = 0; i < n1; i++) {
			left[i] = numbers[start + i];
		}
		left[n1] = infinity.intValue();

		for (int i = 0; i < n2; i++) {
			right[i] = numbers[r + i + 1];
		}
		right[n2] = infinity.intValue();

		for (int i = 0, j = 0, k = start; k <= last; k++) {
			if (left[i] <= right[j]) {
				numbers[k] = left[i];
				i++;
			} else {
				numbers[k] = right[j];
				j++;
			}

		}
	}

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();

		int[] numbers = {
				4, 2, 9, 11, 1, 7, 9, 5
		};

		ms.sort(numbers);
		System.out.println("Array after sorting.........");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
