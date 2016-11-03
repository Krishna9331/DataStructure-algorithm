package chapter5.problems;

/**
 * Created by mishrk3 on 5/17/2016.
 */
public class DEQueue<E> {
	Node<E> head;

	private static class Node<E> {
		E item;
		Node<E> prev;
		Node<E> next;

		public Node(E item, Node<E> prev, Node<E> next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void pushBackDEQ(E data) {
		Node<E> newNode = new Node<>(data, null, null);
		if (null == head) {
			head = newNode;
			head.next = head;
			head.prev = head;
		} else {
			newNode.prev = head.prev;
			newNode.next = head;
			head.prev.next = newNode;
			head.prev = newNode;
		}
	}

	public void pushFrontDEQ(E data) {
		pushBackDEQ(data);
		head = head.prev;
	}

	public E popBackDEQ() {
		E data;
		if (head.next == head) {
			data = head.item;
			head = null;
		} else {
			Node<E> temp = head.prev.prev;
			data = head.prev.item;
			temp.next = head;
			head.prev = temp;
		}
		return data;
	}

	public E getFront() {
		return head.item;
	}

	public E getBack() {
		if (head != null) {
			return head.prev.item;
		}
		return null;
	}

	public E popFrontDEQ() {
		E data;
		head = head.next;
		data = popBackDEQ();
		return data;
	}

	public void print() {
		Node<E> p = head;
		do {
			System.out.printf(p.item + "-->");
			p = p.next;
		} while (p != head);
		System.out.println();
	}

	public static void main(String[] args) {
		DEQueue<Integer> deq = new DEQueue<>();
		deq.pushFrontDEQ(5);
		deq.pushFrontDEQ(7);
		deq.pushFrontDEQ(9);
		deq.pushBackDEQ(11);
		deq.print();
		deq.popFrontDEQ();
		deq.print();
		deq.popBackDEQ();
		deq.print();
	}
}
