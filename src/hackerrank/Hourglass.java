package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 12/9/2016.
 */

/**
 * <pre>
     Context 
 Given a  2D Array, :

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

 a b c
 d
 e f g
 There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values.

 Task 
 Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

 Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

 Input Format

 There are  lines of input, where each line contains  space-separated integers describing 2D Array ; every value in  will be in the inclusive range of  to .

 Constraints

 Output Format

 Print the largest (maximum) hourglass sum found in .

 Sample Input

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 2 4 4 0
 0 0 0 2 0 0
 0 0 1 2 4 0
 Sample Output

 19
 Explanation

 contains the following hourglasses:

 1 1 1   1 1 0   1 0 0   0 0 0
 1       0       0       0
 1 1 1   1 1 0   1 0 0   0 0 0

 0 1 0   1 0 0   0 0 0   0 0 0
 1       1       0       0
 0 0 2   0 2 4   2 4 4   4 4 0

 1 1 1   1 1 0   1 0 0   0 0 0
 0       2       4       4
 0 0 0   0 0 2   0 2 0   2 0 0

 0 0 2   0 2 4   2 4 4   4 4 0
 0       0       2       0
 0 0 1   0 1 2   1 2 4   2 4 0
 The hourglass with the maximum sum () is:

 2 4 4
 2
 1 2 4
 *     
 * </pre>
 */
public class Hourglass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int arr_i = 0; arr_i < 6; arr_i++) {
			for (int arr_j = 0; arr_j < 6; arr_j++) {
				arr[arr_i][arr_j] = in.nextInt();
			}
		}
		int maxSum = Integer.MIN_VALUE;
		int k = 0;
		int[] maxarray = new int[7];
		int i = 0;
		while (i < 4) {
			int j = 0;
			while (j < 4) {
				int sum = 0;
				for (k = 0; k < 3; k++) {
					sum = sum + arr[i][k + j];
				}
				sum = sum + arr[i + 1][k - 2 + j];
				for (k = 0; k < 3; k++) {
					sum = sum + arr[i + 2][k + j];
				}
				if (sum > maxSum) {
					maxSum = sum;
					int p = 0;
					for (k = 0; k < 3; k++) {
						maxarray[p] = arr[i][k + j];
						p++;
					}
					maxarray[p] = arr[i + 2][k + j - 1];
					p++;
					for (k = 0; k < 3; k++) {
						maxarray[p] = arr[i + 2][k + j];
						p++;
					}
				}
				j++;
			}
			i++;
		}
		int l = 0;
		for (k = 0; k < 3; k++) {
			System.out.print(maxarray[l] + " ");
			l++;
		}
		System.out.println();
		System.out.println("  " + maxarray[l]);
		l++;
		for (k = 0; k < 3; k++) {
			System.out.print(maxarray[l] + " ");
			l++;
		}
		System.out.println(maxSum);
	}
}
