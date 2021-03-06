package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 6/17/2016.
 */
public class MirrorTree {

	public SampleBinaryTree.Node<Integer> mirrorTree(SampleBinaryTree.Node<Integer> root) {
		SampleBinaryTree.Node<Integer> temp = null;
		if (root != null) {
			mirrorTree(root.left);
			mirrorTree(root.right);
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	public boolean isMirrorTree(SampleBinaryTree.Node<Integer> root1, SampleBinaryTree.Node<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.item != root2.item) {
			return false;
		} else {
			return isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left);
		}
	}

	public static void main(String[] args) {
		MirrorTree mt = new MirrorTree();
		SampleBinaryTree tree = SampleBinaryTree.getDefaultTree();
		SampleBinaryTree tree1 = SampleBinaryTree.getDefaultTree();
		SampleBinaryTree.Node<Integer> mirroredOne = mt.mirrorTree(tree.getRoot());
		System.out.println("Tree is mirrored");
		System.out.println("two tree are mirror of each other: " + mt.isMirrorTree(tree1.getRoot(), mirroredOne));
	}
}
