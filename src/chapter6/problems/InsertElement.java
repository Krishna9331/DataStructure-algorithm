package chapter6.problems;

import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 5/24/2016.
 */
public class InsertElement {

	public void insertElement(Node<Integer> root, int data) {
		Node<Integer> newNode = new Node<>(data, null, null);
		Node<Integer> p = root;
		Node<Integer> temp;
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
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
