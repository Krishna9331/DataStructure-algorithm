package chapter11.problems;

/**
 * Created by mishrk3 on 4/3/2017.
 */

import static java.lang.Math.abs;

import chapter10.QuickSort;

/**
 * Given an array of positive and negative integers find the pair whose sum is closest to zero.
 */
public class ElementsWithSumCloserToZero {

	public void findClosestToZeroSum(int[] elements) {
		int smallestPositive = Integer.MAX_VALUE, greatestNegative = Integer.MIN_VALUE;
		int temp = Integer.MAX_VALUE;
		int posPair1 = 0, posPair2 = 0, negPair1 = 0, negPair2 = 0, smallestSum, smallPair1, smallPair2;
		QuickSort qs = new QuickSort();
		qs.sort(elements);
		int i = 0, j = elements.length - 1;
		while (i < j) {
			temp = elements[i] + elements[j];
			if (temp > 0) {
				if (temp < smallestPositive) {
					smallestPositive = temp;
					posPair1 = elements[i];
					posPair2 = elements[j];
				}
				j--;
			} else if (temp < 0) {
				if (temp > greatestNegative) {
					greatestNegative = temp;
					negPair1 = elements[i];
					negPair2 = elements[j];
				}
				i++;
			} else {
				System.out.println(elements[i] + " " + elements[j]);
			}
		}
		if (abs(greatestNegative) > smallestPositive) {
			smallestSum = smallestPositive;
			smallPair1 = posPair1;
			smallPair2 = posPair2;
		} else {
			smallestSum = greatestNegative;
			smallPair1 = negPair1;
			smallPair2 = negPair2;
		}
		System.out.println(
				"The smallest sum is: " + smallestSum + " and the elements are: " + smallPair1 + " " + smallPair2);
	}

	public static void main(String[] args) {
		ElementsWithSumCloserToZero ewsctz = new ElementsWithSumCloserToZero();
		int[] elements = {
				1, 60 - 10, 70, -80, 85
		};
		ewsctz.findClosestToZeroSum(elements);
	}
}
