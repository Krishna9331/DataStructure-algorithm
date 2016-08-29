package chapter6.problems.treadedBinaryTree;

import static chapter6.problems.treadedBinaryTree.ThreadedBinaryTree.Node;

/**
 * Created by mishrk3 on 8/26/2016.
 */

/**
 * Question: find preorder successor from inorder threaded binary tree
 */
public class PreOrderSuccessorFromInorderTree {

	private static PreOrderSuccessorFromInorderTree posfit = new PreOrderSuccessorFromInorderTree();

	/**
	 * The logic for below method is if tree has left child then it is preOrder Successor. so if a node has left child
	 * that means lTag will be true, which is the first if check and return.<br/>
	 * Otherwise we have to traverse up until we find the node having right child, e.g for below tree <pre>
	 *                                  1
	 *                                 / \
	 *                                2   3
	 *                               /   / \
	 *                              5   9  7
	 * </pre> the preorder successor of 2 is 5, however for 5 it is 3, cause in preOrder we traverse from root to
	 * leftmost element and then we comabove the path and go for right child. So here after traversal of 5 we will come
	 * up to parent (2) which don not have right subtree hence we will go parent of parent(1) and at last 1 has right
	 * child so will traverse the right subtree. first elemet wil be the root(3) of right subtree(PreOrder) which will
	 * be the preorder successor of 5.
	 *
	 * @param node
	 *            for which we have to get the preorder successor
	 * @param <E>
	 *            type of data for tree
	 * @return preorder successor
	 */
	public <E> Node<E> preOrderSuccessor(Node<E> node) {
		Node<E> successor = null;
		if (node.lTag) {
			return node.left;
		} else {
			successor = node;
			while (!successor.rTag) {
				successor = successor.right;
			}
			return successor.right;
		}
	}

	public static PreOrderSuccessorFromInorderTree getPreOrderSuccessorFromInorderTree() {
		return posfit;
	}
}
