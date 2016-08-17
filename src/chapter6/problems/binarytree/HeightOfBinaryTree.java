package chapter6.problems.binarytree;

import chapter5.LinkedListQueue;

/**
 * Created by mishrk3 on 6/13/2016.
 */
public class HeightOfBinaryTree {

	public int heightOfTreeRecursively(SampleBinaryTree.Node<Integer> root) {
		int leftHeight = 0;
		int rightHeight = 0;
		if (null == root) {
			return 0;
		} else {
			leftHeight = heightOfTreeRecursively(root.left);
			rightHeight = heightOfTreeRecursively(root.right);
		}
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	/**
	 * @param root of the tree
	 * @return height of the tree
	 * below code works on the concept of level order traversal where each level add 1 to the height.
	 * remember that each level not the each element so we need an identifier when a level ends.
	 * To do so we add a null at the end of each traversal.
	 * e.g for tree having root as 1 and left and right as 2 and 3 respectively.
	 * if 2 has left as 4 and right as 5
	 * 3 has left as 6 and right as 7
	 * and 5 has left child as 8.
	 * The below logic will first put 1 in Queue followed by null  ---> [1, null]
	 * it will dequeue 1 which is not null hence it will enqueue 2 and 3.  [null, 2, 3]
	 * again next iteration will start and dequeue null and which will force the control to go inside where the if
	 * condition check(queue is not empty will pass) hence it will put null as marker for end of level and then
	 * increase the count.   [2, 3, null]
	 * Thus we see that after each level it increase the count and increase the count
	 */
	public int heightOfTree(SampleBinaryTree.Node<Integer> root) {
		int level = 0;
		LinkedListQueue<SampleBinaryTree.Node<Integer>> queue = new LinkedListQueue<>();
		SampleBinaryTree.Node<Integer> temp;
		if (null == root) {
			return 0;
		}
		queue.enQueue(root);
		//end first level
		queue.enQueue(null);
		while (!queue.isEmpty()) {
			temp = queue.deQueue();
			if (null == temp) {
				//marker for next level
				if (!queue.isEmpty()) {
					queue.enQueue(null);
				}
				level++;
			} else {
				if (null != temp.left) {
					queue.enQueue(temp.left);
				}
				if (null != temp.right) {
					queue.enQueue(temp.right);
				}
			}
		}
		return level;
	}

	public static void main(String[] args) {
		SampleBinaryTree<Integer> tree = SampleBinaryTree.getDefaultTree();
		HeightOfBinaryTree hobt = new HeightOfBinaryTree();
		System.out.println("The height of tree using recursion is: " + hobt.heightOfTreeRecursively(tree.getRoot()));
		System.out.println("The height of tree is: " + hobt.heightOfTree(tree.getRoot()));
	}
}
