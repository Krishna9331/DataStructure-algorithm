package chapter6.problems.binarytree;

import static chapter6.problems.binarytree.SampleBinaryTree.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mishrk3 on 12/29/2016.
 */
public class TopView {

	public class QItem {
		Node<Integer> node;
		int horizontalDistance;

		public QItem(Node<Integer> node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
	}

	public void printTopView(Node<Integer> root) {
		if (null == root) {
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		Queue<QItem> queue = new LinkedList<>();
		queue.add(new QItem(root, 0)); // Horizontal distance of root is zero
		// standard BFS or level order traversal
		while (!queue.isEmpty()) {
			QItem qi = queue.remove();
			int hd = qi.horizontalDistance;
			Node<Integer> n = qi.node;
			if (!set.contains(hd)) {
				set.add(hd);
				System.out.print(n.item + " ");
			}

			if (null != n.left) {
				queue.add(new QItem(n.left, hd - 1));
			}
			if (null != n.right) {
				queue.add(new QItem(n.right, hd + 1));
			}
		}
	}

	public void printTopViewInOrder(Node<Integer> root) {
		if (null == root) {
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		Stack<QItem> stack = new Stack<>();
		int hd = 0;
		QItem qi = null;
		// standard BFS or level order traversal
		Node<Integer> p = root;
		while (true) {
			while (null != p) {
				qi = new QItem(p, hd);
				stack.push(qi);
				p = p.left;
				hd--;
			}
			if (stack.isEmpty()) {
				break;
			}
			qi = stack.pop();
			p = qi.node;
			hd = qi.horizontalDistance;
			if (!set.contains(qi.horizontalDistance)) {
				set.add(qi.horizontalDistance);
				System.out.print(qi.node.item + " ");
			}
			p = p.right;
			hd++;
		}
	}

	public static void main(String[] args) {
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultBST();
		TopView tv = new TopView();
		tv.printTopView(tree.getRoot());
		System.out.println();
		tv.printTopViewInOrder(tree.getRoot());
	}
}
