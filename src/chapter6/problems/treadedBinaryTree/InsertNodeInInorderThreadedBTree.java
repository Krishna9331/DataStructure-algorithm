package chapter6.problems.treadedBinaryTree;

import static chapter6.problems.treadedBinaryTree.ThreadedBinaryTree.Node;

/**
 * Created by mishrk3 on 8/26/2016.
 */

/**
 * Question: Insert a node in threaded binary tree.
 */
public class InsertNodeInInorderThreadedBTree {

	/**
	 * The logic of the code is to insert the data on right of the given node. We can similarly do if we insert in left
	 * of that.
	 * 
	 * @param node
	 *            node of the tree right of which data need to be inserted
	 * @param data
	 *            to be inserted
	 * @param <E>
	 *            the data type of the node of tree <br/>
	 *            <pre>
	 *
	 *                 A
	 *               /  \
	 *              B    C
	 *                    \
	 *                     D
	 *                    /
	 *                   R
	 *                  /
	 *                 T
	 *                /
	 *               S
	 *
	 *            </pre> <br/>
	 *            Case1: suppose we have to add the node to the right of D(no right child) in that case we just add the
	 *            node and update the left and right pointers.<br/>
	 *            <pre>
	 *                 A
	 *               /  \
	 *              B    C
	 *                    \
	 *                     D
	 *                    / \
	 *                   R  M
	 *                  /
	 *                 T
	 *                /
	 *               S
	 *               </pre><br/>
	 *            Case2: We have to add node as right chile of C. In this case C already has right child as D, Hence it
	 *            will go to leftmost child of D and update the reference to the newly added node.
	 *
	 *                        <pre>
	 *                 A
	 *               /  \
	 *              B    C
	 *                    \
	 *                     M
	 *                     \
	 *                      D
	 *                    /
	 *                   R
	 *                  /
	 *                 T
	 *                /
	 *               S
	 *               </pre><br/>
	 */

	public <E> void insert(Node<E> node, E data) {

		Node<E> insertNode = new Node<E>(data, false, false, null, null);
		Node<E> temp = null;

		insertNode.right = node.right;
		insertNode.rTag = node.rTag;
		insertNode.left = node;
		insertNode.lTag = false;
		node.rTag = true;
		node.right = insertNode;
		if (insertNode.rTag) {
			temp = insertNode.right;
			while ((temp.lTag)) {
				temp = temp.left;
			}
			temp.left = insertNode;
		}
	}
}
