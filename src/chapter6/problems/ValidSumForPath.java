package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/17/2016.
 */
public class ValidSumForPath {

	public boolean isValidSum(Node<Integer> root, int sum) {
		if (root == null) {
			return sum == 0;
		} else {
			int remainingSum = sum - root.item;
			if ((root.left != null && root.right != null) || (root.left == null && root.right == null)) {
				return isValidSum(root.left, remainingSum) || isValidSum(root.right, remainingSum);
			} else if (root.left != null) {
				return isValidSum(root.left, remainingSum);
			} else {
				return isValidSum(root.right, remainingSum);
			}
		}
	}

	public static void main(String[] args) {
		ValidSumForPath vsfp = new ValidSumForPath();
		SampleBinaryTree tree1 = SampleBinaryTree.getCustomTree();
		SampleBinaryTree tree = SampleBinaryTree.getDefaultTree();
		System.out.println("7 is valid Sum: " + vsfp.isValidSum(tree.getRoot(), 7));
		System.out.println("14 is valid Sum: " + vsfp.isValidSum(tree.getRoot(), 14));
		System.out.println("10 is valid Sum: " + vsfp.isValidSum(tree.getRoot(), 10));
		System.out.println("11 is valid Sum: " + vsfp.isValidSum(tree.getRoot(), 11));
		System.out.println("9 is valid Sum: " + vsfp.isValidSum(tree.getRoot(), 9));
		System.out.println("validation for custom tree: --->");
		System.out.println("7 is valid Sum: " + vsfp.isValidSum(tree1.getRoot(), 7));
		System.out.println("35 is valid Sum: " + vsfp.isValidSum(tree1.getRoot(), 35));
		System.out.println("10 is valid Sum: " + vsfp.isValidSum(tree1.getRoot(), 10));
		System.out.println("11 is valid Sum: " + vsfp.isValidSum(tree1.getRoot(), 11));
		System.out.println("9 is valid Sum: " + vsfp.isValidSum(tree1.getRoot(), 2));
	}
}
