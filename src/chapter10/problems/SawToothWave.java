package chapter10.problems;

/**
 * Created by mishrk3 on 3/28/2017.
 */

import chapter10.MergeSort;

import java.util.Arrays;

/**
 * Given an array convert it to a array such that A < B > C < D > E < F
 */
public class SawToothWave {

	/**
	 * @param elements
	 *            array of integers <br/>
	 *            <pre>
	 *            We make sure that all even positioned elements are greater than their adjacent odd position: 1. if
	 *            current even position is smaller than previous odd element, swap previous and current. 
	 *            2. if current even position is smaller than next odd odd element, swap next and current
	 *            </pre>
	 */
	public void createSawToothWave(int[] elements) {
		MergeSort ms = new MergeSort();
		ms.sort(elements);
		for (int i = 1; i < elements.length; i += 2) {
			if (i > 0 && elements[i - 1] > elements[i]) {
				int temp = elements[i];
				elements[i] = elements[i - 1];
				elements[i - 1] = temp;
			}
			if (i < elements.length - 1 && elements[i] < elements[i + 1]) {
				int temp = elements[i];
				elements[i] = elements[i + 1];
				elements[i + 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		SawToothWave stw = new SawToothWave();

		int[] elements = {
				0, -6, 9, 13, 10, -1, 8, 12, 54, 14, -5
		};
		stw.createSawToothWave(elements);
		Arrays.stream(elements).forEach(i -> System.out.printf(" " + i));
	}
}
