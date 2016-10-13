package chapter6.problems.avl;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;
import static java.lang.Math.abs;
import static java.lang.Math.max;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 10/13/2016.
 */

/**
 * Given a binary tree check whether it is an AVL or not? Retuen -1 id it is not AVL. During
 */
public class IsAVLTree {

	/**
	 * @param root
	 *            the root of the BST
	 * @return -1 if it is not AVL, otherwise height of the root<br/>
	 *         The logic for method is if at any point it returns null, that value will propagate till root.
	 */
	public int isAVL(Node<Integer> root) {
		int left, right;
		if (root == null) {
			return 0;
		}
		left = isAVL(root.left);
		if (left == -1) {
			return left;
		}
		right = isAVL(root.right);
		if (right == -1) {
			return right;
		}
		if (abs(left - right) > 1) {
			return -1;
		}
		return max(left, right) + 1;
	}

	public static void main(String[] args) {
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getCustomTree();
		IsAVLTree isAVLTree = new IsAVLTree();
		int result = isAVLTree.isAVL(tree.getRoot());
		printAVLResult(tree, result);

		SampleBinaryTree<Integer> tree1 = SampleBinaryTree.getNonAVLTree();
		int result1 = isAVLTree.isAVL(tree1.getRoot());
		printAVLResult(tree1, result1);
	}

	private static void printAVLResult(SampleBinaryTree<Integer> tree, int result) {
		if (result == -1) {
			System.out.println("Tree is not AVL tree having root as: " + tree.getRoot().item);
		} else {
			System.out
					.println("Tree is AVL tree  having root as: " + tree.getRoot().item + " and height as: " + result);
		}
	}
}
