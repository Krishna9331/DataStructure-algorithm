package chapter6.problems.treadedBinaryTree;

import static chapter6.problems.treadedBinaryTree.ThreadedBinaryTree.Node;

/**
 * Created by mishrk3 on 8/26/2016.
 */

/**
 * Question: find the preOrder Traversal in Inorder threaded Binary Tree.
 */
public class PreOrderTraversalFromInorderTree {

	private PreOrderSuccessorFromInorderTree tree = PreOrderSuccessorFromInorderTree
			.getPreOrderSuccessorFromInorderTree();

	/**
	 * The logic is similar as inorder traversal
	 * 
	 * @param root
	 *            root of the Inorder threaded Binary tree for which preOrderTravrsal is needed.
	 * @param <E>
	 *            data type of the node of the tree
	 */
	public <E> void preOrderTraversal(Node<E> root) {
		Node<E> node = tree.preOrderSuccessor(root);
		while (node != root) {
			node = tree.preOrderSuccessor(node);
			System.out.println(node.Data + "-->");
		}
	}
}
