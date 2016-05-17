package chapter5.problems;

import chapter4.ArrayStack;
import chapter5.ArrayQueue;

/**
 * Created by mishrk3 on 5/16/2016.
 */
public class ReverseQueue {

	public void reverseQueue(ArrayQueue<Integer> queue) {
		ArrayStack<Integer> stack = new ArrayStack<>(queue.getSize());
		while (!queue.isEmpty()) {
			stack.push(queue.deQueue());
		}
		while (!stack.isEmpty()) {
			queue.enQueue(stack.pop());
		}
	}

	public static void main(String[] args) {
		ReverseQueue rq = new ReverseQueue();
		ArrayQueue<Integer> queue = new ArrayQueue<>(5);
		queue.enQueue(5);
		queue.enQueue(4);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(2);
		System.out.println("The original queue is: ");
		queue.print();
		rq.reverseQueue(queue);
		System.out.println("Queue after reversal is: ");
		queue.print();
	}
}
