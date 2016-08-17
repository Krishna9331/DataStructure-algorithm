package chapter6.problems.generictree;

/**
 * Created by mishrk3 on 8/17/2016.
 */
public class NArrayTree<E> {
	public Node<E> root;

	public static class Node<E> {
		E item;
		Node<E>[] children;

		public Node(E item, Node<E>[] children) {
			this.item = item;
			this.children = children;
		}
	}

	public Node<E> getRoot() {
		return root;
	}

}
