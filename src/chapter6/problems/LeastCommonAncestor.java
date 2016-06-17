package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/17/2016.
 */
public class LeastCommonAncestor {

	public Node<Integer> findLeastCommonAncestor(Node<Integer> root, Integer firstEle, Integer secEle) {
		Node<Integer> left = null;
		Node<Integer> right = null;
		if (root == null) {
			return null;
		}
		if (root.item == firstEle || root.item == secEle) {
			return root;
		}
		left = findLeastCommonAncestor(root.left, firstEle, secEle);
		right = findLeastCommonAncestor(root.right, firstEle, secEle);
		if (left != null && right != null) {
			return root;
		} else {
			return left != null ? left : right;
		}

	}

	public static void main(String[] args) {
		LeastCommonAncestor ls = new LeastCommonAncestor();
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		System.out.println("The common ancestor for 4 and 21 is: "+ ls.findLeastCommonAncestor(tree.getRoot(),4, 21).item);
	}
}
