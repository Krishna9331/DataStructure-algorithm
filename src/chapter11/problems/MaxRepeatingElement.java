package chapter11.problems;

/**
 * Created by mishrk3 on 3/29/2017.
 */

import java.util.Hashtable;

/**
 * Given an array where all elements of array ranges from 0 to n-1, write an algorithm to find the element which has
 * maximum number of repetition.
 */
public class MaxRepeatingElement {

	/**
	 * @param elements
	 *            the array of integer
	 * @return the element having maximum number of repetition<br/>
	 *         <pre>
	 *     Method works on the below logic
	 *      Add length of the array to each index represented by the elements in array means
	 *       {3, 2, 1, 2, 2, 3}
	 *       the first element 3 will add array length 6 in the element at index 3, which will make array as below:
	 *        {3, 2, 1, 8, 2, 3}
	 *        So if we analyse, the element which repeated most of the times will add 6 that many times to the index.
	 *        Hence for the above array we will add 6, 3 times to the element at 2nd position bacause 2 is repeated 3
	 *        times.
	 *        Also for evaluating index we always do modulo by 6, so that it will always produce the original number
	 *        of array, e.g if we consider {3, 2, 1, 8, 2, 3}, the 8 is not the actual array element it got modified
	 *        after processing the first element of array.
	 *        
	 *        Time Complexity: O(n)
	 *        Space Complexity: O(1)
	 * </pre>
	 */
	public int findMaxRepeatingElement(int[] elements) {
		int max = 0;
		int maxIndex = 0;
		int n = elements.length;
		for (int i = 0; i < n; i++) {
			elements[elements[i] % n] += n;
		}

		for (int i = 0; i < n; i++) {
			if (elements[i] / n > max) {
				max = elements[i] / n;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	/**
	 * @param elements
	 *            the array of integers
	 * @return the elements repeated maximum number of times<br/>
	 *         <pre>
	 *        Time Complexity: O(n)
	 *        Space Complexity: O(1)
	 * </pre>
	 */
	public int maxRepeatingElement(int[] elements) {
		int max = 0;
		int maxElement = -1;
		Hashtable<Integer, Integer> table = new Hashtable<>();
		for (int i : elements) {
			if (table.get(i) != null) {
				table.put(i, table.get(i) + 1);
			} else {
				table.put(i, 1);
			}
			if (table.get(i) > max) {
				maxElement = i;
				max = table.get(i);
			}
		}
		return maxElement;
	}

	public static void main(String[] args) {

		MaxRepeatingElement mre = new MaxRepeatingElement();
		int[] elements = {
				3, 2, 1, 2, 2, 3
		};
		System.out.println("Max repeating element is: " + mre.findMaxRepeatingElement(elements));

		int[] elements1 = {
				3, 2, 1, 2, 2, 3
		};
		System.out.println("Max repeating element is: " + mre.maxRepeatingElement(elements1));
	}
}
