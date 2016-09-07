package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter4.LinkedListStack;
import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 9/7/2016.
 */

/**
 * Give an algorithm to check if a given tree is BST or not.
 */
public class ValidBST {

	private static int min = Integer.MIN_VALUE;

	/**
	 * The logic for the below method is based on the property of BST. As we know the inOrder traversal of BST generates
	 * sorted order of the elements, hence we will do inorder traversal and will compare if cuurent node item is grater
	 * than the previous one.
	 * 
	 * @param root
	 *            of the tree
	 * @return true if tree is valid BST
	 */
	public boolean isValidBST(Node<Integer> root) {
		Node<Integer> temp = root;
		LinkedListStack<Node<Integer>> stack = new LinkedListStack<>();
		if (temp == null) {
			return true;
		}
		while (true) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			temp = stack.pop();
			if (temp.item < min) {
				return false;
			} else {
				min = temp.item;
			}
			temp = temp.right;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidBST validBST = new ValidBST();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();
		SampleBinaryTree<Integer> tree1 = SampleBinaryTree.getCustomTree();
		SampleBinaryTree<Integer> tree2 = SampleBinaryTree.getDefaultTree();
		System.out.println("The default BST returns: " + validBST.isValidBST(tree.getRoot()));
		System.out.println("The default binary tree returns: " + validBST.isValidBST(tree1.getRoot()));
		System.out.println("The custom binary tree returns: " + validBST.isValidBST(tree2.getRoot()));
	}
}
