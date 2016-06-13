package chapter6.problems;

import chapter4.LinkedListStack;
import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/13/2016.
 */
public class ReverseLevelOrder {

	public void printReverseLevelOrder(Node<Integer> root) {
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		LinkedListStack<Node<Integer>> stack = new LinkedListStack<>();
		Node<Integer> temp;
		if (null == root) {
			System.out.printf("No element in tree");
		}
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			stack.push(temp);
			if (null != temp.left) {
				queue.enQueue(temp.left);
			}
			if (null != temp.right) {
				queue.enQueue(temp.right);
			}
		}

		while (!stack.isEmpty()) {
			System.out.printf(stack.pop().item + " ");
		}
	}

	public static void main(String[] args) {
		ReverseLevelOrder rlo = new ReverseLevelOrder();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();
		rlo.printReverseLevelOrder(tree.getRoot());
	}
}
