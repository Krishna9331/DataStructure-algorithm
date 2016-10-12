package chapter6.problems.avl;

import static chapter6.problems.avl.AVLTree.*;
import static java.lang.Math.max;

/**
 * Created by mishrk3 on 10/12/2016.
 */
public class InsertIntoAVL {

	/**
	 * @param root
	 *            the root element of AVL tree
	 * @param parent
	 *            the parent element for which child need to be inserted
	 * @param data
	 *            the data which need to be inserted
	 * @return the root of the newly created tree after insertion of {@data}
	 */
	public Node<Integer> insertInAVL(Node<Integer> root, Node<Integer> parent, Integer data) {
		if (root == null) {
			return new Node<>(data, null, null, 1);
		} else if (data <= root.data) {
			root.left = insertInAVL(root.left, root, data);
			if ((getHeight(root.left) - getHeight(root.right)) == 2) {
				if (data < root.left.data) {
					root = singleRotateLeft(root);
				} else {
					root = doubleRotateLeft(root);
				}
			}
		} else if (data > root.data) {
			root.right = insertInAVL(root.right, root, data);
			if ((getHeight(root.right) - getHeight(root.left)) == 2) {
				if (data > root.right.data) {
					root = singleRotateRight(root);
				} else {
					root = doubleRotateRight(root);
				}
			}
		}
		root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
		return root;
	}

	public static void main(String[] args) {
		InsertIntoAVL intoAVL = new InsertIntoAVL();
		Node<Integer> root = intoAVL.insertInAVL(null, null, 1);
		Node<Integer> root1 = intoAVL.insertInAVL(root, root, 2);
		Node<Integer> root2 = intoAVL.insertInAVL(root1, root, 3);
		Node<Integer> root3 = intoAVL.insertInAVL(root2, root, 4);
		Node<Integer> finalRoot = intoAVL.insertInAVL(root3, root, 5);
		System.out.println("The root of the tree now: " + finalRoot.data);

		InsertIntoAVL intoAVL1 = new InsertIntoAVL();
		Node<Integer> rootA = intoAVL1.insertInAVL(null, null, 9);
		Node<Integer> rootA1 = intoAVL1.insertInAVL(rootA, root, 6);
		Node<Integer> rootA2 = intoAVL1.insertInAVL(rootA1, root, 7);
		Node<Integer> rootA3 = intoAVL1.insertInAVL(rootA2, root, 4);
		Node<Integer> finalRootA = intoAVL1.insertInAVL(rootA3, root, 5);
		System.out.println("The root of the tree now: " + finalRootA.data);

		InsertIntoAVL intoAVL2 = new InsertIntoAVL();
		Node<Integer> rootB = intoAVL2.insertInAVL(null, null, 7);
		Node<Integer> rootB1 = intoAVL2.insertInAVL(rootB, root, 9);
		Node<Integer> rootB2 = intoAVL2.insertInAVL(rootB1, root, 6);
		Node<Integer> rootB3 = intoAVL2.insertInAVL(rootB2, root, 4);
		Node<Integer> finalRootB = intoAVL2.insertInAVL(rootB3, root, 5);
		System.out.println("The root of the tree now: " + finalRootB.data);
	}
}
