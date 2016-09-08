package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 5/24/2016.
 */
public class SampleBinaryTree<E> {

	private Node<E> root;

	public static class Node<E> {
		public E item;
		public Node<E> left;
		public Node<E> right;

		public Node(E item, Node<E> left, Node<E> right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			Node<?> node = (Node<?>) o;

			if (!item.equals(node.item))
				return false;
			if (!left.equals(node.left))
				return false;
			return right.equals(node.right);

		}

		@Override
		public int hashCode() {
			int result = 0;
			if (null != item) {
				result = item.hashCode();
			}
			if (left != null) {
				result = 31 * result + left.hashCode();
			}
			if (right != null) {
				result = 31 * result + right.hashCode();
			}
			return result;
		}
	}

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public static SampleBinaryTree<Integer> getDefaultTree() {
		SampleBinaryTree<Integer> tree = new SampleBinaryTree<>();
		tree.root = new Node<>(1, null, null);
		tree.root.left = new Node<>(2, null, null);
		tree.root.left.left = new Node<>(4, null, null);
		tree.root.left.right = new Node<>(11, null, null);
		tree.root.right = new Node<>(3, null, null);
		tree.root.right.left = new Node<>(6, null, null);
		tree.root.right.right = new Node<>(7, null, null);
		return tree;
	}

	public static SampleBinaryTree<Integer> getCustomTree() {
		SampleBinaryTree<Integer> tree = new SampleBinaryTree<>();
		tree.root = new Node<>(1, null, null);
		tree.root.left = new Node<>(2, null, null);
		tree.root.left.left = new Node<>(4, null, null);
		tree.root.left.right = new Node<>(11, null, null);
		tree.root.left.right.left = new Node<>(21, null, null);
		tree.root.right = new Node<>(3, null, null);
		tree.root.right.left = new Node<>(6, null, null);
		tree.root.right.right = new Node<>(7, null, null);
		return tree;
	}

	public static SampleBinaryTree<Integer> getDefaultBST() {
		SampleBinaryTree<Integer> tree = new SampleBinaryTree<>();
		tree.root = new Node<>(20, null, null);
		tree.root.left = new Node<>(10, null, null);
		tree.root.right = new Node<>(30, null, null);

		tree.root.left.left = new Node<>(5, null, null);
		tree.root.left.left.left = new Node<>(2, null, null);
		tree.root.left.left.right = new Node<>(7, null, null);
		tree.root.left.right = new Node<>(15, null, null);
		tree.root.left.right.left = new Node<>(12, null, null);
		tree.root.left.right.right = new Node<>(18, null, null);

		tree.root.right = new Node<>(30, null, null);
		tree.root.right.left = new Node<>(25, null, null);
		tree.root.right.right = new Node<>(40, null, null);
		tree.root.right.right.left = new Node<>(35, null, null);
		tree.root.right.right.right = new Node<>(45, null, null);
		tree.root.right.left.left = new Node<>(22, null, null);
		tree.root.right.left.right = new Node<>(27, null, null);

		return tree;
	}

	public static SampleBinaryTree<Integer> getSmallBST() {
		SampleBinaryTree<Integer> tree = new SampleBinaryTree<>();
		tree.root = new Node<>(20, null, null);
		tree.root.left = new Node<>(10, null, null);
		tree.root.right = new Node<>(30, null, null);

		tree.root.left.left = new Node<>(5, null, null);
		tree.root.left.right = new Node<>(15, null, null);

		tree.root.right.left = new Node<>(25, null, null);
		tree.root.right.right = new Node<>(40, null, null);

		return tree;
	}
}
