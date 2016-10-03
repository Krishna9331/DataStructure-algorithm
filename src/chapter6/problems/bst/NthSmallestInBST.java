package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 9/21/2016.
 */

/**
 * Give an algorithm to find the kth smallest element in BST.
 */
public class NthSmallestInBST {
	private static int count = 0;

	/**
	 * @param root
	 *            of the BST
	 * @param k
	 *            the kth smallest element to be found
	 * @return the kth smallest node <br/>
	 *         <br/>
	 *         The idea behind the solution is the inorder traversal of BST produces sorted list, so while traversing we
	 *         can keep track of the element visited. <br/>
	 *         The most interesting part in below code is whenever code got the nth element after that subsequent call
	 *         will return the same element as left of the element will never be null<br/>
	 *         <pre>
	 *
	 * 	    	      20
	 * 	    	    /    \
	 * 	    	   /      \
	 * 	         /         \
	 * 	       10            30
	 * 	      /  \         /    \
	 * 	    /     \       25     40
	 * 	   5       15    /  \    /  \
	 * 	  / \     /  \   22  27  35  45
	 * 	/    \   12   18
	 * 2	  7
	 *
	 * 	</pre> For the above tree to find the 5th smallest element the code will behave as below: As per logic
	 *         getNthElement the code will continue to move the left until root is not null so first time the recursion
	 *         will break as child of 2. Now left of two is null so count will increase to 1 and then it will go to
	 *         calculate the right of 2, which is again null and hence left of 5 will get null as it is nothing but
	 *         right of 2. <br/>
	 *         <br/>
	 *         Then since left of 5 is null so count will increase again to 2 and the go to calculate right of 5 which
	 *         again will flow as per recursion condition until root is not null, which will meet at left child of 7 and
	 *         same as 2 the 7 also will return null as left of 10 but count will be 3 now. <br/>
	 *         <br/>
	 *         The 10 will increase the count to 4 and then calculate it's right. So 15 will be called which will
	 *         traverse till left most null root, which is child of 12 and hence 12 will get left as null and count will
	 *         become 5=k and as per condition 12 will be returned. which is going to be left of 15 and hence it will
	 *         return 12 as right of 10<br/>
	 *         <br/>
	 *         Right of 10 is nothing but left of root 20 and finally 12 will be returned as output.
	 */
	public Node<Integer> getNthElement(Node<Integer> root, int k) {
		if (null == root) {
			return root;
		}
		Node<Integer> left = getNthElement(root.left, k);
		if (left != null) {
			return left;
		}
		count++;
		if (count == k) {
			return root;
		}
		return getNthElement(root.right, k);
	}

	public static void main(String[] args) {
		NthSmallestInBST smallestInBST = new NthSmallestInBST();
		SampleBinaryTree<Integer> bst = SampleBinaryTree.getDefaultBST();
		Node<Integer> resultNode = smallestInBST.getNthElement(bst.getRoot(), 5);
		System.out.println("The result element for k = " + 1 + "is: " + resultNode.item);
	}
}
