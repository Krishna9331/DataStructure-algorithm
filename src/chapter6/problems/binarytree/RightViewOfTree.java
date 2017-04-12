package chapter6.problems.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

import chapter6.problems.binarytree.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 4/12/2017.
 */
public class RightViewOfTree {

	private class QItem {
		Node<Integer> item;
		int level;

		public QItem(Node<Integer> item, int level) {
			this.item = item;
			this.level = level;
		}
	}

	public void rightView(Node<Integer> root) {
		int maxLevel = -1;
		QItem qi = new QItem(root, 0);
		Queue<QItem> q = new ArrayDeque<>();
		q.add(qi);

		while (!q.isEmpty()) {
			qi = q.remove();
			Node<Integer> temp = qi.item;
			int hd = qi.level;
			if (hd > maxLevel) {
				maxLevel = hd;
				System.out.println(temp.item);
			}

			if (temp.right != null) {
				qi = new QItem(temp.right, hd + 1);
				q.add(qi);
			}

			if (temp.left != null) {
				qi = new QItem(temp.left, hd + 1);
				q.add(qi);
			}
		}
	}

	public static void main(String[] args) {
		RightViewOfTree rvot = new RightViewOfTree();
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();
		tree.getRoot().left.left.right = new Node<>(23, null, null);
		tree.getRoot().left.left.right.left = new Node<>(43, null, null);
		rvot.rightView(tree.getRoot());
	}

}
