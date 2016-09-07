package chapter6.problems.bst;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import chapter6.problems.binarytree.SampleBinaryTree;

/**
 * Created by mishrk3 on 9/7/2016.
 */

/**
 * Given pointers to two nodes find the lowest common ancestor in BST. Assume that both node is present in tree.
 */
public class LCAInBST {

	/**
	 * Time Complexity: O(n)<br/>
	 * Space Complexity: O(n) for skew tree<br/>
	 * The logic for below method is if first node is left of the root and second node is right of the root or any one
	 * of them is equal to root then answer is root. other wise just check any node and go to left if it is smaller than
	 * root or right if not, and recursively apply the logic to find LCA.
	 * 
	 * @param root
	 *            the root of the BST
	 * @param firstNode
	 *            the first node for which LCA to be found
	 * @param secondNode
	 *            the second node for whicg LCA has to be found
	 * @return the LCA node
	 */
	public Node<Integer> findLCA(Node<Integer> root, Node<Integer> firstNode, Node<Integer> secondNode) {
		while (true) {
			if ((firstNode.item <= root.item && secondNode.item >= root.item)
					|| (firstNode.item >= root.item && secondNode.item <= root.item)) {
				return root;
			} else if (firstNode.item < root.item) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
	}

	public static void main(String[] args) {
		LCAInBST lcaInBST = new LCAInBST();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();
		Node<Integer> first = new Node<>(5, null, null);
		Node<Integer> second = new Node<>(7, null, null);
		Node<Integer> sec = new Node<>(15, null, null);
		Node<Integer> second1 = new Node<>(40, null, null);
		Node<Integer> lca1 = lcaInBST.findLCA(tree.getRoot(), first, second);
		System.out.println("The LCA of node: " + first.item + "and second node: " + second.item
				+ " should be 5 and actual value is: " + lca1.item);
		Node<Integer> lca2 = lcaInBST.findLCA(tree.getRoot(), first, sec);
		System.out.println("The LCA of node: " + first.item + "and second node: " + sec.item
				+ " should be 10 and actual value is: " + lca2.item);
		Node<Integer> lca3 = lcaInBST.findLCA(tree.getRoot(), first, second1);
		System.out.println("The LCA of node: " + first.item + "and second node: " + second1.item
				+ " should be 20 and actual value is: " + lca3.item);
	}
}
