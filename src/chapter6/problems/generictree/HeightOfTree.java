package chapter6.problems.generictree;

/**
 * Created by mishrk3 on 8/16/2016.
 */

/**
 * In general for n (a nodes can have 0 to n-1 element)array tree with node m the maximum height of tree can be
 * represented as, hMax = m-1. Question: Given a parent array P, where P[i] indicates the parent of ith node in the
 * <pre>
 * tree(assume parent of root node is -1). Give an algorithm for finding height and depth of the tree. e.g. 
 * P = {-1, 0, 1, 6, 6, 0, 0, 2, 7}
 * Tree representation:
 * 
 *                      0
 *                    / | \
 *                   /  |  \
                    5   1   6
                       /
                      2
                     /
                    7
                   /
                  8
 * </pre>
 */
public class HeightOfTree {

	/**
	 * @param p
	 *            array of integer
	 * @param n
	 *            length of array p
	 * @return depth or height of tree The logic for below code is start from each index and traverse to parent and find
	 *         the the depth. Compare the depth with current max and populate max accordingly.
     *
     *         The time complexity is O(n2) for skewed tree and space complexity is O(1).
	 */
	int findDepthInGenericTree(int[] p, int n) {

		int maxDepth = -1;
		int currDepth = -1;
		int j;
		for (int i = 0; i < n; i++) {
			currDepth = 0;
			j = i;
			while (p[j] != -1) {
				j = p[j];
				currDepth++;
			}
			if (currDepth > maxDepth) {
				maxDepth = currDepth;
			}
		}
		return maxDepth;
	}

	public static void main(String[] args) {
		HeightOfTree h = new HeightOfTree();
		int[] p = {
				-1, 0, 1, 6, 6, 0, 0, 2, 7
		};
		int height = h.findDepthInGenericTree(p, 9);
		System.out.printf("Height of tree is: " + height);
	}
}
