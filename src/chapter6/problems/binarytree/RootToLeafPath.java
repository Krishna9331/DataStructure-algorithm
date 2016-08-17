package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 6/17/2016.
 */
public class RootToLeafPath {

	void printPath(SampleBinaryTree.Node<Integer> root, int[] paths, int pathLen) {
		if (root == null) {
			return;
		}
		paths[pathLen] = root.item;
		pathLen++;
		if (root.left == null && root.right == null) {
			printArray(paths, pathLen);
		} else {
			printPath(root.left, paths, pathLen);
			printPath(root.right, paths, pathLen);
		}
	}

	private void printArray(int[] paths, int len) {
		for (int i = 0; i < len; i++) {
			System.out.printf(paths[i] + "-->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RootToLeafPath rtlf = new RootToLeafPath();
		SampleBinaryTree tree = SampleBinaryTree.getDefaultTree();
		SampleBinaryTree tree1 = SampleBinaryTree.getCustomTree();
		int[] paths = new int[20];
		rtlf.printPath(tree.getRoot(), paths, 0);
		int[] paths1 = new int[20];
		System.out.println("The custom Tree: ");
		rtlf.printPath(tree1.getRoot(), paths1, 0);
	}
}
