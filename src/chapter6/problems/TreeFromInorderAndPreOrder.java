package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/18/2016.
 */

/**
 * A tree can be created from any of the two traversal combination if one out the two traversal id INORDER.e.g.
 * INORDER vs POSTORDER
 * INORDER vs LEVELORDER
 * INORDER vs PREORDER
 */
public class TreeFromInorderAndPreOrder {
	static int preOrderIndex = 0;

	public Node<Integer> buildTree(int[] inOrder, int[] preOrder, int inOrderStart, int inOrderEnd) {

		Node<Integer> node = null;
		if (inOrderStart > inOrderEnd) {
			return node;
		}
		//create node from the current index of pre order
		node = new Node<>(preOrder[preOrderIndex], null, null);
		preOrderIndex++;
		if (inOrderStart == inOrderEnd) {
			return node;
		}
		//find the node in the inorder
		int inOrderIndex = search(inOrder, inOrderStart, inOrderEnd, node.item);
		//create left subtree using startIndex to found index -1 of inorder
		node.left = buildTree(inOrder, preOrder, inOrderStart, inOrderIndex - 1);
		//create right subtree using index+1 to lastIndex. we are skipping the inOrderIndex as that is the node
		// created from pre order.
		node.right = buildTree(inOrder, preOrder, inOrderIndex + 1, inOrderEnd);
		return node;
	}

	private int search(int[] inOrder, int inOrderStart, int inOrderEnd, Integer item) {
		for (int i = inOrderStart; i < inOrderEnd; i++) {
			if (inOrder[i] == item) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		TreeFromInorderAndPreOrder tfip = new TreeFromInorderAndPreOrder();
		int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
		int[] preOrder = { 1, 2, 4, 5, 3, 6, 7 };

		Node<Integer> root = tfip.buildTree(inOrder, preOrder, 0, 6);
		System.out.println("Tree created(please debug to see the tree).");

	}
}
