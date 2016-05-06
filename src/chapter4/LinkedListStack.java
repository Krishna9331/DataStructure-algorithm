package chapter4;

/**
 * Created by mishrk3 on 5/4/2016.
 */
public class LinkedListStack<E> {

	private Node<E> head;

	private static class Node<E> {
		E item;
		Node<E> next;

		public Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	public void push(E item) {
		System.out.println("push: " + item);
		Node<E> newNode = new Node<>(item, null);
		newNode.next = head;
		head = newNode;
	}

	public E pop() {
		if (isEmpty()) {
			System.out.println("stack is Empty -> empty stack exception");
			return null;
		}
		System.out.println("pop: " + head.item);
		E data = head.item;
		head = head.next;
		return data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public E getTop() {
		return head.item;
	}

	public void print() {
		Node<E> p = head;
		while (p != null) {
			System.out.print(p.item + " -->");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListStack<Integer> lls = new LinkedListStack<>();
		lls.pop();
		lls.push(5);
		lls.push(4);
		lls.push(6);
		lls.push(9);
		System.out.println("elements in stack ...");
		lls.print();
		System.out.println("top element: " + lls.getTop());
		lls.pop();
		System.out.println("top element: " + lls.getTop());
		System.out.println("elements in stack ...");
		lls.print();
	}

}
