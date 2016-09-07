package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 9/6/2016.
 */
public class DeleteFromBST {

	/**
	 * Time Complexity: O(n)<br/>
	 * Space Complexity: O(n) for recursive approach <br/>
	 * The deletion can be considered as three scenarios<br/>
	 * 1) Delete leaf node: This is the easiest one for deletion, where we can return null to the parent, which means
	 * basically making child pointer of parent as null.<br/>
	 * 2)If node has just one child: just report the immediate child of to be deleted node to parent of the node.<br/>
	 * 3)Node has both the child: In this scenario replace the to be deleted node with the largest element in the left
	 * subtree of node and then recursively deleted the node which has replace the to be deleted node. <br/>
	 * <br/>
	 * So we have to first find the element and then delete it using above three conditions.
	 * 
	 * @param root
	 *            the root of the tree
	 * @param element
	 *            to be deleted
	 * @return root of the tree after deleting element
	 */
	public Node<Integer> deleteNode(Node<Integer> root, Integer element) {
		Node<Integer> temp = null;
		if (root == null) {
			System.out.println("Element: " + element + "not present in tree.");
			return root;
		} else if (element < root.item) {
			root.left = deleteNode(root.left, element);
		} else if (element > root.item) {
			root.right = deleteNode(root.right, element);
		} else {
			// element found
			if (null != root.left && null != root.right) {
				temp = findMax(root.left);
				root.item = temp.item;
				root.left = deleteNode(root.left, temp.item);
			} else {
				// One child node
				temp = root;
				if (null == root.left) {
					root = root.right;
				} else if (null == root.right) {
					root = root.left;
				}
			}
		}
		return root;
	}

	private Node<Integer> findMax(Node<Integer> left) {
		FindOperationInBST fInBST = new FindOperationInBST();
		return fInBST.findMaxElementNonRecursive(left);
	}

	public static void main(String[] args) {
		DeleteFromBST dfBST = new DeleteFromBST();
		SampleBinaryTree tree = SampleBinaryTree.getDefaultBST();
		Node<Integer> root = dfBST.deleteNode(tree.getRoot(), 15);
		System.out.println("Deleted the node from tree.");
	}

}
