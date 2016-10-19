package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;
import static java.lang.StrictMath.max;

/**
 * Created by mishrk3 on 10/19/2016.
 */
public class MaxPathSumFinder {

	private static int maxVal = Integer.MIN_VALUE;

	public int maxPathSum(Node<Integer> root) {
		return maxPathSumRec(root);
	}

	private int maxPathSumRec(Node<Integer> root) {
		int maxValUp = 0;
		if (root == null) {
			return 0;
		}
		int leftSum = maxPathSumRec(root.left);
		int rightSum = maxPathSumRec(root.right);
		if (leftSum <= 0 && rightSum <= 0) {
			return root.item;
		}
		if (leftSum > 0 || rightSum > 0) {
			maxVal = max(maxVal, root.item + leftSum + rightSum);
			maxValUp = max(leftSum, rightSum) + root.item;
			// check if current path is has higher sum than current high
			maxVal = max(maxVal, maxValUp);
		}
		// return the subtree path whichever is big
		return maxValUp;
	}

	public static void main(String[] args) {
		SampleBinaryTree<Integer> tree = SampleBinaryTree.createBinaryTreeWithHalfRootNode();
		MaxPathSumFinder mFinder = new MaxPathSumFinder();
		int result = mFinder.maxPathSum(tree.getRoot());
		System.out.println("Max sum path is: " + result);
	}
}
