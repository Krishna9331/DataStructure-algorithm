package chapter5.problems;

import chapter4.ArrayStack;

/**
 * Created by mishrk3 on 5/16/2016.
 */
public class QueueWithTwoStack {

	private ArrayStack<Integer> enQueueStack;
	private ArrayStack<Integer> deQueueStack;

	public QueueWithTwoStack(int size) {
		enQueueStack = new ArrayStack<>(size);
		deQueueStack = new ArrayStack<>(size);
	}

	public void enQueue(Integer data) {
		enQueueStack.push(data);
	}

	public Integer deQueue() {
		if (!deQueueStack.isEmpty()) {
			return deQueueStack.pop();
		} else {
			while (!enQueueStack.isEmpty()) {
				deQueueStack.push(enQueueStack.pop());
			}
			return deQueueStack.pop();
		}
	}

	public static void main(String[] args) {
		QueueWithTwoStack qwts = new QueueWithTwoStack(5);
		qwts.enQueue(5);
		qwts.enQueue(7);
		qwts.enQueue(3);
		qwts.enQueue(2);
		qwts.enQueue(9);
		System.out.println("removing element");
		System.out.println(qwts.deQueue());
		System.out.println(qwts.deQueue());
		System.out.println(qwts.deQueue());
		qwts.enQueue(11);
		qwts.enQueue(13);
		System.out.println(qwts.deQueue());
		System.out.println(qwts.deQueue());
	}
}
