package chapter6.problems.avl;

import static java.lang.Math.max;

/**
 * Created by mishrk3 on 10/12/2016.
 */
public class AVLTree<E> {

	private Node<E> root;

	public static class Node<E> {
		public E data;
		public Node<E> left;
		public Node<E> right;
		public int height;

		public Node(E data, Node<E> left, Node<E> right, int height) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.height = height;
		}
	}

	public Node<E> getRoot() {
		return root;
	}

	public static int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public static Node singleRotateLeft(Node root) {
		Node temp = root.left;
		root.left = temp.right;
		temp.right = root;
		root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
		temp.height = max(getHeight(temp.left), getHeight(temp.right)) + 1;
		return temp;
	}

	public static Node doubleRotateLeft(Node root) {
		root.left = singleRotateRight(root.left);
		return singleRotateLeft(root);
	}

	public static Node singleRotateRight(Node root) {
		Node temp = root.right;
		root.right = temp.left;
		temp.left = root;
		root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
		temp.height = max(getHeight(temp.left), getHeight(temp.right)) + 1;
		return temp;
	}

	public static Node doubleRotateRight(Node root) {
		root.right = singleRotateLeft(root.right);
		return singleRotateRight(root);
	}
}
