package chapter10;

import java.util.Arrays;

/**
 * Created by mishrk3 on 3/8/2017.
 */
public class BubbleSort {

	/**
	 * @param numbers
	 *            array of integer <pre>
	 *  The best case time complexity of below sorting is O(n)
	 *  The worst case time complexity of below sorting is O(n^2)
	 *  The average time complexity of below sorting is O(n^2)
	 *  The space complexity of below sorting is O(1)
	 *  
	 *  It is the simplest sorting algorithm. It works by iterating the input array from first element to last, 
	 *  comparing each pair and swapping them if needed. It continues the iteration until no more swapping is required.
	 *  </pre>
	 */
	public void sort(int[] numbers) {
		int n = numbers.length;
		int pass, i, temp;
		boolean swapped = true;
		for (pass = n - 1; pass >= 0 && swapped; pass--) {
			swapped = false;
			for (i = 0; i <= pass - 1; i++) {
				if (numbers[i] > numbers[i + 1]) {
					temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					swapped = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();

		int[] numbers = {
				4, 7, 8, 6, 2, 5, 9
		};
		bs.sort(numbers);
		System.out.println("Array after sorting...");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
