package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 8/31/2016.
 */
public class FindOperationInBST {

	/**
	 * As per BST property the left of the root is always smaller that root and right will be always greater than root.
	 * The above property applies to chile of the root as well. The below recursion taken O(n) time complexity in work
	 * case(Skew tree), Also the space complexity of O(n) cause of recursion.
	 *
	 * @param root
	 *            the root node of tree
	 * @param item
	 *            the item to be searched
	 * @return the node containing the item.
	 */
	public Node<Integer> findElement(Node<Integer> root, Integer item) {
		if (root == null) {
			return root;
		}
		if (item < root.item) {
			return findElement(root.left, item);
		} else if (item > root.item) {
			return findElement(root.right, item);
		}
		return root;
	}

	/**
	 * The non recursive approach has advantage over the prior as it has space complexity O(1), However, time complexity
	 * will still be O(n) in case of skew tree.
	 *
	 * @param root
	 *            the root node of tree
	 * @param element
	 *            the item to be searched
	 * @return the node containing the element.
	 */
	public Node<Integer> findElementNonRecursive(Node<Integer> root, Integer element) {
		while (root != null) {
			if (element == root.item) {
				return root;
			} else if (element < root.item) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return null;
	}

	/**
	 * Time complexity = O(n) for left skew tree<br/>
	 * Space complexity= O(n)
	 *
	 * @param root
	 *            the root node of tree
	 * @return the node min element of course the leftmost node.
	 */
	public Node<Integer> findMinElement(Node<Integer> root) {
		if (root == null || root.left == null) {
			return root;
		}
		return findMinElement(root.left);
	}

	/**
	 * Time complexity = O(n) for left skew tree<br/>
	 * Space complexity= O(1)
	 *
	 * @param root
	 *            the root node of tree
	 * @return the node containing min element, of course the leftmost node.
	 */
	public Node<Integer> findMinElementNonRecursive(Node<Integer> root) {
		if (root == null || root.left == null) {
			return root;
		} else {
			while (root.left != null) {
				root = root.left;
			}
		}
		return root;
	}

	/**
	 * Time complexity = O(n) for right skew tree<br/>
	 * Space complexity= O(n)
	 *
	 * @param root
	 *            the root node of tree
	 * @return the node max element of course the rightmost node.
	 */
	public Node<Integer> findMaxElement(Node<Integer> root) {
		if (root == null || root.right == null) {
			return root;
		}
		return findMaxElement(root.right);
	}

	/**
	 * Time complexity = O(n) for right skew tree<br/>
	 * Space complexity= O(1)
	 *
	 * @param root
	 *            the root node of tree
	 * @return the node containing max element, of course the rightmost node.
	 */
	public Node<Integer> findMaxElementNonRecursive(Node<Integer> root) {
		if (root == null || root.right == null) {
			return root;
		} else {
			while (root.right != null) {
				root = root.right;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		FindOperationInBST inBST = new FindOperationInBST();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();

		Node<Integer> element = inBST.findElement(tree.getRoot(), 40);
		Node<Integer> element1 = inBST.findElementNonRecursive(tree.getRoot(), 40);
		System.out.println("The search operation for 40 returned the node having(Recursive): " + element.item);
		System.out.println("The search operation for 40 returned the node having(Non Recursive): " + element1.item);

		Node<Integer> minEle = inBST.findMinElement(tree.getRoot());
		Node<Integer> minEle1 = inBST.findMinElementNonRecursive(tree.getRoot());

		System.out.println("The search operation for 40 returned the node having(Recursive): " + minEle.item);
		System.out.println("The search operation for 40 returned the node having(Non Recursive): " + minEle1.item);

		Node<Integer> maxEle = inBST.findMaxElement(tree.getRoot());
		Node<Integer> maxEle1 = inBST.findMaxElementNonRecursive(tree.getRoot());

		System.out.println("The search operation for 40 returned the node having(Recursive): " + maxEle.item);
		System.out.println("The search operation for 40 returned the node having(Non Recursive): " + maxEle1.item);

	}

}
