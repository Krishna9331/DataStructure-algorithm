package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;
import static java.lang.Math.max;

/**
 * Created by mishrk3 on 6/16/2016.
 */
public class DiameterOfTree {

	public int findDiameter(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int leftDiameter = findDiameter(root.left);
		int rightDiameter = findDiameter(root.right);
		return max(leftHeight + rightHeight + 1, max(leftDiameter, rightDiameter));
	}

	private int height(Node<Integer> root) {
		if (root == null) {
			return 0;
		}
		return 1 + max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		SampleBinaryTree dTree = SampleBinaryTree.getDefaultTree();
		DiameterOfTree dt = new DiameterOfTree();

		System.out.println("The diameter of default tree: " + dt.findDiameter(tree.getRoot()));
		System.out.println("The diameter of custom tree: " + dt.findDiameter(dTree.getRoot()));
	}
}
