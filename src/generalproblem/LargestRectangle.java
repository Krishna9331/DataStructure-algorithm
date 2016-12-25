package generalproblem;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mishrk3 on 12/22/2016.
 */
public class LargestRectangle {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] A = new int[n];
		for(int i = 0; i < n; i++){
			A[i] = sc.nextInt();
		}
		int i, maxArea = -1, top = -1, left, currentArea;
		Stack<StackItem> stack = new Stack<>();
		for (i = 0; i <= n; i++) {
			while (top >= 0 && (i == n || stack.peek().height > A[i])) {
				if (top > 0) {
					StackItem itm = stack.pop();
					left = stack.peek().index;
					stack.push(itm);
				} else {
					left = -1;
				}
				currentArea = (i - left - 1) * stack.peek().height;
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
		System.out.println(maxArea);
	}

	private static class StackItem {
		int height;
		int index;

		public StackItem(int height, int index) {
			this.height = height;
			this.index = index;
		}
	}

}
