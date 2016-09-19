package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter3.SinglyLinkedList;

/**
 * Created by mishrk3 on 9/18/2016.
 */
public class SortedListToBST {

	/**
	 * The below method is opposite to the prior conversion from sorted array and DLL to BST. Those were top down
	 * approach where we had created first root and then traversed down.<br/>
	 * The Time Complexity for the prior two is O(nlogn)<br/>
	 * The solution proposed below is bottom up approach where we are traversing the list and creating it's node. It
	 * gives the Time Complexity of O(n)+O(n) =~ O(n)<br/>
	 * The code flow can be seen as below: for list 2->5->7->9->11->15<br/>
	 * <pre>
	 *	((2 to 15), 0, 5) will split at first line and make call ((2 to 15), 0, 1) -> ((2 to 15), 0, -1) will return null.
	 *	now (2 to 15), 0, 1) proceed and get left child as null and create a parent node with head of list (2)
	 *
	 * then move the head to 5 and now list is (5 to 15) and the seek for right child and call
	 * (5 to 15), 1, 1) -> which call for left child with (5 to 15), 1, 0) resulting to NULL,
	 * and hence call (5 to 15), 1, 1) will proceed and create a node of head which is 5 now (5) and then
	 * move the head further to 7 and list will be now (7 to 15). now (5 to 15), 1, 1) will make call for it's right
	 * child (7 to 15), 2, 1) which will return again null hence this call will create below node
	 * 				5
	 * 			   / \
	 *			null  null
	 *	Now if we remember 	the above paragraph is for right child of 2 hence we will achieve
	 *				2
	 *				 \
	 *				  5   --- say subtree1
	 *				 / \
	 *			  null  null
	 *
	 * Now the first call ((2 to 15), 0, 5) will continue which got is leftChild as subtree1.
	 * and then it will create parent with head of the list which is 7 now and then move the head to 9 which makes list as (9 to 15)
	 * now parent 7 will seek for it's right child by making call ((9->15), 3, 5) and if we track this call we will get below subtree
	 * as right child of 7
	 * 					11
	 * 				   /  \
	 * 				  9    15
	 *
	 * 	Hence the final tree will look like
	 *					7   <--------Root of the tree
	 *				 /    \
	 *				2       11
	 * 				 \     /  \
	 * 				  5   9    15
	 *
	 *
	 * </pre>
	 * 
	 * @param list
	 *            sorted list to be converted in BST
	 * @param start
	 *            the starting index of list
	 * @param end
	 *            the last element index of the list
	 * @return the root node of BST
	 */
	public Node<Integer> sListToTree(SinglyLinkedList<Integer> list, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		Node<Integer> leftChild = sListToTree(list, start, mid - 1);
		Node<Integer> parent = new Node<>(list.head.item, null, null);
		parent.left = leftChild;
		list.head = list.head.next;
		parent.right = sListToTree(list, mid + 1, end);
		return parent;
	}

	public static void main(String[] args) {

		SinglyLinkedList<Integer> list = SinglyLinkedList.getSortedList();
		SortedListToBST toBST = new SortedListToBST();
		Node<Integer> root = toBST.sListToTree(list, 0, list.getLength() - 1);
		System.out.println("Converted to tree with root: " + root.item);
	}
}
