package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 10/19/2016.
 */

/**
 * Given a binary tree, write an algorithm to remove all the half nodes(which has only one child). Leaf nodes must not
 * be touched.
 */
public class HalfNodesRemover {

	/**
	 * <pre>
	 *                40
	 * 	    	     /
	 * 	    	    /
	 * 	           /
	 * 	         20
	 * 	        / \
	 * 	      /    \
	 * 	    10      30
	 * 	    /      /  \
	 * 	   5      25  35
	 * 	  /           /
	 *   2          33
	 *             /
	 *            31
	 * </pre> The method follow post order traversal to remove the nodes as we can not directly remove the parent. In
	 * the above tree if first root 40 is removed then we will lose all the contact of children and if we just process
	 * root after any of the subtree other's reference will go.<br/>
	 * if a node has both child as null return that node to it's caller parent. So for above tree once we at root 2, the
	 * value returned will be 2 to and once we at root 5 the value returned to it's parent as right of 5 is null. So
	 * automatically 5 will be lost as parent of 5 will now point to left node of 5. Similar way for all other half node
	 * the nodes will be processed.
	 *
	 * @param root
	 *            the root of the tree
	 * @return the new root after removal of half nodes
	 */
	public Node<Integer> removeHalfNodes(Node<Integer> root) {
		if (root == null) {
			return root;
		}
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		if (root.left == null && root.right == null) {
			return root;
		}
		if (root.left == null) {
			return root.right;
		}
		if (root.right == null) {
			return root.left;
		}
		return root;
	}

	public static void main(String[] args) {
		HalfNodesRemover hNRemover = new HalfNodesRemover();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.createBinaryTreeWithHalfRootNode();
		Node<Integer> newRoot = hNRemover.removeHalfNodes(tree.getRoot());
		System.out.println("All half nodes removed new root is: " + newRoot.item);
	}

}
