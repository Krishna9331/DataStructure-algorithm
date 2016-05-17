package chapter5;

/**
 * Created by mishrk3 on 5/13/2016.
 */
public class LinkedListQueue<E> {
	public Node<E> head;

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	public void enQueue(E item) {
		Node<E> newNode = new Node<>(item, null);
		if (head == null) {
			head = newNode;
		} else {
			Node<E> p = head;
			while (p.next != null) {
				p = p.next;
			}
			p.next = newNode;
		}
	}

	public E deQueue() {
		if (head == null) {
			System.out.println("Queue is empty");
		}
		E data = head.item;
		head = head.next;
		return data;
	}

	public void print() {
		Node<E> p = head;
		do {
			System.out.print(p.item + "-->");
			p = p.next;
		} while (p != null);
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListQueue<Integer> daq = new LinkedListQueue<>();
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
		LinkedListQueue<Integer> daq1 = new LinkedListQueue<>();
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
