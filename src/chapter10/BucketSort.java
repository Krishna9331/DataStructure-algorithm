package chapter10;

/**
 * Created by mishrk3 on 3/11/2017.
 */

import java.util.Arrays;

/**
 * Bucket sort is important when input is uniformly distributed over a range. e.g sorting float number falling in range
 * 0.0 to 1.0. Bucket sort is generalization of counting sort.
 */
public class BucketSort {

	private static class List {
		int element;
		List next;

		public List(int element, List next) {
			this.element = element;
			this.next = next;
		}
	}

	public void sort(int[] numbers, int maxVal) {

		int n = numbers.length;
		List[] bucket = new List[10];

		for (int i = 0; i < n; i++) {
			int bucketNumber = (10 * numbers[i]) / (maxVal + 1);
			List bucketVal = bucket[bucketNumber];
			List val = new List(numbers[i], null);
			if (bucketVal == null) {
				bucket[bucketNumber] = val;
			} else if (numbers[i] < bucketVal.element) {
				val.next = bucketVal;
				bucket[bucketNumber] = val;
			} else {
				while (bucketVal != null) {
					if (bucketVal.element <= numbers[i]
							&& (bucketVal.next == null || bucketVal.next.element > numbers[i])) {
						val.next = bucketVal.next;
						bucketVal.next = val;
						break;
					}
					bucketVal = bucketVal.next;
				}
			}
		}

		int j = 0;
		for (int i = 0; i < 10; i++) {
			List val = bucket[i];
			while (null != val) {
				numbers[j] = val.element;
				j++;
				val = val.next;
			}
		}
	}

	public static void main(String[] args) {

		BucketSort bs = new BucketSort();

		int[] numbers = {
				22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14
		};

		System.out.println("Array before sorting...");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
		System.out.println();
		bs.sort(numbers, 81);
		System.out.println("Array after sorting...");
		Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
	}
}
