package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 10/19/2016.
 */

/**
 * Given a BST and two integers(minimum and maximum) as parameters, remove all the elements of BST which is not in range
 */
public class PruneNodeOutOfRange {

	public Node<Integer> pruneBST(Node<Integer> root, int min, int max) {
		if (root == null) {
			return root;
		}
		root.left = pruneBST(root.left, min, max);
		root.right = pruneBST(root.right, min, max);
		if (min <= root.item && root.item <= max) {
			return root;
		}
		// if root is less then min then it is sure that all element in left subtree will be less and pruned. So check
		// required is only for right subtree.
		if (root.item < min) {
			return root.right;
		}
		// if root is greater then max then it is sure that all element in right subtree will be greater and pruned. So
		// check required is only for left subtree.
		if (root.item > max) {
			return root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		SampleBinaryTree<Integer> tree = SampleBinaryTree.createBinaryTreeWithHalfRootNode();
		PruneNodeOutOfRange pruner = new PruneNodeOutOfRange();
		Node<Integer> newRoot = pruner.pruneBST(tree.getRoot(), 18, 34);
		System.out.println("Tree is pruned new node is: " + newRoot.item);
	}
}
