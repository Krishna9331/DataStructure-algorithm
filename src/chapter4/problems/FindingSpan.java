package chapter4.problems;

import chapter4.ArrayStack;

/**
 * Created by mishrk3 on 5/9/2016.
 */
public class FindingSpan {

	/**
	 * @param A input array with price on each day
	 * @param n number of element in array
	 * @return an array containing span for each index or day.
	 * The logic for code is: push the first index(0) and then move to the next index(for loop).
	 * Every index check if it is greater than previous index, if that's true then pop it from array.
	 * The above process continues until it finds value larger than itself. e.g for below code, flow is:
	 * 0 -> stack was empty so set p = -1 and then push 0.   Stack: [0]
	 * 1->	it check and find A[0] is grater than A[1] and does nothing, and push 1.  Stack [1, 0]
	 * 2 -> it finds A[1] is smaller hence pop out, however A[0] is larger so take difference 2 - 0 and push 2. Stack
	 * <tab>	</tab><tab>	</tab><tab>	</tab><tab>	</tab>Stack [2, 0]
	 * 3-> it finds it is larger then A[2] hence pop it out, however smaller than A[0], difference 3 - 0 and push 3.
	 * * <tab>	</tab><tab>	</tab><tab>	</tab><tab>	</tab>Stack [3, 0]
	 * 4 -> it finds that it smaller than A[3], hence does nothing take difference 4-3  and push 4. Stack[4, 3, 0]
	 * Each index vs the difference of top and index value is pushed in output array.
	 */
	public int[] findingSpan(int[] A, int n) {
		int p = 0;
		int[] s = new int[n];
		ArrayStack<Integer> stack = new ArrayStack<>(n);
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && A[i] > A[stack.getTop()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				p = -1;
			} else {
				p = stack.getTop();
			}
			s[i] = i - p;
			stack.push(i);
		}
		return s;
	}

	public static void main(String[] args) {
		FindingSpan fs = new FindingSpan();
		int[] input = { 6, 3, 4, 5, 2 };
		int[] result = fs.findingSpan(input, 5);
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " --> " + result[i]);
		}
	}

}
