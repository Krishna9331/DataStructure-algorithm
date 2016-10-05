package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 10/5/2016.
 */
public class ElementInRange {

	public void printElementsInRange(Node<Integer> root, int k1, int k2) {

		if (null == root) {
			return;
		}
		if (root.item >= k1) {
			printElementsInRange(root.left, k1, k2);
		}
		if (root.item >= k1 && root.item <= k2) {
			System.out.print(" --> " + root.item);
		}
		if (root.item <= k2) {
			printElementsInRange(root.right, k1, k2);
		}
	}

	public static void main(String[] args) {
		ElementInRange er = new ElementInRange();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();
		er.printElementsInRange(tree.getRoot(), 5, 30);
	}
}
