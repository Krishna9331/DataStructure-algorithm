package chapter3.problems;

/**
 * Created by mishrk3 on 4/28/2016.
 */
public class SampleList {
	public Node head;

	public static class Node {
		int item;
		Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public void insert(int item) {
		Node p = head;
		if (head == null) {
			head = new Node(item, null);
		} else {
			while (p.next != null) {
				p = p.next;
			}
			p.next = new Node(item, null);
		}
	}

	public void deleteFromLinkedList(int position) {
		if (null == head) {
			System.out.println("List is empty...");
			return;
		}
		int k = 0;
		Node p = head, q = null;
		if (position == 0) {
			head = head.next;
			return;
		} else {
			while (null != p && k < position) {
				k++;
				q = p;
				p = p.next;
			}
			if (null == p) {
				System.out.println("Position does not exist...");
			} else {
				q.next = p.next;
			}
		}
	}

	public void print() {
		Node p = head;
		while (null != p) {
			System.out.print(p.item + " --> ");
			p = p.next;
		}
	}
}
