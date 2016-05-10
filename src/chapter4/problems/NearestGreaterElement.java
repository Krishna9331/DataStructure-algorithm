package chapter4.problems;

import chapter4.ArrayStack;

import java.util.Map;

/**
 * Created by mishrk3 on 5/10/2016.
 */
public class NearestGreaterElement {

	public void withNearestGreaterEle(int[] A, int n) {
		int i = 0;
		int element, nearGrtEle;
		ArrayStack<Integer> stack = new ArrayStack<>(n);
		stack.push(A[0]);
		for (i = 1; i < A.length; i++) {
			nearGrtEle = A[i];
			if (!stack.isEmpty()) {
				element = stack.pop();
				while (element < nearGrtEle) {
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}
				if (element > nearGrtEle) {
					stack.push(element);
				}
			}
			stack.push(nearGrtEle);
		}
		while (!stack.isEmpty()) {
			element = stack.pop();
			nearGrtEle = Integer.MIN_VALUE;
			System.out.println(element + " : " + nearGrtEle);
		}
	}

	public static void main(String[] args) {
		NearestGreaterElement nge = new NearestGreaterElement();
		int [] input = {5, 2, 4, 6, 1, 4, 4};
		nge.withNearestGreaterEle(input, 7);
	}
}
