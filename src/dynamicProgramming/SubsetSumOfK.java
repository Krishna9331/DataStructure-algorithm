package dynamicProgramming;

/**
 * Created by mishrk3 on 5/11/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * find the subset of the array which sums to a given number k
 */
public class SubsetSumOfK {

	public List<Integer> subsetWithSumK(int[] numbers, int k) {
		List<Integer> list = new ArrayList<>();
		int n = numbers.length;
		boolean[][] subsetSum = new boolean[n][k + 1];
		for (int i = 0; i < n; i++) {
			subsetSum[i][0] = true;
		}
		for (int i = 1; i <= k; i++) {
			if (numbers[0] == i) {
				subsetSum[0][i] = true;
			} else {
				subsetSum[0][i] = false;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (numbers[i] > j || subsetSum[i - 1][j]) {
					subsetSum[i][j] = subsetSum[i - 1][j];
				} else {
					subsetSum[i][j] = subsetSum[i - 1][j - numbers[i]];
				}
			}
		}
		if (subsetSum[n - 1][k]) {
			int i = n - 1;
			int j = k;
			while (j > 0 && i >= 0) {
				if (subsetSum[i][j]) {
					i--;
				} else {
					list.add(numbers[i + 1]);
					j = j - numbers[i + 1];
				}
			}
			if (j > 0 && i <= 0) {
				list.add(numbers[i + 1]);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		SubsetSumOfK ssk = new SubsetSumOfK();
		int[] num = {
				2, 3, 7, 8
		};
		List<Integer> res = ssk.subsetWithSumK(num, 11);
		System.out.println("Sum: 11");
		res.stream().forEach(e -> System.out.printf(e + " "));
		System.out.println();
		int[] num1 = {
				2, 3, 5, 4, 9
		};
		List<Integer> res1 = ssk.subsetWithSumK(num1, 15);
		System.out.println("Sum: 15");
		res1.stream().forEach(e -> System.out.printf(e + " "));
	}
}
