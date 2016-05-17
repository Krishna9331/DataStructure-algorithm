package chapter5.problems;

import chapter5.ArrayQueue;

/**
 * Created by mishrk3 on 5/16/2016.
 */
public class StackUsingTwoQueue {

	private ArrayQueue<Integer> q1;
	private ArrayQueue<Integer> q2;

	public StackUsingTwoQueue(int size) {
		q1 = new ArrayQueue<>(size);
		q2 = new ArrayQueue<>(size);
	}

	public void push(int data) {
		if (q1.isEmpty()) {
			q2.enQueue(data);
		} else {
			q1.enQueue(data);
		}
	}

	public Integer pop() {
		if (q1.isEmpty()) {
			while (1 < q2.getSize()) {
				q1.enQueue(q2.deQueue());
			}
			return q2.deQueue();
		} else {
			while (1 < q1.getSize()) {
				q2.enQueue(q1.deQueue());
			}
			return q1.deQueue();
		}
	}

	public static void main(String[] args) {
		StackUsingTwoQueue sutq = new StackUsingTwoQueue(5);
		sutq.push(3);
		sutq.push(2);
		sutq.push(9);
		sutq.push(7);
		System.out.println(sutq.pop());
		System.out.println(sutq.pop());
		sutq.push(11);
		System.out.println(sutq.pop());
	}
}
