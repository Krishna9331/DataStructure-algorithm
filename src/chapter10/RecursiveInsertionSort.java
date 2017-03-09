package chapter10;

/**
 * Created by mishrk3 on 3/9/2017.
 */

import java.util.Arrays;

/**
 * <pre>
 * Below insertion sort is another way of implementing using Divide-and-conquer. The code follow the principle: In order
 * to sort A[1...n], we recursively sort A[1...n-1]and then insert A[n] into the sorted array A[1...n-1]
 * Hence dividing should always happens by removing just last element and recursively call
 * sort for remaining elements.
 * Once recursion is done then we start conquering, means start putting the last element into the previously sorted
 * elemnents.
 * </pre>
 */
public class RecursiveInsertionSort {

	public void sort(int[] numbers) {
		int n = numbers.length;
		insertionSort(numbers, 0, n - 1);
	}

	private void insertionSort(int[] numbers, int start, int last) {
		if (start < last) {
			int r = last - start - 1;
			insertionSort(numbers, start, r);
			insert(numbers, r, last);
		}
	}

	/**
	 * @param numbers
	 *            integer array
	 * @param r
	 *            index till the array is sorted
	 * @param last
	 *            index for which element has to be inserted the array When this method is called we already have sorted
	 *            array till 0 to p index and it insert the element at q index at the appropriate position in array
	 *            [0...p] First time the method will be called with [A, 0, 1] so it will insert A[1] into A[0] after
	 *            comparison second call [A, 1, 2] it will insert A[2] into A[0...1] Third call [A, 2, 3] it will insert
	 *            A[3] into A[0...2] and so on
	 */
	private void insert(int[] numbers, int r, int last) {
		int key = numbers[last];
		for (int i = r; i >= 0; i--) {
			if (key < numbers[i]) {
				numbers[i + 1] = numbers[i];
				numbers[i] = key;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		RecursiveInsertionSort ris = new RecursiveInsertionSort();

		int[] numbers = {
				6, 8, 1, 4, 5, 3, 7, 2
		};
		ris.sort(numbers);
		System.out.println("Array after sorting....");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
