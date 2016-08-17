package chapter6.problems.binarytree;

import chapter5.LinkedListQueue;

/**
 * Created by mishrk3 on 5/24/2016.
 */
public class InsertElement {

	public void insertElement(SampleBinaryTree.Node<Integer> root, int data) {
		SampleBinaryTree.Node<Integer> newNode = new SampleBinaryTree.Node<>(data, null, null);
		SampleBinaryTree.Node<Integer> p = root;
		SampleBinaryTree.Node<Integer> temp;
		LinkedListQueue<SampleBinaryTree.Node<Integer>> queue = new LinkedListQueue<>();
		if (root == null) {
			root = newNode;
			return;
		}
		queue.enQueue(p);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left == null) {
				temp.left = newNode;
			} else {
				queue.enQueue(temp.left);
			}
			if (temp.right == null) {
				temp.right = newNode;
			} else {
				queue.enQueue(temp.right);
			}
		}
	}
}
