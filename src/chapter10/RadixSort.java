package chapter10;

import java.util.Arrays;

/**
 * Created by mishrk3 on 3/14/2017.
 */
public class RadixSort {

	public void sort(int[] numbers) {
		int n = numbers.length;
		int max = getMax(numbers, n);

		for (int exp = 1; max / exp > 0; exp *= 10) {
			doCountSort(numbers, n, exp);
		}
	}

	private void doCountSort(int[] numbers, int n, int exp) {
		int[] output = new int[n];
		int i;
		int[] temp = new int[10];

		for (i = 0; i < 10; i++) {
			temp[i] = 0;
		}

		for (i = 0; i < n; i++) {
			temp[(numbers[i] / exp) % 10]++;
		}

		for (i = 1; i < 10; i++) {
			temp[i] += temp[i - 1];
		}

		for (i = n - 1; i >= 0; i--) {
			output[temp[(numbers[i] / exp) % 10] - 1] = numbers[i];
			temp[(numbers[i] / exp) % 10]--;
		}

		for (i = 0; i < n; i++) {
			numbers[i] = output[i];
		}

	}

	private int getMax(int[] numbers, int len) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		RadixSort rs = new RadixSort();

		int[] numbers = {
				170, 45, 75, 90, 802, 24, 2, 66
		};

		System.out.println("Array before sorting...");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println();
		rs.sort(numbers);
		System.out.println("Array after sorting...");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
