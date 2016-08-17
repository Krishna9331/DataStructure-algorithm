package chapter6.problems.binarytree;

/**
 * Created by mishrk3 on 6/16/2016.
 */
public class StructurallyEqualTree {

	public boolean isStructurallyEqual(SampleBinaryTree.Node<Integer> root1, SampleBinaryTree.Node<Integer> root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		return (root1.item == root2.item && isStructurallyEqual(root1.left, root2.left) && isStructurallyEqual(
				root1.right, root2.right));
	}

	public static void main(String[] args) {
		SampleBinaryTree tree1 = SampleBinaryTree.getCustomTree();
		SampleBinaryTree tree2 = SampleBinaryTree.getCustomTree();
		SampleBinaryTree tree3 = SampleBinaryTree.getDefaultTree();
		SampleBinaryTree tree4 = SampleBinaryTree.getDefaultTree();
		StructurallyEqualTree seq = new StructurallyEqualTree();

		System.out.println("comparing same custom tree: " + seq.isStructurallyEqual(tree1.getRoot(), tree2.getRoot()));
		System.out.println("comparing same default tree: " + seq.isStructurallyEqual(tree3.getRoot(), tree4.getRoot
				()));
		System.out.println(
				"comparing custom vs default tree: " + seq.isStructurallyEqual(tree1.getRoot(), tree3.getRoot()));
	}
}
