package chapter6.problems;

import chapter5.LinkedListQueue;

/**
 * Created by mishrk3 on 6/16/2016.
 */
public class NumOfFullNode {

	public int numOfFullNode(SampleBinaryTree.Node<Integer> root) {
		SampleBinaryTree.Node<Integer> temp = null;
		int count = 0;
		LinkedListQueue<SampleBinaryTree.Node<Integer>> queue = new LinkedListQueue<>();
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left != null && temp.right != null) {
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
		NumOfFullNode fullNode = new NumOfFullNode();
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		SampleBinaryTree tree1 = SampleBinaryTree.getDefaultTree();
		System.out.println("leaf node in default tree: " + fullNode.numOfFullNode(tree1.getRoot()));
		System.out.println("leaf node in custom tree: " + fullNode.numOfFullNode(tree.getRoot()));
	}
}
