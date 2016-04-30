package chapter3;

/**
 * Created by mishrk3 on 4/29/2016.
 */
public class CircularSinglyLinkedList {

	public Node head;

	public static class Node {

		int item;
		Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public int length() {
		Node p = head;
		int i = 0;
		while (p.next != head) {
			i++;
			p = p.next;
		}
		return i;
	}

	public void insert(int position, int data) {
		Node p = head;
		Node q = p;
		Node newNode = new Node(data, null);
		if (position == 0) {
			if (head == null) {
				head = newNode;
				head.next = head;
			} else {
				while (p.next != head) {
					p = p.next;
				}
				p.next = newNode;
				newNode.next = head;
				head = newNode;
			}
		} else {
			int pos = 0;
			while (p.next != head && pos < position) {
				q = p;
				p = p.next;
				pos++;
			}
			if (p.next == head && pos < position) {
				p.next = newNode;
				newNode.next = head;
			} else {
				q.next = newNode;
				newNode.next = p;
			}
		}
	}

	public void print() {
		Node p = head;
		do {
			System.out.printf(p.item + " --> ");
			p = p.next;
		} while (p != head);
	}

	public void divideIntoTwo() {
		Node slow = head;
		Node fast = head;

		while (fast.next != head && fast.next.next != head) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next.next == head) {
			fast = fast.next;
		}

		CircularSinglyLinkedList cl1 = new CircularSinglyLinkedList();
		CircularSinglyLinkedList cl2 = new CircularSinglyLinkedList();
		cl1.head = head;
		cl2.head = slow.next;
		slow.next = cl1.head;
		fast.next = cl2.head;
		System.out.println("\nPrinting first half");
		cl1.print();
		System.out.println("\nprinting second half");
		cl2.print();
	}

	public Node josephusCircle(CircularSinglyLinkedList cl, int m) {
		Node p = cl.head;
		Node q = null;
		int n = length();
		while (n != 1) {
			for (int i = 0; i < m; i++) {
				q = p;
				p = p.next;
			}
			q.next = p.next;
			n--;
		}
		return p;
	}

	public static void main(String[] args) {
		CircularSinglyLinkedList csl = new CircularSinglyLinkedList();
		csl.insert(0, 5);
		csl.insert(1, 6);
		csl.insert(2, 9);
		csl.insert(3, 3);
		csl.insert(1, 7);
		csl.insert(0, 12);
		csl.insert(4, 4);
		System.out.println("\nprinting actual list......");
		csl.print();
		System.out.println("\ncalling divide circular link list.......");
		csl.divideIntoTwo();

		CircularSinglyLinkedList cs2 = new CircularSinglyLinkedList();
		cs2.insert(0, 5);
		cs2.insert(1, 6);
		cs2.insert(2, 9);
		cs2.insert(3, 3);
		cs2.insert(1, 7);
		cs2.insert(0, 12);
		cs2.insert(4, 4);
		System.out.println("\n josephus cycle for the iteration of 4: ");
		System.out.println(cs2.josephusCircle(cs2, 3).item);
	}
}
