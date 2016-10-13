package chapter6.problems.avl;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 10/13/2016.
 */

/**
 * Give an algorithm to generate HB(0) for a given height h.
 */
public class BuildHB0 {

	private static int count = 0;

	/**
	 * Time complexity: O(n)<br/>
	 * spaceComplexity: O(logn)
	 * 
	 * @param h
	 *            the height of the tree to be created
	 * @return the root of the generated tree The below method creates the tree in the inOrder pattern. It first goes to
	 *         h-1 level down and then traverse up till root.
	 */
	public Node<Integer> buildHB0(int h) {
		Node<Integer> temp;
		if (h == 0) {
			return null;
		}
		temp = new Node<>(null, null, null);
		temp.left = buildHB0(h - 1);
		temp.item = count++;
		temp.right = buildHB0(h - 1);
		return temp;
	}

	public static void main(String[] args) {
		BuildHB0 hb0 = new BuildHB0();
		Node<Integer> root = hb0.buildHB0(2);
		System.out.println("The root of the tree is: " + root.item);
	}
}
