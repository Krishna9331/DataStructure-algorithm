package chapter4.problems;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 5/6/2016.
 */
public class ReverseStack {

	public void reverseStack(LinkedListStack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int data = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, data);
	}

	private void insertAtBottom(LinkedListStack<Integer> stack, int data) {
		if (stack.isEmpty()) {
			stack.push(data);
		} else {
			int temp = stack.pop();
			insertAtBottom(stack, data);
			stack.push(temp);
		}
	}

	public static void main(String[] args) {
		ReverseStack rs = new ReverseStack();
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		stack.push(2);
		stack.push(6);
		stack.push(5);
		/*stack.push(1);
		stack.push(4);*/
		stack.print();
		rs.reverseStack(stack);
		stack.print();
	}
}
