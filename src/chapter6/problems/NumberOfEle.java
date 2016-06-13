package chapter6.problems;

import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 5/24/2016.
 */
public class NumberOfEle {

	public int numberOfElement(Node<Integer> root) {
		Node<Integer> p = root;
		Node<Integer> temp;
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		int count = 0;
		if (p != null) {
			count++;
			queue.enQueue(p);
		}
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left != null) {
				queue.enQueue(temp.left);
				count++;
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
				count++;
			}
		}
		return count;
	}

	public int sizeOfTree(Node<Integer> root) {
		if (null == root) {
			return 0;
		}
		return sizeOfTree(root.left) + 1 + sizeOfTree(root.right);
	}

	public static void main(String[] args) {
		NumberOfEle noe = new NumberOfEle();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();

		System.out.println("The number of elements in tree is: " + noe.numberOfElement(tree.getRoot()));
		System.out.println("The number of elements in tree using recursion is: " + noe.sizeOfTree(tree.getRoot()));
	}
}
