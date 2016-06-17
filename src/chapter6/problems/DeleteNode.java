package chapter6.problems;

import chapter5.LinkedListQueue;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/16/2016.
 */
public class DeleteNode {

	public void deleteNodeFromTree(Node<Integer> root, Integer searchElement) {

		DeepestElement de = new DeepestElement();
		Node<Integer> deepestNode = de.findDeepestElement(root);
		Node<Integer> temp = null;

		LinkedListQueue<Node<Integer>> queue = new LinkedListQueue<>();
		queue.enQueue(root);

		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.item == searchElement) {
				temp.item = deepestNode.item;
				deepestNode.item = null;
				break;
			}
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}

		queue.enQueue(root);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (temp.left != null && temp.left.item == null) {
				temp.left = null;
			}
			if (temp.right != null && temp.right.item == null) {
				temp.right = null;
			}
			if (temp.left != null) {
				queue.enQueue(temp.left);
			}
			if (temp.right != null) {
				queue.enQueue(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		DeleteNode dn = new DeleteNode();
		SampleBinaryTree tree = SampleBinaryTree.getDefaultTree();
		dn.deleteNodeFromTree(tree.getRoot(), 3);
		System.out.println("Node deleted");
	}
}
