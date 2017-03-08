package chapter10;

/**
 * Created by mishrk3 on 3/8/2017.
 */

import java.util.Arrays;

/**
 * <pre>
 * Selection sort is in place algorithm which works well for small files. It is used for sorting the files with very
 * large value and small keys. This is because selection is made on basis of keys and swaps are made if required.
 * 
 * Worst case Time Complexity: O(n^2)
 * Best case Time Complexity: O(n^2)
 * Average case Time Complexity: O(n^2)
 * Space Time Complexity: O(1)
 * </pre>
 */
public class SelectionSort {

	public void sort(int[] numbers) {
		int i, j, min, temp;
		int n = numbers.length;

		for (i = 0; i < n; i++) {
			min = i;

			for (j = i + 1; j < n; j++) {
				if (numbers[j] < numbers[min]) {
					min = j;
				}
			}
			temp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = temp;
		}
	}

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();

		int[] numbers = {
				4, 2, 9, 11, 1, 7, 9, 5
		};
		ss.sort(numbers);
		System.out.println("Array after sorting.........");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
