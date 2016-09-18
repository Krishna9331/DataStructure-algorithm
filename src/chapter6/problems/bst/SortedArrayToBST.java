package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 9/18/2016.
 */

/**
 * Question: Given a sorted array write an algorithm to convert it into BST
 */
public class SortedArrayToBST {

	/**
	 * TimeComplexity: O(n)
	 * 
	 * @param array
	 *            the integer array
	 * @param start
	 *            start index of array
	 * @param end
	 *            last index of array
	 * @return the root element of created BST
	 */
	public Node<Integer> arrayToTree(int[] array, int start, int end) {
		int mid = 0;
		if (start > end) {
			return null;
		}
		Node<Integer> root = new Node<>(null, null, null);
		if (start == end) {
			root.item = array[start];
		} else {
			mid = start + (end - start) / 2;
			root.item = array[mid];
			root.left = arrayToTree(array, start, mid - 1);
			root.right = arrayToTree(array, mid + 1, end);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] array = {
				3, 4, 5, 6, 9, 11
		};
		SortedArrayToBST arrayToBST = new SortedArrayToBST();
		Node<Integer> root = arrayToBST.arrayToTree(array, 0, array.length - 1);
		System.out.println("Tree is created with root: " + root.item);
	}
}
