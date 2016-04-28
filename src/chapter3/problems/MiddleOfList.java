package chapter3.problems;

/**
 * Created by mishrk3 on 4/28/2016.
 */
public class MiddleOfList<E> {
	Node<E> head;

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	public void insert(E item) {
		Node<E> p = head;
		if (head == null) {
			head = new Node<E>(item, null);
		} else {
			while (p.next != null) {
				p = p.next;
			}
			p.next = new Node<E>(item, null);
		}
	}

	public void print() {
		Node<E> p = head;
		while (null != p) {
			System.out.print(p.item + " --> ");
			p = p.next;
		}
	}

	public E findMiddle() {
		Node<E> slow = head;
		Node<E> fast = head;
		int i = 0;
		while (fast != null && fast.next != null && fast.next.next != null) {

			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.item;
	}

	public E findMiddle2() {
		Node<E> slow = head;
		Node<E> fast = head;
		int i = 0;
		while (fast.next != null) {
			if (i == 0) {
				fast = fast.next;
				i = 1;
			} else if (i == 1) {
				fast = fast.next;
				slow = slow.next;
				i = 0;
			}
		}
		return slow.item;
	}

	public void linkedListFromEnd(Node<E> h) {
		if (h == null) {
			return;
		}
		linkedListFromEnd(h.next);
		System.out.print(h.item + " --> ");
	}

	public boolean isEvenLength() {
		Node<E> p = head;
		while (p != null && p.next != null) {
			p = p.next.next;
			if (p == null) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MiddleOfList<Integer> ml = new MiddleOfList<>();
		ml.insert(2);
		ml.insert(4);
		System.out.println("For length 2 middle point is: " + ml.findMiddle());
		System.out.println("For length 2 middle point is using Middle2: " + ml.findMiddle2());
		System.out.println();
		System.out.println("For length 2 isLengthEven: " + ml.isEvenLength());
		System.out.println();
		ml.insert(1);
		ml.insert(3);
		ml.insert(9);
		System.out.println("For length 5 middle point is: " + ml.findMiddle());
		System.out.println("For length 5 middle point is using Middle2: " + ml.findMiddle2());
		System.out.println();
		System.out.println("For length 5 isLengthEven: " + ml.isEvenLength());
		System.out.println();
		ml.insert(6);
		System.out.println("For length 6 middle point is: " + ml.findMiddle());
		System.out.println("For length 6 middle point is using Middle2: " + ml.findMiddle2());
		System.out.println();
		System.out.println("For length 6 isLengthEven: " + ml.isEvenLength());
		System.out.println();
		ml.insert(11);
		ml.insert(7);
		ml.insert(8);
		System.out.println("For length 9 middle point is: " + ml.findMiddle());
		System.out.println("For length 9 middle point is using Middle2: " + ml.findMiddle2());
		System.out.println();
		System.out.println("For length 9 isLengthEven: " + ml.isEvenLength());
		System.out.println();
		System.out.println("Printing ------------------------------->");
		ml.print();
		System.out.println();
		System.out.println("Printing from last now------------------------------->");
		ml.linkedListFromEnd(ml.head);
	}
}
