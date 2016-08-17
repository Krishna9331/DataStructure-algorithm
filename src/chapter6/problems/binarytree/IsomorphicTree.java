package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 8/16/2016.
 */

/**
 * Two binary tree is called Isomorphic having root as root1 and root2 respectively, if they have same structure. The
 * value of node does not affect the isomorphic behavior of tree, only structure matters.
 */
public class IsomorphicTree {

	public boolean isIsomorphic(Node<Integer> root1, Node<Integer> root2) {
		if (root1 == null && root1 == null) {
			return true;
		}
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		}

		return isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right);
	}
}
