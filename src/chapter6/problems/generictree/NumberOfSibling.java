package chapter6.problems.generictree;

import chapter5.LinkedListQueue;

import static chapter6.problems.generictree.GenericTree.Node;

/**
 * Created by mishrk3 on 8/16/2016.
 */

/**
 * Question: Given a node of generic tree calculate the number of Sibling for that node.
 */
public class NumberOfSibling {
	int count = 0;
	boolean found = false;

	public int numOfSibling(Node<Integer> root, int node) {
		if (node == root.item) {
			return 0;
		}
		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		Node<Integer> temp = null;
		queue.enQueue(root);
		queue.enQueue(null);
		while (!queue.isEmpty()) {
			found = false;
			count = 0;
			temp = queue.deQueue();
			if (temp == null) {
				if (!queue.isEmpty()) {
					queue.enQueue(null);
				}
			} else {
				if (temp.firstChild != null) {
					count++;
					temp = temp.firstChild;
					queue.enQueue(temp);
					if (temp.item == node) {
						found = true;
					}
					while (temp.nextSibling != null) {
						count++;
						temp = temp.nextSibling;
						if (temp.item == node) {
							found = true;
						}
						queue.enQueue(temp);
					}
					if (found) {
						return count;
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		NumberOfSibling s = new NumberOfSibling();
		GenericTree<Integer> tree = GenericTree.createTree();
		int num = s.numOfSibling(tree.root, 11);
		System.out.println("Number of sibling of 11 is: " + num);
		int num1 = s.numOfSibling(tree.root, 7);
		System.out.println("Number of sibling of 7 is: " + num1);
        int num2 = s.numOfSibling(tree.root, 8);
		System.out.println("Number of sibling of 8 is: " + num2);
	}


}
