package chapter6.problems.avl;

import static chapter6.problems.avl.AVLTree.Node;

/**
 * Created by mishrk3 on 10/18/2016.
 */

/**
 * Given an BST(or AVL) where each node contains two data element(node data and number of element in it's subtrees).
 * Convert the tree into another BST by replacing the second data with previous node data of inOrder traversal. Als make
 * sure that conversion happens in-place.
 */
public class TreeCompression {

	private static Node<Integer> previous = null;

	public Node<Integer> compressTree(Node<Integer> root) {
		if (root == null) {
			return null;
		}
		compressTree(root.left);
		if (previous != null) {
			root.height = previous.data;
		}
		previous = root;
		return compressTree(root.right);
	}

	public static void main(String[] args) {
		TreeCompression compression = new TreeCompression();
		AVLTree tree = AVLTree.getCustomizedTree();
		compression.compressTree(tree.getRoot());
		System.out.println("tree is compressed, now root contains data2 as: " + tree.getRoot().height);
	}
}
