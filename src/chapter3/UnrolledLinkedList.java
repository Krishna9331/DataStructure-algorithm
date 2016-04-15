package chapter3;

/**
 * Created by mishrk3 on 4/13/2016.
 */
public class UnrolledLinkedList<T, E> {
	public static int MAX_NUM_NODES = 4;
	Block<Node<E>> head;

	private static class Block<T> {
		T item;
		Block<T> next;

		public Block(T item, Block<T> next) {
			this.item = item;
			this.next = next;
		}
	}

	private static class Node<E> {
		E item;
		Node<E> prev;
		int size;

		public Node(E item, Node<E> prev, int size) {
			this.item = item;
			this.prev = prev;
			this.size = size;
		}
	}

	/*public void add(int block, E data) {
		if (null == head && block > 0) {
			System.out.println("List is empty");
			return;
		}
		if (0 != block && block > getLength()) {
			System.out.println("given position is greater then length of list");
			return;
		}
		if (block == 0) {

		}

		int k = 0;
		Block<Node<E>> p, q, newNode = null;
		Node<E> node = new Node<E>(data, null, 1);
		newNode = new Block<Node<E>>(node, null);
		p = head;
		q = null;
		if (position == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			while (null != p && k < position) {
				k++;
				q = p;
				p = p.next;
			}
			q.next = newNode;
			newNode.next = p;
		}
	}*/

	public int getLength() {
		Block<Node<E>> p = head;
		int count = 0;
		while (null != p) {
			count++;
			p = p.next;
		}
		return count;
	}

}
