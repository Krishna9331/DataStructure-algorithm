package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 8/16/2016.
 */
/**
 * Two binary tree is called Isomorphic having root as root1 and root2 respectively, if root1 can be transformed into
 * root2 by swapping left and right child of some of the nodes of root1. The value of node does not affect the
 * QuasiIsomorphic behavior of tree, only structure matters.
 */
public class QuasiIsomorphic {

	public boolean isQuasiIsomorphic(Node<Integer> root1, Node<Integer> root2) {
		if (root1 == null || root2 == null) {
			return true;
		}
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		}
		return isQuasiIsomorphic(root1.left, root2.left) && isQuasiIsomorphic(root1.right, root2.right)
				|| isQuasiIsomorphic(root1.left, root2.right) && isQuasiIsomorphic(root1.right, root2.left);
	}
}
