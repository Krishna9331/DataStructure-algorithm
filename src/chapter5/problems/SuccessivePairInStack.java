package chapter5.problems;

import chapter4.ArrayStack;
import chapter5.ArrayQueue;

/**
 * Created by mishrk3 on 5/17/2016.
 */
public class SuccessivePairInStack {

	private ArrayStack<Integer> stack;
	private ArrayQueue<Integer> queue;

	public SuccessivePairInStack(int size) {
		stack = new ArrayStack<>(size);
		queue = new ArrayQueue<>(size);
	}

	public boolean checkPairWise() {
		//First reverse the stack content as we have to compare from first element.
		//while the stack return last element first
		while (!stack.isEmpty()) {
			queue.enQueue(stack.pop());
		}

		while (!queue.isEmpty()) {
			stack.push(queue.deQueue());
		}

		while (!stack.isEmpty()) {
			int m = stack.pop();
			if (!stack.isEmpty()) {
				int n = stack.pop();
				if (Math.abs(m - n) != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SuccessivePairInStack spis = new SuccessivePairInStack(5);
		spis.stack.push(7);
		spis.stack.push(6);
		spis.stack.push(4);
		spis.stack.push(5);
		spis.stack.push(9);
		System.out.println("spis is paired: " + spis.checkPairWise());

		SuccessivePairInStack spis1 = new SuccessivePairInStack(6);
		spis1.stack.push(6);
		spis1.stack.push(7);
		spis1.stack.push(9);
		spis1.stack.push(8);
		spis1.stack.push(3);
		spis1.stack.push(4);
		System.out.println("spis1 is paired: " + spis1.checkPairWise());

		SuccessivePairInStack spis2 = new SuccessivePairInStack(6);
		spis2.stack.push(6);
		spis2.stack.push(7);
		spis2.stack.push(9);
		spis2.stack.push(9);
		spis2.stack.push(3);
		spis2.stack.push(4);
		System.out.println("spis2 is paired: " + spis2.checkPairWise());
	}

}
