package chapter6.problems.treadedBinaryTree;

/**
 * Created by mishrk3 on 8/17/2016.
 */

/**
 * The concept of threaded binary tree came to reduce the space complexity of the traversal(inorder, preorder and
 * postorder), the normal traversal uses Stack and Queue which has huge space complexity. In threaded binary tree we
 * utilize the null pointers of the nodes. The majority pointer in binary tree is null e.g. for n nodes binary tree we
 * will have n+1 null pointers which is waisted simply. The common convention is to put predecessor and successor
 * information in null pointers. So for preorder traversal: The given node's null left pointer will contain preorder
 * predecessor and null right pointer will contain preorder successor. These special pointers are called Threads. Same
 * is true for inorder and PostOrder. On basis of what predecessor and succesor the tree store it has three types: <br/>
 * <br/>
 * <pre>
 *     1. PreOrder Threaded Binary Tree
 *     2. Inorder Threaded Binary Tree
 *     3. PostOrder Threaded Binary Tree
 * </pre>
 * 
 * @param <E>
 *            type of data used in Tree.
 */
public class ThreadedBinaryTree<E> {

	/**
	 * Here lTag and rTag play the trick for indication of the element pointed by a node is predecessor/successor or the
	 * actual child. If lTag is true this means it has left child otherwise it is pointing to predecessor. Similarly if
	 * rTag is true indicates node has right child else the node pointed by the right pointer is successor.
	 * 
	 * @param <E>
	 *            data type of tree
	 */
	public static class Node<E> {
		E Data;
		Boolean lTag;
		Boolean rTag;
		Node<E> left;
		Node<E> right;

		public Node(E data, Boolean lTag, Boolean rTag, Node<E> left, Node<E> right) {
			Data = data;
			this.lTag = lTag;
			this.rTag = rTag;
			this.left = left;
			this.right = right;
		}
	}
}
