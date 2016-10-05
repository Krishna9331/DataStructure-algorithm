package chapter6.problems.bst;

/**
 * Created by mishrk3 on 10/5/2016.
 */

/**
 * Find number of possible tree from given 1 ... n keys.
 */
public class NumberOfBST {

	/**
	 * @param n
	 *            the highest value of key
	 * @return number of trees<br/>
	 *         logic is each key can be root and then recursively calculate left and right possible combination
	 */
	public int countTrees(int n) {
		if (n <= 1) {
			return 1;
		} else {
			int sum = 0;
			int left, right, root;
			for (root = 1; root <= n; root++) {
				left = countTrees(root - 1);
				right = countTrees(n - root);
				sum = sum + left * right;
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		NumberOfBST numberOfBST = new NumberOfBST();
		int trees = numberOfBST.countTrees(5);
		System.out.println("Number of possible BST from 1...5 is: " + trees);
	}
}
