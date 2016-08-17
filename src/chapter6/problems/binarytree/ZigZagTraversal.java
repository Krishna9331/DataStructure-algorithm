package chapter6.problems.binarytree;

import chapter4.LinkedListStack;

/**
 * Created by mishrk3 on 6/20/2016.
 */
public class ZigZagTraversal {

	public void zigZagTraverse(SampleBinaryTree.Node<Integer> root) {
		SampleBinaryTree.Node<Integer> temp;
		boolean leftToRight = true;
		if (root == null) {
			return;
		}
		LinkedListStack<SampleBinaryTree.Node<Integer>> currentLevel = new LinkedListStack<>();
		LinkedListStack<SampleBinaryTree.Node<Integer>> nextLevel = new LinkedListStack<>();
		currentLevel.push(root);
		while (!currentLevel.isEmpty()) {
			temp = currentLevel.pop();
			if (temp != null) {
				System.out.printf(" " + temp.item);
				if (leftToRight) {
					if (temp.left != null)
						nextLevel.push(temp.left);
					if (temp.right != null)
						nextLevel.push(temp.right);
				} else {
					if (temp.right != null)
						nextLevel.push(temp.right);
					if (temp.left != null)
						nextLevel.push(temp.left);
				}
			}
			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				LinkedListStack<SampleBinaryTree.Node<Integer>> tempStack = currentLevel;
				currentLevel = nextLevel;
				nextLevel = tempStack;
			}
		}
	}

	public static void main(String[] args) {
		SampleBinaryTree tree = SampleBinaryTree.getDefaultTree();
		ZigZagTraversal traversal = new ZigZagTraversal();
		traversal.zigZagTraverse(tree.getRoot());
	}
}
