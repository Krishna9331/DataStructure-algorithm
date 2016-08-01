package chapter2.recursion;

import java.util.function.BiFunction;

/**
 * Created by mishrk3 on 7/20/2016.
 */
public class BinarySearch {

	public int binarySearch(int[] numbers, int key, BiFunction<Integer, Integer, Boolean> gt) {
		return go(numbers, 0, 0, numbers.length - 1, key, gt);
	}

	private int go(int[] numbers, int low, int mid, int high, int key, BiFunction<Integer, Integer, Boolean> gt) {
		if (low > high)
			return -mid - 1;
		else {
			int mid2 = (low + high) / 2;
			Integer midEle = numbers[mid2];
			boolean greater = gt.apply(midEle, key);
			if (!greater && !gt.apply(key, midEle))
				return mid2;
			if (greater)
				return go(numbers, low, mid2, mid2 - 1, key, gt);
			else
				return go(numbers, mid2 + 1, mid2, high, key, gt);
		}
	}

	public static void main(String[] args) {
		BinarySearch search = new BinarySearch();
		int[] num = { 1, 3, 6, 9, 11, 23, 37, 99 };
		int index = search.binarySearch(num, 37, (x, y) -> x > y);
		int index1 = search.binarySearch(num, 35, (x, y) -> x > y);
		System.out.println("The element is at index: " + index);
		System.out.println("The element is at index: " + index1);
	}
}
