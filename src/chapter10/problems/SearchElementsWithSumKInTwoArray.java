package chapter10.problems;

/**
 * Created by mishrk3 on 3/27/2017.
 */

import chapter10.QuickSort;
import chapter2.recursion.BinarySearch;

/**
 * Given to array A and B each of size n. Also given a number K, give an algorithm to find whether there exist a E A and
 * b E B such that a+b = K.
 */
public class SearchElementsWithSumKInTwoArray {

	public boolean isExistElementsWithSumK(int[] a, int[] b, int k) {
		QuickSort quickSort = new QuickSort();
		quickSort.sort(a);
		BinarySearch bs = new BinarySearch();
		for (int i = 0; i < a.length; i++) {
			int c = k - b[i];
			if (bs.binarySearch(a, c, (e, f) -> e > f) >= 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchElementsWithSumKInTwoArray search = new SearchElementsWithSumKInTwoArray();
		int[] a = {
				1, 5, 11, 8, 9, 3, 21, 11
		};

		int[] b = {
				2, 9, 11, -45, 30, -5, 3, 8
		};

		System.out.println("for the number 14, the answer is: " + search.isExistElementsWithSumK(a, b, 14));
		System.out.println("for the number -44, the answer is: " + search.isExistElementsWithSumK(a, b, -44));
		System.out.println("for the number -2, the answer is: " + search.isExistElementsWithSumK(a, b, -2));
		System.out.println("for the number -6, the answer is: " + search.isExistElementsWithSumK(a, b, -6));
	}
}
