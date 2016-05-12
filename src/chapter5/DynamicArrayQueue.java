package chapter5;

/**
 * Created by mishrk3 on 5/12/2016.
 */
public class DynamicArrayQueue<E> {

	private int front;
	private int rear;
	private E[] queue;
	private int capacity;

	public DynamicArrayQueue(int size) {
		front = -1;
		rear = -1;
		capacity = size;
		queue = (E[]) new Object[size];
	}

	public boolean isFull() {
		return (rear + 1) % capacity == front;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public void enQueue(E data) {
		if (isFull()) {
			resizeQueue();
		}
		rear = (rear + 1) % capacity;
		queue[rear] = data;
		if (front == -1) {
			front = rear;
		}
	}

	private void resizeQueue() {
		int newSize = capacity * 2;
		E[] newQueue = (E[]) new Object[newSize];
		int i = 0;
		do {
			newQueue[i] = queue[front];
			front = (front + 1) % capacity;
			i++;
		} while (front != rear);
		newQueue[i] = queue[front];
		rear = capacity - 1;
		capacity = newSize;
		queue = newQueue;
		front = 0;
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
		DynamicArrayQueue<Integer> daq = new DynamicArrayQueue<>(5);
		daq.enQueue(5);
		daq.enQueue(4);
		daq.enQueue(3);
		daq.enQueue(7);
		daq.enQueue(9);
		daq.deQueue();
		daq.deQueue();
		daq.print();
		daq.enQueue(6);
		daq.enQueue(11);
		daq.print();
		daq.enQueue(13);
		daq.print();
		daq.deQueue();
		daq.print();
		DynamicArrayQueue<Integer> daq1 = new DynamicArrayQueue<>(5);
		daq1.enQueue(5);
		daq1.enQueue(4);
		daq1.enQueue(3);
		daq1.enQueue(7);
		daq1.enQueue(9);
		daq1.print();
		daq1.enQueue(11);
		daq1.print();
		daq1.deQueue();
		daq1.print();
	}

}
