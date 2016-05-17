package chapter5;

/**
 * Created by mishrk3 on 5/11/2016.
 */
public class ArrayQueue<E> {

	private int rear;
	private int front;
	private E[] queue;
	private int capacity;

	public ArrayQueue(int size) {
		queue = (E[]) new Object[size];
		capacity = size;
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return (rear + 1) % capacity == front;
	}

	public int getSize() {
		int ele = capacity - front + rear + 1;
		if (front > rear) {
			return capacity - front + rear + 1;
		}
		return rear - front + 1;
	}

	public void enQueue(E data) {
		if (isFull()) {
			System.out.println("Queue overflow");
		} else {
			rear = (rear + 1) % capacity;
			queue[rear] = data;
			if (front == -1) {
				front = rear;
			}
		}
	}

	public E deQueue() {
		E data = null;
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			data = queue[front];
			queue[front] = null;
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front = (front + 1) % capacity;

			}
		}
		return data;
	}

	public void print() {
		for (E e : queue) {
			System.out.print(e + " -> ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<>(3);
		queue.deQueue();
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(8);
		queue.print();
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(8);
		queue.print();
	}
}
