package chapter11;

import java.util.function.BiFunction;

/**
 * Created by mishrk3 on 3/28/2017.
 */
public class BinarySearch {

	/**
	 * @param elements
	 *            array of integers
	 * @param key
	 *            the element to be searched
	 * @param function
	 *            the bi function which is passed to be applied for searching
	 * @return the index of key in array<br/>
	 *         <pre>
	 *     The below binary function can do the search in ascending as well as on descending sorted array.
	 *     Also this flexibility we got as we pass the function at the run time.
	 *     Time Complexity O(logn)
	 * </pre>
	 */
	public int search(int[] elements, int key, BiFunction<Integer, Integer, Boolean> function) {
		return go(elements, key, 0, 0, elements.length - 1, function);
	}

	private int go(int[] elements, int key, int low, int mid, int high,
			BiFunction<Integer, Integer, Boolean> function) {
		if (low > high) {
			return -mid - 1;
		} else {
			int mid2 = (low + high) / 2;
			int ele = elements[mid2];
			boolean greater = function.apply(ele, key);
			if (!greater && !function.apply(key, ele)) {
				return mid2;
			}
			if (greater) {
				return go(elements, key, low, mid2, mid2 - 1, function);
			} else {
				return go(elements, key, mid2 + 1, mid2, high, function);
			}
		}
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] elements = {
				1, 4, 6, 8, 9, 11, 35, 78
		};

		System.out.println("The element 9 is at: " + bs.search(elements, 9, (x, y) -> x > y));
		System.out.println("The element 37 is at: " + bs.search(elements, 37, (x, y) -> x > y));

		int[] reverseSortedElements = {
				88, 54, 47, 32, 25, 19, 17, 14, 13, 11, 5, 3, 2
		};

		System.out.println("The element 19 is at: " + bs.search(reverseSortedElements, 19, (x, y) -> x < y));
	}
}
