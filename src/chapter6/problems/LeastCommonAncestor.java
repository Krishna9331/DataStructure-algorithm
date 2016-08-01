package chapter6.problems;

import static chapter6.problems.SampleBinaryTree.Node;

/**
 * Created by mishrk3 on 6/17/2016.
 */
public class LeastCommonAncestor {
	/**
	 * @param root     root of the binary tree
	 * @param firstEle first element for which least common ancestor need to be found
	 * @param secEle   second element for which least common ancestor need to be found
	 * @return the least common ancestor
 	 * Algorithm for code:
	 * 1) if root is null return null.
	 * 2) if root is equal to any of the two element return root.
	 * 3) call method recursively for left element of root store it as left Node.
	 * 4) call method recursively for right element of root store it as right Node.
	 * 5) if left and right both is not null return root.
	 * 6) else return whichever is not null.
	 * How it work for below code suppose we have a tree with root as 1 and which has left as 2 and right as 3.
	 * 2 has left as 4 and right as 5. Also 5 has left child as 7.
	 * 3 has left as 6 and that of right is 9.
	 * lets assume we are trying to find common ancestor for 4 and 7.
	 * Execution:
	 * first call will be LCA(1, 4, 7) it will go to step 3 and step4 which will result as
	 * left = LCA(2, 4, 7) and right = LCA(3, 4, 7) lets assume it as state 1.
	 * here both the left and right will trigger it's own call stack so lets evaluate left one:
	 * LCA(2, 4, 7) will again split it as left = LCA(4, 4, 7) and right LCA(5, 4, 7) lets say it is state2.
	 * the left call will immediately return 4 as it will satisfy step 2. so for state 2 we have left value as 4.
	 * The right call will further start the call stack and evaluate as left= (7, 4, 7) and right = (NULL, 4, 7) say
	 * state 3 for this value will be left = 7(STEP 2) and right= NULL(STEP 1).
	 * now the state 3 will result as 7(step 6).
	 * so the left of state 2 got 4 and right has 7, which will satisfy the STEP 5 and it will return 2 as result for
	 * the left recursive call of the state 1.
	 * if we similarly do for right of state 1 (right = LCA(3, 4, 7)) we will get NULL as answer.
	 * Now state 1 will have left as 2 and right as NULL so final answer will be 2.
	 */

	public Node<Integer> findLeastCommonAncestor(Node<Integer> root, Integer firstEle, Integer secEle) {
		Node<Integer> left = null;
		Node<Integer> right = null;
		if (root == null) {
			return null;
		}
		if (root.item == firstEle || root.item == secEle) {
			return root;
		}
		left = findLeastCommonAncestor(root.left, firstEle, secEle);
		right = findLeastCommonAncestor(root.right, firstEle, secEle);
		if (left != null && right != null) {
			return root;
		} else {
			return left != null ? left : right;
		}

	}

	public static void main(String[] args) {
		LeastCommonAncestor ls = new LeastCommonAncestor();
		SampleBinaryTree tree = SampleBinaryTree.getCustomTree();
		System.out.println(
				"The common ancestor for 4 and 21 is: " + ls.findLeastCommonAncestor(tree.getRoot(), 4, 21).item);
	}
}
