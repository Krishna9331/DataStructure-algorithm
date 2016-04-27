package chapter3.problems;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class InsertInSortedLinkedList {
	Node head;

	private static class Node {
		int item;
		Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public void insert(int item) {
		Node p = head, q = null;
		Node newNode = new Node(item, null);
		if (head == null) {
			head = newNode;
		} else {
			while (p.next != null && p.item <= item) {
				q = p;
				p = p.next;
			}
			if (q == null) {
				newNode.next = head;
				head = newNode;
			} else if (p.item < newNode.item) {
				p.next = newNode;
				newNode.next = null;
			} else {
				q.next = newNode;
				newNode.next = p;
			}
		}
	}

	public void reverseList() {
		Node temp = null, nextNode = null;
		while (head != null) {
			nextNode = head.next;
			head.next = temp;
			temp = head;
			head = nextNode;
		}
		head = temp;
	}

	public void print() {
		Node p = head;
		while (p != null) {
			System.out.println("-->" + p.item);
			p = p.next;
		}
	}

	public static void main(String[] args) {
		InsertInSortedLinkedList isl = new InsertInSortedLinkedList();
		isl.insert(5);
		isl.insert(2);
		isl.insert(4);
		isl.insert(7);
		isl.insert(9);
		isl.insert(1);
		isl.insert(2);
		isl.insert(11);
		isl.print();
		isl.reverseList();
		System.out.println();
		System.out.println("List after reversal");
		isl.print();
	}
}
