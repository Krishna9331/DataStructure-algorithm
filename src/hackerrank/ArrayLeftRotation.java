package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 12/12/2016.
 *
 * <pre>
 *
 *     A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

 Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

 Input Format

 The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
 The second line contains  space-separated integers describing the respective elements of the array's initial state.

 Constraints

 Output Format

 Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

 Sample Input

 5 4
 1 2 3 4 5
 Sample Output

 5 1 2 3 4
 Explanation

 When we perform  d =4 left rotations, the array undergoes the following sequence of changes:
	[1, 2, 3,4 ,5] -> [2, 3, 4, 5, 1] -> [3, 4, 5, 1 , 2] -> [4, 5, 1, 2, 3] -> [5, 1, 2, 3, 4]
 Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 * </pre>
 */
public class ArrayLeftRotation {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int l = k%n;
		swapElements(a, 0, l - 1);
		swapElements(a, l, n - 1);
		swapElements(a, 0, n - 1);

		for (int a0 = 0; a0 < n; a0++) {
			System.out.print(a[a0] +" ");
		}
	}

	public static void swapElements(int[] array, int startIndex, int endIndex) {
		int temp = 0;
		while (startIndex < endIndex)
		{
			temp = array[startIndex];
			array[startIndex] = array[endIndex];
			array[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
}
