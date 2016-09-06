package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 9/6/2016.
 */
public class InsertElementInBST {

	/**
	 * Time Complexity = O(n) Space Complexity = O(n)
	 * 
	 * @param root
	 *            the root node of tree
	 * @param element
	 *            the integer to be inserted
	 * @return the root of the tree after inserting the data
	 */
	public Node<Integer> insertInBST(Node<Integer> root, Integer element) {
		if (root == null) {
			root = new Node<>(element, null, null);
		} else {
			if (element < root.item) {
				root.left = insertInBST(root.left, element);
			} else if (element > root.item) {
				root.right = insertInBST(root.right, element);
			}
		}
		return root;
	}

	/**
	 * Time Complexity = O(n) Space Complexity = O(1)
	 *
	 * @param root
	 *            the root node of tree
	 * @param element
	 *            the integer to be inserted
	 * @return the root of the tree after inserting the data
	 */
	public Node<Integer> insertBSTIterative(Node<Integer> root, Integer element) {
		Node<Integer> temp = null;
		if (root == null) {
			root = new Node<>(element, null, null);
		} else {
			temp = root;
			while (root != null) {
				if (element > temp.item) {
					temp = temp.left;
				} else if (element < temp.item) {
					temp = temp.right;
				}
			}
			temp = new Node<>(element, null, null);
		}
		return root;
	}

	public static void main(String[] args) {
		InsertElementInBST ie = new InsertElementInBST();
		Node<Integer> root = ie.insertInBST(null, 30);
		ie.insertInBST(root, 40);
		ie.insertInBST(root, 10);
		ie.insertInBST(root, 15);
		ie.insertInBST(root, 20);
		ie.insertInBST(root, 35);
		ie.insertInBST(root, 7);
		System.out.println("Tree created via Recursive way.");
		Node<Integer> root1 = ie.insertInBST(null, 30);
		ie.insertInBST(root1, 40);
		ie.insertInBST(root1, 10);
		ie.insertInBST(root1, 15);
		ie.insertInBST(root1, 20);
		ie.insertInBST(root1, 35);
		ie.insertInBST(root1, 7);
		System.out.println("Tree created via Iterative way.");
	}
}
