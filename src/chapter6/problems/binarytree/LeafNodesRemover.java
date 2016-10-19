package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 10/19/2016.
 */
public class LeafNodesRemover {

	public Node<Integer> removeLeafNode(Node<Integer> root) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				return null;
			} else {
				root.left = removeLeafNode(root.left);
				root.right = removeLeafNode(root.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		SampleBinaryTree<Integer> tree = SampleBinaryTree.createBinaryTreeWithHalfRootNode();
		LeafNodesRemover lNRemover = new LeafNodesRemover();
		Node<Integer> newRoot = lNRemover.removeLeafNode(tree.getRoot());
		System.out.println("All leaf nodes have been removed, new root is: " + newRoot.item);
	}
}
