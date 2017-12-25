package chapter6.problems.generictree;

import static chapter6.problems.generictree.NArrayTree.Node;

/**
 * Created by mishrk3 on 8/16/2016.
 */

/**
 * Question: A full K-ary tree is a tree where each node has either 0 or k child. Construct a tree with given preorder
 * traversal.
 *
 * This is not the valid solution.
 */
@Deprecated
public class FullGenericTreeWithPreOrder {

	//static int index = 0;
	public Node<Character> getTreeFromPreOrder(Character[] characters, int n, int k, int index) {
		if (n <= 0) {
			return null;
		}
		Node<Character>[] children = new Node[k];

		Node<Character> newNode = new Node<>(characters[index], children);
		for (int i = 0; i < k; i++) {
			if (k * index + i < n) {
				index++;
				newNode.children[i] = getTreeFromPreOrder(characters, n, k, index);
			} else {
				newNode.children[i] = null;
			}
		}
		return newNode;
	}

	public static void main(String[] args) {
		FullGenericTreeWithPreOrder gt = new FullGenericTreeWithPreOrder();
		Character[] preOrder = {
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'j', 'K'
		};
		Node<Character> root = gt.getTreeFromPreOrder(preOrder, 10, 3, 0);
		System.out.println("Done!!!!!!!!");
	}
}
