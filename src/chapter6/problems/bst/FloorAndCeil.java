package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 10/5/2016.
 */
public class FloorAndCeil {

	private static Node<Integer> previous = null;

	/**
	 * @param root
	 *            root of BST
	 * @param key
	 *            the element for which floor need to be found
	 * @return the floor node
	 */
	public Node<Integer> floorInBST(Node<Integer> root, int key) {
		previous = null;
		return floorBSTUtil(root, key);
	}

	public Node<Integer> ceilInBST(Node<Integer> root, int key) {
		previous = null;
		return ceilBSTUtil(root, key);
	}

	/**
	 * The idea behind method is perform inOrder traversal and keep track of element already visited. If root data is
	 * greater than the given value then return the maintained previous value. If root is equal to the given element
	 * then return root. * <pre>
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
	 * 	</pre> <br/>
	 * <br/>
	 * The method execution is similar as finding the nth smallest element. As it is inOrder traversal so first call
	 * will go to leftmost element of the tree and try to compare it with key. For above tree to find floor value of 31
	 * below will be the control flow.<br/>
	 * First point to break recursion will be left of 2 and since left of 2 is null so it will return empty node to the
	 * caller which is 5.<br/>
	 * Now left of 5 will be empty node which is not null so it will go ahead and compare root value with key and then
	 * check if root is larger than key. The 5 is smaller than 31 hence it will mark previous as 5 and call it's right
	 * node for the check which is 7.<br/>
	 * For the 7, again it will check it's left node which will return null hence this call will return empty node again
	 * to the caller which is parent of 5, means 10.<br/>
	 * As call went to right of node 5, similarly it will do for 10 and traverse above the tree.<br/>
	 * Once it reached 20(root of BST) call will go to right of 20 and again it will continue, but once it reached 40
	 * then it finds that 40 is grater than 31 and it will return previous which is 30 to the caller.<br/>
	 * <br/>
	 * Also be noted that once an element is matched and got the value all the subsequent caller will return the same
	 * element. If it has matched in left side of root then root.item > key will be always true for all ancestor and
	 * hence it will return the current previous without re-initializing it.<br/>
	 * <br/>
	 */
	private Node<Integer> floorBSTUtil(Node<Integer> root, int key) {
		if (null == root) {
			return root;
		}
		Node<Integer> left = floorBSTUtil(root.left, key);
		if (null != left) {
			return left;
		}
		if (root.item == key) {
			return root;
		}
		if (root.item > key) {
			return previous;
		}
		previous = root;
		return floorBSTUtil(root.right, key);
	}

	/**
	 * This method is similar to floor util, only difference is it first looked at the right child and then left. Also
	 * it compare if root is smaller then key and if yes then it return the previously traversed element.
	 */
	private Node<Integer> ceilBSTUtil(Node<Integer> root, int key) {
		if (null == root) {
			return root;
		}
		Node<Integer> right = ceilBSTUtil(root.right, key);
		if (null != right) {
			return right;
		}
		if (root.item == key) {
			return root;
		}
		if (root.item < key) {
			return previous;
		}
		previous = root;
		return ceilBSTUtil(root.left, key);
	}

	public static void main(String[] args) {
		FloorAndCeil fc = new FloorAndCeil();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();
		int element = 3;
		int element1 = 11;
		int element2 = 31;
		int element3 = 37;
		int element4 = 1;
		int element5 = 50;
		Node<Integer> resultNode = fc.floorInBST(tree.getRoot(), element);
		Node<Integer> resultNode1 = fc.floorInBST(tree.getRoot(), element1);
		Node<Integer> resultNode2 = fc.floorInBST(tree.getRoot(), element2);
		Node<Integer> resultNode3 = fc.floorInBST(tree.getRoot(), element3);
		Node<Integer> resultNode4 = fc.floorInBST(tree.getRoot(), element4);
		Node<Integer> resultNode5 = fc.floorInBST(tree.getRoot(), element5);

		Node<Integer> result = fc.ceilInBST(tree.getRoot(), element);
		Node<Integer> result1 = fc.ceilInBST(tree.getRoot(), element1);
		Node<Integer> result2 = fc.ceilInBST(tree.getRoot(), element2);
		Node<Integer> result3 = fc.ceilInBST(tree.getRoot(), element3);
		Node<Integer> result4 = fc.ceilInBST(tree.getRoot(), element4);
		Node<Integer> result5 = fc.ceilInBST(tree.getRoot(), element5);

		printResult(resultNode, element, "floor");
		printResult(resultNode1, element1, "floor");
		printResult(resultNode2, element2, "floor");
		printResult(resultNode3, element3, "floor");
		printResult(resultNode4, element4, "floor");
		printResult(resultNode5, element5, "floor");

		printResult(result, element, "ceil");
		printResult(result1, element1, "ceil");
		printResult(result2, element2, "ceil");
		printResult(result3, element3, "ceil");
		printResult(result4, element4, "ceil");
		printResult(result5, element5, "ceil");
	}

	private static void printResult(Node<Integer> resultNode, int element, String operation) {
		if (null == resultNode) {
			System.out.println("The " + operation + " value of element: " + element + " in BST does not exist");
		} else {
			System.out.println("The " + operation + " value of element: " + element + " in BST is: " + resultNode.item);
		}
	}
}
