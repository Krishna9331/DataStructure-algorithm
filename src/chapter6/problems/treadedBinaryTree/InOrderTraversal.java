package chapter6.problems.treadedBinaryTree;

import static chapter6.problems.treadedBinaryTree.ThreadedBinaryTree.Node;

/**
 * Created by mishrk3 on 8/26/2016.
 */

/**
 * In inorderThreaded Binary tree the leftmost null pointer and rightmost null pointer points to dummy node. The rTag of
 * dummy node is always true and right pointer will point to itself. This dummy node is present even if tree is empty.
 */
public class InOrderTraversal {
	InOrderSuccessor successor = InOrderSuccessor.getInorderSuccessor();

	/**
	 * The logic is to start with dummy node and call inOrderSuccessor() until we visit each node and reach the dummy
	 * node. the complexity is O(n) and space is O(1).
	 * 
	 * @param root
	 *            the root node of tree to be traversed.
	 */
	public <E> void inOrderTraverse(Node<E> root) {
		Node<E> p = successor.inOrderSuccessor(root);
		while (p != root) {
			p = successor.inOrderSuccessor(p);
			System.out.println(p.Data + "-->");
		}
	}
}
