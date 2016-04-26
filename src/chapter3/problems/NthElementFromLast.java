package chapter3.problems;

import java.util.Hashtable;

/**
 * Created by mishrk3 on 4/25/2016.
 */
public class NthElementFromLast<E> {

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

	public E nthElement(int position) {
		Node<E> p = head;
		int len = 0;
		if (p == null) {
			System.out.println("list is empty");
		} else {
			while (p != null) {
				p = p.next;
				len++;
			}
			if (len < position - 1) {
				System.out.println("there is not enough element in list");
			} else {
				int pos = (len - position) + 1;
				p = head;
				while (pos > 1) {
					p = p.next;
					pos--;
				}
				return p.item;
			}
		}
		return null;
	}

	public E nthEleUsingHashTable(int position) {
		Hashtable<Integer, Node<E>> table = new Hashtable<>();
		Node<E> p = head;
		int len = 0;
		while (p != null) {
			len++;
			table.put(len, p);
			p = p.next;
		}
		if (len < position - 1) {
			System.out.println("not enough number of element");
			return null;
		}
		return table.get(len - position + 1).item;
	}

	public E nthEleTwoPointer(int position) {
		Node<E> p = head, temp = null;
		for (int i = 1; i < position; i++) {
			if (p != null) {
				p = p.next;
			}
		}
		while (p != null) {
			if (temp == null) {
				temp = head;
			} else {
				temp = temp.next;
			}
			p = p.next;
		}
		if (temp != null) {
			return temp.item;
		}
		return null;
	}

	public static void main(String[] args) {
		NthElementFromLast<Integer> ne = new NthElementFromLast<>();
		ne.insert(2);
		ne.insert(4);
		ne.insert(6);
		ne.insert(3);
		ne.insert(9);
		ne.insert(8);

		System.out.println("\n------------------Hash Table-------------------\n");
		System.out.println("3rd element using hash table from last is: " + ne.nthEleUsingHashTable(3));
		System.out.println("6th element using hash table from last is: " + ne.nthEleUsingHashTable(6));

		System.out.println("\n------------------Element Scan-----------------\n");
		System.out.println("3rd element using brute force from last is: " + ne.nthElement(3));
		System.out.println("6th element using brute force from last is: " + ne.nthElement(6));

		System.out.println("\n------------------Element Scan-----------------\n");
		System.out.println("3rd element using two pointers from last is: " + ne.nthEleTwoPointer(3));
		System.out.println("6th element using two pointers from last is: " + ne.nthEleTwoPointer(6));
	}
}
