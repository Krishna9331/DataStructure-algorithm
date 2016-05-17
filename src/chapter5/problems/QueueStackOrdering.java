package chapter5.problems;

import chapter4.ArrayStack;
import chapter5.ArrayQueue;

/**
 * Created by mishrk3 on 5/17/2016.
 */
public class QueueStackOrdering {

	private ArrayStack<Integer> stack;
	private ArrayQueue<Integer> queue;

	public QueueStackOrdering(int size) {
		stack = new ArrayStack<>(size);
		queue = new ArrayQueue<>(size);
	}

	/*public Integer pop() {
		while (!queue.isEmpty()) {
			stack.push(queue.deQueue());
		}
	}*/
}
