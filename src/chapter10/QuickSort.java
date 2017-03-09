package chapter10;

import java.util.Arrays;

/**
 * Created by mishrk3 on 3/9/2017.
 */

/**
 * <pre>
 * The quick sort algorithm consist of four steps:
 * 1. If there is no element in the array to be sorted, return
 * 2. Pick an element in the array to serve as pivot(usually left most element)
 * 3. split the array into two parts: one with element larger than pivot and other with smaller or equal to.
 * 4. Recursively repeat the algorithm for the split arrays.
 * </pre>
 */
public class QuickSort {

	public void sort(int[] numbers) {
		int n = numbers.length;
		quickSort(numbers, 0, n - 1);
	}

	private void quickSort(int[] numbers, int low, int high) {
		int pivot;
		if (high > low) {
			pivot = partition(numbers, low, high);
			quickSort(numbers, low, pivot - 1);
			quickSort(numbers, pivot + 1, high);
		}
	}

	/**
	 * @param numbers
	 *            the array of integers
	 * @param low
	 *            the starting index
	 * @param high
	 *            the end index
	 * @return the index of pivot element<br/>
	 *         <pre>
	 *     The calculation logic for pivot is as below:
	 *     
	 *     make left = starting index
	 *     right = lastIndex and
	 *     pivot = element at index low.
	 *     
	 *   So maintain two pointer one for left and one for right
	 *  1. increment the left pointer while element is less than or equal to pivot
	 *  2. decrement the right pointer if while element is bigger than pivot
	 *  3. check if left is smaller than right
	 *    if yes swap the element at index left and right and continue from step 1.
	 *  
	 *  if left is not smaller than right this means both pointer has crossed each other than
	 *   swap pivot with element at right and return right as pivot index.
	 *   
	 *   e.g for given array: {3, 7, 6, 9, 2, 1, 4, 5, 11} first call will be (numbers, 0, 8)
	 *   now pivot will be 3
	 *   the left pointer will process from 3 and stop at 7 which is index 1.
	 *   same way right pointer will decrement and stop at 1, which is index 5.
	 *   swap 7 and 1 so new array will be {3, 1, 6, 9, 2, 7, 4, 5, 11} and left=1 and right 5
	 *   still left < right and pivot = 3
	 *   
	 *   again left will stop at index 2 since value is 6 and right will stop at 4 as value is 2 and both will be 
	 *   swapped. so values will be:
	 *    {3, 1, 2, 9, 6, 7, 4, 5, 11}
	 *    left = 2, right = 4 and pivot = 3
	 *    
	 *    Still left < right
	 *    
	 *    again left will stop at index 3 as value is 9, however right will cross the left pointer until it does not 
	 *    find element smaller than pivot which is 2 at index 2.
	 *    
	 *    This time both pointer has swapped hence will swap the pivot with index of right pointer and return right 
	 *    index as pivot. 
	 *    so values will be:
	 *    {2, 1, 3, 9, 6, 7, 4, 5, 11}
	 *    left = 3, right = 2 and pivotIndex = 2
	 *     
	 * </pre>
	 */
	private int partition(int[] numbers, int low, int high) {
		int left, right, pivot = numbers[low];
		left = low;
		right = high;
		while (left < right) {
			while (numbers[left] <= pivot) {
				left++;
			}
			while (numbers[right] > pivot) {
				right--;
			}
			if (left < right) {
				swap(numbers, left, right);
			}
		}
		numbers[low] = numbers[right];
		numbers[right] = pivot;
		return right;
	}

	private void swap(int[] numbers, int left, int right) {
		int temp = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = temp;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();

		int[] numbers = {
				3, 7, 6, 9, 2, 1, 4, 5, 11
		};

		qs.sort(numbers);
		System.out.println("Array after sorting...");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
