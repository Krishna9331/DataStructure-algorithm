package chapter3.problems;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class TwoListMergeToOne<E> {

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

	public int length() {
		int len = 0;
		Node<E> p = head;
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	private static boolean isEqual(Node p, Node m) {
		return p != null && m != null && p.item == m.item && p.next == m.next;
	}

	public static Node findMergePoint(TwoListMergeToOne list1, TwoListMergeToOne list2) {
		Node p = null;
		Node q = null;
		int l1 = list1.length();
		int l2 = list2.length();
		int d = 0;
		if (l1 > l2) {
			d = l1 - l2;
			p = list1.head;
			q = list2.head;
		} else {
			d = l2 - l1;
			p = list2.head;
			q = list1.head;
		}
		for (int i = 0; i < d; i++) {
			p = p.next;
			while (p != null && q != null) {
				if (isEqual(p, q)) {
					return p;
				}
				p = p.next;
				q = q.next;
			}
		}

		return null;
	}

	public static void merge(TwoListMergeToOne list1, TwoListMergeToOne list2) {
		Node p = list1.head;
		Node q = list2.head;
		while (p.next != null && q.next != null) {
			p = p.next;
			q = q.next;
		}
		if (p.next == null) {
			p.next = q.next.next;
		} else {
			q.next = p.next.next;
		}
	}

	public static void main(String[] args) {
		TwoListMergeToOne l1 = new TwoListMergeToOne();
		TwoListMergeToOne l2 = new TwoListMergeToOne();
		l1.insert(1);
		l1.insert(5);
		l1.insert(6);
		l1.insert(9);
		l1.insert(2);
		l1.insert(4);
		l1.insert(7);
		System.out.println("List 1 before merge....");
		l1.print();
		l2.insert(3);
		l2.insert(8);
		System.out.println();
		System.out.println("List 2 before merge....");
		l2.print();
		merge(l1, l2);
		System.out.println();
		System.out.println("After merge------");
		System.out.println("List 1 after merge....");
		l1.print();
		System.out.println();
		System.out.println("List 2 after merge....");
		l2.print();
		System.out.println();
		System.out.println("The merging point element is: " + findMergePoint(l1, l2).item);
	}
}
