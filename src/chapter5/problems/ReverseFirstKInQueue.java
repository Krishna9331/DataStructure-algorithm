package chapter5.problems;

import chapter4.ArrayStack;
import chapter5.ArrayQueue;

/**
 * Created by mishrk3 on 5/17/2016.
 */
public class ReverseFirstKInQueue {
	private ArrayStack<Integer> stack;
	private ArrayQueue<Integer> queue;
	int size;

	public ReverseFirstKInQueue(int size) {
		stack = new ArrayStack<>(size);
		queue = new ArrayQueue<>(size);
		this.size = size;
	}

	public void reverseFirstK(int k) {
		for (int i = 0; i < k; i++) {
			stack.push(queue.deQueue());
		}
		while (!stack.isEmpty()) {
			queue.enQueue(stack.pop());
		}
		for (int i = 0; i < queue.getSize() - k; i++) {
			queue.enQueue(queue.deQueue());
		}
	}

	public static void main(String[] args) {
		ReverseFirstKInQueue rfke = new ReverseFirstKInQueue(9);
		rfke.queue.enQueue(10);
		rfke.queue.enQueue(20);
		rfke.queue.enQueue(30);
		rfke.queue.enQueue(40);
		rfke.queue.enQueue(50);
		rfke.queue.enQueue(60);
		rfke.queue.enQueue(70);
		rfke.queue.enQueue(80);
		rfke.queue.enQueue(90);
		rfke.queue.print();
		rfke.reverseFirstK(4);
		rfke.queue.print();
	}
}
