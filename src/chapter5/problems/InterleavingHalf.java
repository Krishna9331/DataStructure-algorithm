package chapter5.problems;

import chapter4.ArrayStack;
import chapter5.ArrayQueue;

/**
 * Created by mishrk3 on 5/17/2016.
 */
public class InterleavingHalf {

	private ArrayStack<Integer> stack;
	private ArrayQueue<Integer> queue;
	int size;

	public InterleavingHalf(int size) {
		stack = new ArrayStack<>(size);
		queue = new ArrayQueue<>(size);
		this.size = size;
	}

	public void interLeaveEle() {
		queue.print();
		int halfSize = size / 2;
		for (int i = 0; i < halfSize; i++) {
			stack.push(queue.deQueue());
		}
		while (!stack.isEmpty()) {
			queue.enQueue(stack.pop());
		}
		for (int i = 0; i < halfSize; i++) {
			queue.enQueue(queue.deQueue());
		}
		for (int i = 0; i < halfSize; i++) {
			stack.push(queue.deQueue());
		}

		while (!stack.isEmpty()) {
			queue.enQueue(stack.pop());
			queue.enQueue(queue.deQueue());
		}
		queue.print();
	}

	public static void main(String[] args) {
		InterleavingHalf ilh = new InterleavingHalf(10);
		ilh.queue.enQueue(11);
		ilh.queue.enQueue(12);
		ilh.queue.enQueue(13);
		ilh.queue.enQueue(14);
		ilh.queue.enQueue(15);
		ilh.queue.enQueue(16);
		ilh.queue.enQueue(17);
		ilh.queue.enQueue(18);
		ilh.queue.enQueue(19);
		ilh.queue.enQueue(20);

		ilh.interLeaveEle();
	}
}
