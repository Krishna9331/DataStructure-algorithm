package chapter6.problems.avl;

import static chapter6.problems.avl.AVLTree.Node;

/**
 * Created by mishrk3 on 10/17/2016.
 */

/**
 * Given a height h, give an algorithm to generate an AVL tree with minimum number of nodes.
 */
public class AVLTreeWithMinNodes {

	private static int count = 0;

	/**
	 * @param h
	 *            height of the tree To get minimum number of nodes, fill one level with h-1 and other with h-2
	 */
	public Node<Integer> generateAVLTree(int h) {
		Node<Integer> temp;
		if (h <= 0) {
			return null;
		}
		temp = new Node<>(null, null, null, 0);
		temp.left = generateAVLTree(h - 1);
		temp.data = count++;
		temp.right = generateAVLTree(h - 2);
		temp.height = h;
		return temp;
	}

	public static void main(String[] args) {
		AVLTreeWithMinNodes avlTreeWithMinNodes = new AVLTreeWithMinNodes();
		Node<Integer> root = avlTreeWithMinNodes.generateAVLTree(5);
		System.out.println("The tree of height 5 generated with root: " + root.data);
	}
}
