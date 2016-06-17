package chapter6.problems;

import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/16/2016.
 */
public class NumOfLeafNode {

	public int numOfLeafNode(Node<Integer> root) {
		Node<Integer> temp = null;
		int count = 0;
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left == null && temp.right == null) {
				count++;
			}
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		NumOfLeafNode leafNode = new NumOfLeafNode();
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		SampleBinaryTree tree1 = SampleBinaryTree.getDefaultTree();
		System.out.println("leaf node in default tree: " + leafNode.numOfLeafNode(tree1.getRoot()));
		System.out.println("leaf node in custom tree: " + leafNode.numOfLeafNode(tree.getRoot()));
	}
}
