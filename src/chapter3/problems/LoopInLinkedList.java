package chapter3.problems;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by mishrk3 on 4/26/2016.
 */
public class LoopInLinkedList<E> {

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

	public boolean isLoopUsingHashTable() {
		Hashtable<Integer, Node<E>> hashtable = new Hashtable<>();
		Node<E> p = head;
		int len = 0;
		while (p != null) {
			len++;
			if (checkTable(hashtable, p)) {
				return true;
			} else {
				hashtable.put(len, p);
			}
			p = p.next;
		}
		return false;
	}

	private boolean checkTable(Hashtable<Integer, Node<E>> hashtable, Node<E> p) {
		for (Map.Entry<Integer, Node<E>> m : hashtable.entrySet()) {
			if ((p.item == m.getValue().item) && (p.next == m.getValue().next)) {
				return true;
			}
		}
		return false;
	}

	private void createLoop() {
		Node<E> p = head;
		Node q = p.next.next;
		while (p.next != null) {
			p = p.next;
		}
		p.next = q;
	}

	public static void main(String[] args) {
		LoopInLinkedList<Integer> lil = new LoopInLinkedList<>();
		lil.insert(2);
		lil.insert(4);
		lil.insert(6);
		lil.insert(3);
		lil.insert(9);
		lil.insert(8);
		System.out.println("Link list has loop: " + lil.isLoopUsingHashTable());
		lil.createLoop();
		System.out.println("Link list has loop after createLoop call: " + lil.isLoopUsingHashTable());
	}

}
