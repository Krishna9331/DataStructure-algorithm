package chapter11.problems;

/**
 * Created by mishrk3 on 4/3/2017.
 */

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * given an array of n distinct integer, suppose array has property: there exists an index 1 <= k<= n such that
 * A[1],......,A[k] is in increasing sequence and A[k+1],.....,A[n] is in decreasing sequence. Design an analyze an
 * efficient algorithm for finding k.
 */
public class MonotonicallyIncreasingFunction {

	public int searchMonotonicPointForKnownSize(int[] elements, int n) {
		int mid, first = 0, last = n - 1;
		while (first <= last) {
			if (first == last) { // Array of size 1
				return elements[first];
			} else if (first == last - 1) { // Array of size 2
				return max(elements[first], elements[last]);
			} else {
				mid = first + (last - first) / 2;
				if (elements[mid - 1] < elements[mid] && elements[mid] > elements[mid + 1]) {
					return elements[mid];
				} else if (elements[mid - 1] < elements[mid] && elements[mid] < elements[mid + 1]) {
					first = mid + 1;
				} else if (elements[mid - 1] > elements[mid] && elements[mid] > elements[mid + 1]) {
					last = mid - 1;
				} else {
					return Integer.MIN_VALUE;
				}
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		MonotonicallyIncreasingFunction mif = new MonotonicallyIncreasingFunction();
		int[] elements = {
				-5, -3, -1, 23, 11, 7, 4, 3
		};
		int result = mif.searchMonotonicPointForKnownSize(elements, 8);
		System.out.println("The monotonic point is: " + result);

		int[] elements1 = {
				-5, -3, -1, 2, 7, 9, 11
		};
		int result1 = mif.searchMonotonicPointForKnownSize(elements1, 7);
		System.out.println("The monotonic point is: " + result1);

		int[] elements2 = {
				3, 22
		};
		int result2 = mif.searchMonotonicPointForKnownSize(elements2, 2);
		System.out.println("The monotonic point is: " + result2);

		int[] elements3 = {
				-5, 11, 5
		};
		int result3 = mif.searchMonotonicPointForKnownSize(elements3, 3);
		System.out.println("The monotonic point is: " + result3);
	}
}
