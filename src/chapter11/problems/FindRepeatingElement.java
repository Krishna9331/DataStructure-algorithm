package chapter11.problems;

/**
 * Created by mishrk3 on 3/30/2017.
 */

import static java.lang.Math.sqrt;

/**
 * Given an array with size having elements in range 1 to n, If all elements occurs once except 2 elements which occurs
 * twice. find both the element.
 */
public class FindRepeatingElement {

	/**
	 * @param elements
	 *            array of integer
	 * @param n
	 *            the maximum value of element in array<br/>
	 *            <pre>
	 *                The method works on the behavior of XOR operator, the xor operation of same element will result in
	 *              zero. So if we do the xor of all array element with value 1 to n, it will leave the o/p as 0, if
	 *              no element is repeated. The reason is array contains element from 1 to n hence it will cancel out
	 *              each other after xor. If an array has one repeated element above xor operation will return that
	 *              value. If array has two repeated element xor will o/p the xor result of the repeated elements, and
	 *              same for 3 repeated and so on.
	 *
	 *              Now in given problem 2 element of array is repeated hence if we do xor of all array elements with
	 *              1 to n the o/p will be xor of repeated element.
	 *              Hence if x and y is repeating element the o/p will be x^y.
	 *              Noe we can differentiate the element by significant 1 bit. in the o/p if a bit is set to one this
	 *              means that bit is reverse in x and y. e.g if 3rd bit is set to one than either of x or y has 3rd bit
	 *              has 0 and other has 1. Since zor can result o/p bit as 1 only if both bit is different.
	 *
	 *              So we can divide the element in two category
	 *              1) Element with most significant bit same as most significant of x ^ y  and is 1.
	 *              2) Elements which does not match condition 1
	 *
	 *              So we will divide the array element in two parts as well as 1 to n in two parts.
	 *              Now if we again perform the xor of both part separately we will get o/p x and y.
	 *              The reason is same as above logic we separated the number of array as well as 1 to n, hence equal
	 *              number will cancel out.
	 *
	 *              Time Complexity O(n)
	 *				Space Complexity O(1)
	 *            </pre>
	 */
	public void printRepeatedElements(int[] elements, int n) {
		int xor = 0;
		int x = 0;
		int y = 0;
		int rightmostSetBitNumber;
		for (int i = 1; i < elements.length; i++) {
			xor ^= elements[i];
		}

		for (int i = 1; i <= n; i++) {
			xor ^= i;
		}

		rightmostSetBitNumber = (xor & ~(xor - 1));

		for (int i = 0; i < elements.length; i++) {
			if ((elements[i] & rightmostSetBitNumber) != 0) {
				x = x ^ elements[i];
			} else {
				y = y ^ elements[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((i & rightmostSetBitNumber) != 0) {
				x = x ^ i;
			} else {
				y = y ^ i;
			}
		}
		System.out.println(x + " " + y);
	}

	/**
	 * @param elements
	 *            array of integers containing 1 to n and two repeating element
	 * @param n
	 *            the value of n<br/>
	 *            <pre>
	 *                The below method works on two mathematical formula
	 *                1) The sum of element 1 to n is n(n+1)/2
	 *                2) The multiplication o 1 to n is n!
	 *                Now we know that two element(say x and y) is repeated in array hence if we add all the elements
	 *                of array(say S) it will be n(n+1)/2 + x + y
	 *                Similarly if we multiply all the elements(say P) it will be n! * xy
	 *
	 *                So we can right the above two statement as below two equation:
	 *                 x + y = s - n(n+1)/2
	 *                 xy = p/n!
	 *
	 *
	 *			if we do square of line 109 it will be     (x+y)^2 = x^2 + y^2 + 2xy
	 *			And if we multiply line 110 by 4 it will 	4xy
	 *			Now subtract both equation it will be x^2 + y^2 + 2xy - 4xy = (x-y)^2
	 *		 	hence x - y =  sqrt(s * s - 4 * p) and we already have
	 *		 		  x + y =  arrSum - sum
	 *
	 *		 	x = (s + d) / 2;
	 *			y = (s - d) / 2;
	 *		Time Complexity O(n)
	 *		Space Complexity O(1)
	 *            </pre>
	 */
	public void printRepeatingElementUsingMathematics(int[] elements, int n) {
		int d, x, y;
		int s, p;
		int arrSum = 0;
		int arrMul = 1;

		int fact = factorial(n);
		int sum = n * (n + 1) / 2;

		for (int i = 0; i < elements.length; i++) {
			arrSum += elements[i];
			arrMul *= elements[i];
		}
		s = arrSum - sum; // now value od s is x + y
		p = arrMul / fact; // now value of p is xy
		d = (int) sqrt(s * s - 4 * p);
		x = (s + d) / 2;
		y = (s - d) / 2;

		System.out.println(x + " " + y);
	}

	private int factorial(int n) {
		return go(n, 1);
	}

	private int go(int n, int p) {
		if (n == 0 || n == 1) {
			return p;
		}
		return go(n - 1, n * p);
	}

	public static void main(String[] args) {
		FindRepeatingElement freia = new FindRepeatingElement();

		int[] elements = {
				4, 2, 4, 5, 2, 3, 1
		};
		freia.printRepeatedElements(elements, 5);
		freia.printRepeatingElementUsingMathematics(elements, 5);
	}
}
