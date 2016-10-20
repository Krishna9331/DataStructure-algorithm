package chapter6.problems.binarytree;

import chapter6.problems.binarytree.BinaryTreeWithLinkedNode.Node;

/**
 * Created by mishrk3 on 10/20/2016.
 */

/**
 * Given a binary tree write an algorithm to connect all the adjacent node at same level. Assume that each node has an
 * extra pointer called next.
 */
public class SameLevelNodeLinker {

	public void linkNodeOfSameLevel(Node<Integer> root) {
		if (root == null) {
			return;
		}
		Node<Integer> rightMostNode = null;
		Node<Integer> nextHead = null;
		Node<Integer> temp = root;
		while (temp != null) {
			if (temp.left != null) {
				if (rightMostNode == null) {
					rightMostNode = temp.left;
					nextHead = temp.left;
				} else {
					rightMostNode.next = temp.left;
					rightMostNode = rightMostNode.next;
				}
			}
			if (temp.right != null) {
				if (rightMostNode == null) {
					rightMostNode = temp.right;
					nextHead = temp.right;
				} else {
					rightMostNode.next = temp.right;
					rightMostNode = rightMostNode.next;
				}
			}
			temp = temp.next;
		}
		linkNodeOfSameLevel(nextHead);
	}

	public static void main(String[] args) {
		SameLevelNodeLinker linker = new SameLevelNodeLinker();
		BinaryTreeWithLinkedNode<Integer> tree = BinaryTreeWithLinkedNode.createTree();
		linker.linkNodeOfSameLevel(tree.getRoot());
		System.out.println("Linked tree created with root: " + tree.getRoot().data);
	}
}

class BinaryTreeWithLinkedNode<E> {
	Node<E> root;

	public static class Node<E> {
		E data;
		Node<E> left;
		Node<E> right;
		Node<E> next;

		public Node(E data, Node<E> left, Node<E> right, Node<E> next) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}

	public static BinaryTreeWithLinkedNode<Integer> createTree() {
		BinaryTreeWithLinkedNode<Integer> tree = new BinaryTreeWithLinkedNode<>();
		tree.root = new Node<>(20, null, null, null);
		tree.root.left = new Node<>(10, null, null, null);
		tree.root.right = new Node<>(30, null, null, null);

		tree.root.left.left = new Node<>(5, null, null, null);
		tree.root.left.left.left = new Node<>(2, null, null, null);
		tree.root.left.left.right = new Node<>(7, null, null, null);
		tree.root.left.right = new Node<>(15, null, null, null);
		tree.root.left.right.left = new Node<>(12, null, null, null);
		tree.root.left.right.right = new Node<>(18, null, null, null);

		tree.root.right = new Node<>(30, null, null, null);
		tree.root.right.left = new Node<>(25, null, null, null);
		tree.root.right.right = new Node<>(40, null, null, null);
		tree.root.right.right.left = new Node<>(35, null, null, null);
		tree.root.right.right.right = new Node<>(45, null, null, null);
		tree.root.right.left.left = new Node<>(22, null, null, null);
		tree.root.right.left.right = new Node<>(27, null, null, null);

		return tree;
	}

	public Node<E> getRoot() {
		return root;
	}
}
