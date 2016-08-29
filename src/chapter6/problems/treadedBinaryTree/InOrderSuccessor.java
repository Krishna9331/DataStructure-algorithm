package chapter6.problems.treadedBinaryTree;

import static chapter6.problems.treadedBinaryTree.ThreadedBinaryTree.Node;

/**
 * Created by mishrk3 on 8/23/2016.
 */

/**
 * Question: Find inorder Successor of a given node in Inorder thread binary tree.
 */
public class InOrderSuccessor {

	private static InOrderSuccessor successor = new InOrderSuccessor();

	/**
	 * The logic behind the below method: if node does not has right subtree this means the rTag will be true and the
	 * right side null pointer will contain inorder successor. However, if it has right subtree then the inorder
	 * successor will be left most child of the first right element. Hence the code has while loop to go left until lTag
	 * becomes false.
	 * 
	 * @param node
	 *            for which successor need to be found
	 * @return successor node
	 */
	public <E> Node<E> inOrderSuccessor(Node<E> node) {
		Node<E> successorNode = null;
		if (node.rTag == false) {
			return node.right;
		} else {
			successorNode = node.right;
			while (node.lTag) {
				successorNode = successorNode.left;
			}
			return successorNode;
		}
	}

	public static InOrderSuccessor getInorderSuccessor() {
		return successor;
	}
}
