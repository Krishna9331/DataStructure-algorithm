package chapter10;

import java.util.Arrays;

/**
 * Created by mishrk3 on 3/11/2017.
 */

/**
 * Counting sort is not comparision based sorting, It is applied on an array containing elements in given range. it
 * counts number of smaller element in array for a given key, and that's how it decides the position of key. e.g: if 10
 * elements are less than a key X in array this means position of X in array is 11th.
 */
public class CountingSort {

	public void sort(int[] numbers, int k) {
		int i, j;
		int n = numbers.length;
		int[] sorted = new int[n];
		int[] temp = new int[k];

		// initialize the temp array which contains number of smaller element
		for (i = 0; i < k; i++) {
			temp[i] = 0;
		}

		// populate temp[j] to contains number of element equal to j
		for (j = 0; j < n; j++) {
			temp[numbers[j]] = temp[numbers[j]] + 1;
		}

		// populate temp[i] to contain number of element <= i
		for (i = 1; i < k; i++) {
			temp[i] = temp[i] + temp[i - 1];
		}

		for (j = n - 1; j >= 0; j--) {
			sorted[temp[numbers[j]] - 1] = numbers[j];
			temp[numbers[j]] = temp[numbers[j]] - 1;
		}

		for (j = n - 1; j >= 0; j--) {
			numbers[j] = sorted[j];
		}
	}

	public static void main(String[] args) {
		CountingSort cs = new CountingSort();

		int[] numbers = {
				1, 5, 7, 6, 5, 2, 3, 8, 7
		};

		cs.sort(numbers, 9);
		System.out.println("Array is sorted.......");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
