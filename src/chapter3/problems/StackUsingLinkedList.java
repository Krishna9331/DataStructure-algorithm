package chapter3.problems;

/**
 * Created by mishrk3 on 4/25/2016.
 */
public class StackUsingLinkedList<E> {

	Node<E> head;

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	public void push(E data) {
		Node<E> p = head;
		Node<E> newNode = new Node<E>(data, null);
		if (p == null) {
			head = newNode;
		} else {
			while (p.next != null) {
				p = p.next;
			}
			p.next = newNode;
		}

	}

	public void pop() {
		Node<E> p = head;
		Node<E> q = null;
		if (p == null) {
			System.out.println("Stack is empty");
		} else {
			while (p.next != null) {
				q = p;
				p = p.next;
			}
			q.next = null;
		}

	}

	public void print() {
		Node<E> p = head;
		while (null != p) {
			System.out.print(p.item + " --> ");
			p = p.next;
		}
	}

	public static void main(String[] args) {
		StackUsingLinkedList<Integer> sl = new StackUsingLinkedList<Integer>();
		sl.push(1);
		sl.push(4);
		sl.push(5);
		sl.push(7);
		sl.print();
		System.out.println();
		System.out.println("calling pop ... ");
		sl.pop();
		sl.print();
		System.out.println();
		System.out.println("pushing 9 again....");
		sl.push(9);
		sl.print();
		System.out.println();
		System.out.println("pop two times...");
		sl.pop();
		sl.pop();
		sl.print();
	}

}
