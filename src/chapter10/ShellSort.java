package chapter10;

import java.util.Arrays;

/**
 * Created by mishrk3 on 3/9/2017.
 */

/**
 * <pre>
 * Shell Short is also known as diminishing increment short and was invented by Donald Shell. This sorting algorithm
 * is generalization of insertion sort. As we know insertion sort woks efficiently on almost sorted array, So shell sort
 * try to first sort the array before applying insertion sort.
 * 
 * This sort is also known as n-gap insertion sort as in place of comparing just adjacent elements, it compare several 
 * pass before starting with gap less than equal to size of array and ending with gap = 1(which is insertion sort).
 * </pre>
 */
public class ShellSort {

	/**
	 * @param numbers
	 *            array of integers <pre>
	 *  In the below code the first comparision will start with gap with half of array size which is 4, and it reduce 
	 *  the value of gap by half.
	 *  So the first iteration will start comparision with 4th element and continue till last and comparision will
	 *  happen with the element at index current - gap.
	 *  So in given array first time 5 will be picked and it will compared with 6 and will get swapped
	 *  then 3 -> 8 swapped
	 *  7 -> 1 no swap
	 *  2 -> 4 swapped
	 *  so after doing 4 gap insertion sort new array will be {5, 3, 1, 2, 6, 8, 7, 4}
	 *
	 *  Now gap will be reduced to half of it's value which is 2. So comparision will start with element at index 2 and
	 *  will compare till end of array with the element at curr - 2. Which will be
	 *  1 -> 5 swapped {1, 3, 5, 2, 6, 8, 7, 4}
	 *  2 -> 3 swapped {1, 2, 5, 3, 6, 8, 7, 4}
	 *  6 -> 5 no swap {1, 2, 5, 3, 6, 8, 7, 4}
	 *  8 -> 3 no swap {1, 2, 5, 3, 6, 8, 7, 4}
	 *  7 -> 6 no swap {1, 2, 5, 3, 6, 8, 7, 4}
	 *  4 -> 8 swapped {1, 2, 5, 3, 6, 4, 7, 8}
	 *
	 * Finally gap will become 1 and it will do comparision for each adjacent element which is same as doing insertion
	 * sort but the array by this time is almost sorted, which will make insertion sort very efficient.
	 *  
	 *  </pre>
	 */
	public void sort(int[] numbers) {
		int n = numbers.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = numbers[i];
				int j = i;
				while (j >= gap && numbers[j - gap] > temp) {
					numbers[j] = numbers[j - gap];
					j -= gap;
				}
				numbers[j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		ShellSort ss = new ShellSort();

		int[] numbers = {
				6, 8, 1, 4, 5, 3, 7, 2
		};
		ss.sort(numbers);
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
