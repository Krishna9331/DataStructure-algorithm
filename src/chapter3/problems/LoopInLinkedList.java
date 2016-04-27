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
		Hashtable<Integer, Node<E>> hashTable = new Hashtable<>();
		Node<E> p = head;
		int len = 0;
		while (p != null) {
			len++;
			if (checkTable(hashTable, p)) {
				return true;
			} else {
				hashTable.put(len, p);
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

	private boolean isEqual(Node<E> p, Node<E> m) {
		return p != null && m != null && p.item == m.item && p.next == m.next;
	}

	private void createLoop() {
		Node<E> p = head;
		Node q = p.next.next;
		while (p.next != null) {
			p = p.next;
		}
		p.next = q;
	}

	/**
	 * explanation : http://learningarsenal.info/index.php/2015/08/24/detecting-start-of-a-loop-in-singly-linked-list/
	 */
	public E findFirstElementOfLoop() {
		boolean hasLoop = false;
		Node<E> slow = head, fast = head;
		while (null != slow && null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (isEqual(slow, fast)) {
				hasLoop = true;
				break;
			}
		}

		if (hasLoop) {
			slow = head;
			while (!isEqual(slow, fast)) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow.item;
	}

	public int lengthOfLoop() {
		boolean hasLoop = false;
		Node<E> slow = head, fast = head;
		while (null != slow && null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (isEqual(slow, fast)) {
				hasLoop = true;
				break;
			}
		}
		int len = 1;
		if (hasLoop) {
			fast = fast.next;
			while (!isEqual(slow, fast)) {
				fast = fast.next;
				len++;
			}
			return len;
		}
		return 0;

	}

	public boolean findLoopFloydCycle() {
		Node<E> slow = head, fast = head;
		while (null != slow && null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (isEqual(slow, fast)) {
				return true;
			}
		}
		return false;
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
		System.out.println("Link list has loop using Floyd Cycle: " + lil.findLoopFloydCycle());
		lil.createLoop();
		System.out.println("Link list has loop after createLoop call: " + lil.isLoopUsingHashTable());
		System.out.println("Link list has loop after createLoop call: " + lil.findLoopFloydCycle());
		System.out.println("The first element of the loop is: " + lil.findFirstElementOfLoop());
		System.out.println("The length of the loop is: " + lil.lengthOfLoop());
	}

}
