package chapter6.problems;

import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/13/2016.
 */
public class DeepestElement {

	public Node<Integer> findDeepestElement(Node<Integer> root) {
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		Node<Integer> temp = null;
		if (null == root) {
			return null;
		}
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (null != temp.left) {
				queue.enQueue(temp.left);
			}
			if (null != temp.right) {
				queue.enQueue(temp.right);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		DeepestElement de = new DeepestElement();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();
		SampleBinaryTree<Integer> tree1 = SampleBinaryTree.getCustomTree();
		System.out.println("The deepest element is: " + de.findDeepestElement(tree.getRoot()).item);
		System.out.println("The deepest element is: " + de.findDeepestElement(tree1.getRoot()).item);
	}

}
