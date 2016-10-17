package chapter6.problems.avl;

import static chapter6.problems.avl.AVLTree.Node;

/**
 * Created by mishrk3 on 10/17/2016.
 */

/**
 * Given an AVL tree with n integer items and two integer a and b, where a and b can be any integer with a <= b,
 * implement an algorithm to count number of nodes in range [a, b].
 */
public class NodesInRange {

	private static int count = 0;

	/**
	 * The logic for method is pretty simple, if root is greater than lower bound, go recursively left to check if left
	 * child is also greater than lower bound. The reason is left child of root is less than root and right will be
	 * greater, hence it is obvious that all right child will be greater than lower bound. So we go left to check which
	 * all left child can be included in range as possibility is there that some of left child may be smaller than lower
	 * bound.
	 *
	 * @param root
	 *            root of the avl tree
	 * @param a
	 *            the lower bound int
	 * @param b
	 *            the upper bound int
	 * @return number of nodes in range [a, b]
	 */
	public int countRange(Node<Integer> root, int a, int b) {

		if (root == null) {
			return 0;
		}
		if (root.data >= a) {
			countRange(root.left, a, b);
		}

		if (root.data >= a && root.data <= b) {
			count++;
		}

		if (root.data <= b) {
			countRange(root.right, a, b);
		}
		return count;
	}

	public int countRangeInAVL(Node<Integer> root, int a, int b) {

		if (root == null) {
			return 0;
		}
		if (root.data > b) {
			return countRangeInAVL(root.left, a, b);
		}
		if (root.data < a) {
			return countRangeInAVL(root.right, a, b);
		}
		if (root.data >= a && root.data <= b) {
			return countRangeInAVL(root.left, a, b) + countRangeInAVL(root.right, a, b) + 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		NodesInRange inRange = new NodesInRange();
		AVLTree<Integer> tree = AVLTree.getSampleAVLTree();
		int result = inRange.countRangeInAVL(tree.getRoot(), 3, 9);
		System.out.println("The count is: " + result);
		int result1 = inRange.countRangeInAVL(tree.getRoot(), 3, 9);
		System.out.println("The count is: " + result1);
	}

}
