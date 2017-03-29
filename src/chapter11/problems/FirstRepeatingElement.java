package chapter11.problems;

/**
 * Created by mishrk3 on 3/29/2017.
 */

import java.util.Hashtable;

import static java.lang.Math.abs;

/**
 * Given an array of integer where each element is in range 0 to n-1, find the first element which is repeating.
 */
public class FirstRepeatingElement {

	/**
	 * @param elements
	 *            the array of integer
	 * @return the element which is repeating and occurs before any other repeating element<br/>
	 *         <pre>
	 *     We store the element Vs position(index+1) of the element in hash table. If we find any element in array
	 *     which already has an entry in hash table we just make the value (which is position) as negative, 
	 *     in case it is not negative. Finally we return the number at largest negative position(-1 > -2 > -3)
	 *     Time Complexity: O(n)
	 *     Space Complexity: O(n)
	 * </pre>
	 */
	public int findFirstRepeatingElement(int[] elements) {
		int firstIndex = Integer.MIN_VALUE;
		Hashtable<Integer, Integer> table = new Hashtable<>();
		for (int i = 0; i < elements.length; i++) {
			int element = elements[i];
			if (table.get(element) != null && table.get(element) > 0) {
				table.put(element, -table.get(element));
			} else if (table.get(element) == null) {
				table.put(element, i + 1);
			}
			if (table.get(element) < 0 && table.get(element) > firstIndex) {
				firstIndex = table.get(element);
			}
		}
		return elements[abs(firstIndex) - 1];
	}

	public static void main(String[] args) {
		FirstRepeatingElement fre = new FirstRepeatingElement();

		int[] elements = {
				3, 2, 1, 2, 2, 3
		};
		int ele = fre.findFirstRepeatingElement(elements);
		System.out.println("The first repeating element is: " + ele);

		int[] elements1 = {
				33, 24, 53, 67, 22, 53, 24, 35
		};
		int ele1 = fre.findFirstRepeatingElement(elements1);
		System.out.println("The first repeating element is: " + ele1);
	}
}
