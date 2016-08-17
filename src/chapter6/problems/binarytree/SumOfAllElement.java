package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/17/2016.
 */
public class SumOfAllElement {

	public int addAllElement(Node<Integer> root) {
		if (root == null) {
			return 0;
		} else {
			return (root.item + addAllElement(root.left) + addAllElement(root.right));
		}
	}

	public static void main(String[] args) {
		SumOfAllElement soae = new SumOfAllElement();
		SampleBinaryTree tree = SampleBinaryTree.getDefaultTree();
		SampleBinaryTree tree1 = SampleBinaryTree.getCustomTree();
		System.out.println("Sum of the elements of default tree: " + soae.addAllElement(tree.getRoot()));
		System.out.println("Sum of the elements of custom tree: " + soae.addAllElement(tree1.getRoot()));
	}
}
