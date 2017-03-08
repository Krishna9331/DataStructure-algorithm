package chapter10;

/**
 * Created by mishrk3 on 3/8/2017.
 */

import java.util.Arrays;

/**
 * <pre>
 *	This is simple and efficient sorting algorithm. It is efficient for small data than Bubble and selection sort.
 *	
 *	
 * </pre>
 */
public class InsertionSort {

	/**
	 * @param numbers
	 *            array of integers <br/>
	 *            The insertion sort starts from the second element(key) and travers till length of the array. for every
	 *            element(key) it compares the key from all the elements left of key and put it in sorted order. During
	 *            comparison it keeps pushing the element one index right if it is larger than key until it finds the
	 *            smaller one and at this point it insert the key. That is why it is known as insertion sort.
	 */
	public void sort(int[] numbers) {
		int n = numbers.length;
		int i, j, temp;
		for (i = 1; i < n; i++) {
			temp = numbers[i];
			j = i;
			while (j >= 1 && numbers[j - 1] > temp) {
				numbers[j] = numbers[j - 1];
				j--;
			}
			numbers[j] = temp;
		}
	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();

		int[] numbers = {
				6, 8, 1, 4, 5, 3, 7, 2
		};

		is.sort(numbers);
		System.out.println("Array after sorting....");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
