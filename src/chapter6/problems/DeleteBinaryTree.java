package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/13/2016.
 */
public class DeleteBinaryTree {
	/**
	 * @param root root of the tree
	 *             in java deleting the node just require nullifying the reference rest will be taken care by garbage
	 *             collector. The post order traversal is the best candidate for doing so as it first go through the
	 *             child before coming to root. Hence we start traversing the element and nullify in place of printing.
	 */
	public void deleteBinaryTree(Node<Integer> root) {
		if (null == root) {
			return;
		}
		deleteBinaryTree(root.left);
		deleteBinaryTree(root.right);
		root = null;
	}
}
