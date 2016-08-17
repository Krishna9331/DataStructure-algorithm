package chapter6.problems.binarytree;

import chapter5.LinkedListQueue;

/**
 * Created by mishrk3 on 6/13/2016.
 */
public class DeepestElement {

	public SampleBinaryTree.Node<Integer> findDeepestElement(SampleBinaryTree.Node<Integer> root) {
		LinkedListQueue<SampleBinaryTree.Node<Integer>> queue = new LinkedListQueue<>();
		SampleBinaryTree.Node<Integer> temp = null;
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
