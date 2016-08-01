package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/20/2016.
 */
public class AllAncestorOfNode {

	public boolean printAllAncestor(Node<Integer> root, Node<Integer> element) {
		if (root == null) {
			return false;
		}
		if (root.left == element || root.right == element || printAllAncestor(root.left, element) || printAllAncestor(
				root.right, element)) {
			System.out.printf(" " + root.item);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		AllAncestorOfNode ans = new AllAncestorOfNode();
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		ans.printAllAncestor(tree.getRoot(), tree.getRoot().left.left);
	}
}
