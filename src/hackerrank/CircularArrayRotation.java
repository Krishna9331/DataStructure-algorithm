package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 11/28/2016.
 */
public class CircularArrayRotation {

	/**
	 * Logic for below method is:
	 *
	 * 1. Divide the array into two parts: one part contains last K elements, where k is number of circular rotation.
	 * next part is remaining elements from part one.
	 * 2. Reverse both the part of array separately.
	 * 3. Reverse the whole array together.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int l = n - k%n;
		swapElements(a, 0, l - 1);
		swapElements(a, l, n - 1);
		swapElements(a, 0, n - 1);

		for (int a0 = 0; a0 < q; a0++) {
			int m = in.nextInt();
			System.out.println(a[m]);
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
