package chapter4.problems;

import chapter4.ArrayStack;

/**
 * Created by mishrk3 on 5/9/2016.
 */
public class LargestRectangleInHistogram {

	/**
	 * @param A array containing histogram details height of each rectangle
	 * @param n number of element in array A
	 * @return maximum possible area of rectangle.
	 * Logic: We start processing element from left to right and keep track of processed element and yet to process in
	 * stack. if stack is empty open the subproblem by pushing the current element. Each element of stack contains the
	 * height and index of rectangle.
	 * if stack is not empty compare the top element with the next one and do below:
	 * 1. if element is greater than top push it to stack and process next element
	 * 2. if it is equal skip it and process next element.
	 * 3. However, if element is small calculate all possible current area and populate the max if it is more than
	 * existing max.
	 * for below code steps:
	 * it will start for loop for processing left to right.
	 * STEP 1: at first element(3, 0) code finds that stack is empty, so it push the element in stack.
	 * once it compare the next, which is (2,1) hence breaks the current sub problem and calculate area.(possible area
	 * is only one 3*1.
	 * <br/>
	 * STEP2: next start the sub problem with current element(2, 1).
	 * it checks for next element (5, 2) and (6, 2) and push it to stack, however will break at (1,4). hence stack
	 * will have 3 values, and it will calculate all possible area(which are: 6*1, 5*2 and then 2*4)
	 * STEP3: same it will continue with (1, 0)....
	 * <br/>
	 * CONCEPT: the bottom element in stack at any instance will be the lowest in height, hence while
	 * calculating the current area we multiply the height of element with width of till now traversed rectangle.
	 */
	public int maxRectangleArea(int A[], int n) {
		int i, maxArea = -1, top = -1, left, currentArea;
		ArrayStack<StackItem> stack = new ArrayStack<>(n);
		for (i = 0; i <= n; i++) {
			while (top >= 0 && (i == n || stack.getTop().height > A[i])) {
				if (top > 0) {
					left = stack.getNthTop(1).index;
				} else {
					left = -1;
				}
				currentArea = (i - left - 1) * stack.getTop().height;
				stack.pop();
				--top;
				if (currentArea > maxArea) {
					maxArea = currentArea;
				}
			}

			if (i < n) {
				++top;
				StackItem si = new StackItem(A[i], i);
				stack.push(si);
			}
		}
		return maxArea;
	}

	private static class StackItem {
		int height;
		int index;

		public StackItem(int height, int index) {
			this.height = height;
			this.index = index;
		}
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
//		int[] input = { 3, 2, 5, 6, 1, 4, 4 };
		int[] input = { 1, 2, 3, 4, 5 };
		int result = lrh.maxRectangleArea(input, 5);
//		int result = lrh.maxRectangleArea(input, 7);
		System.out.println("Max Possible area of rectangle :" + result);
	}

}
