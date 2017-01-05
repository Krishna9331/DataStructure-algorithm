package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 1/5/2017. <pre>
 *     Given an array A = {a1, a2, ... an} of N elements, find the maximum possible sum of a

	1. Contiguous subarray
	2. Non-contiguous (not necessarily contiguous) subarray.
 Empty subarrays/subsequences should not be considered.

 Input Format

 First line of the input has an T integer . T cases follow.
 Each test case begins with an integer N. In the next line, N integers follow representing the elements of array A.

 Constraints

 The subarray and subsequences you consider should have at least one element.

 Output Format

 Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

 Sample Input

 2
 4
 1 2 3 4
 6
 2 -1 2 3 4 -5
 Sample Output

 10 10
 10 11
 Explanation

 In the first case:
 The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

 In the second case:
 [2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum.
 For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 * </pre>
 */
public class MaximumSumSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
			if (n > 0) {
				int maxSeqSum = calculateMaxSeqSum(n, a);
				int maxSum = calculateMaxSum(n, a);
				System.out.println(maxSeqSum + " " + maxSum);
			}
		}
	}

	private static int calculateMaxSeqSum(int n, int[] a) {
		int[] table = new int[n];
		int maxSum = a[0];
		table[0] = a[0];
		for (int i = 1; i < n; i++) {
			table[i] = Math.max(table[i - 1] + a[i], a[i]);
			if (table[i] > maxSum) {
				maxSum = table[i];
			}
		}
		return maxSum;
	}

	private static int calculateMaxSum(int n, int[] a) {
		int[] table = new int[n];
		table[0] = a[0];
		for (int i = 1; i < n; i++) {
			int sum = Math.max(table[i - 1] + a[i], a[i]);
			table[i] = sum > table[i - 1] ? sum : table[i - 1];
		}
		return table[n - 1];
	}
}
