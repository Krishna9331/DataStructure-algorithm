package chapter8;

/**
 * Created by mishrk3 on 2/9/2017.
 */

/**
 * A disjoint set data structure keeps track of a set of elements partitioned intoa number of disjoints(non-overlapping)
 * subset.
 */
public class DisjointSet {

	void makeSet(int[] set, int size) {

		for (int i = size - 1; i >= 0; i--) {
			set[i] = i;
		}
	}

	/**
	 * @param set
	 *            The array containing set
	 * @param x
	 *            element to be found
	 * @return the root under which the element falls<br/>
	 *         The time complexity is O(n) see the comment in union method below
	 */
	public int find(int[] set, int x) {

		if (set[x] == x) {
			return x;
		} else
			return find(set, set[x]);
	}

	/**
	 * @param set
	 *            The array containing set
	 * @param size
	 *            length of the array
	 * @param root1
	 *            root of first set
	 * @param root2
	 *            root of second set <br/>
	 *            The below method combines two sets into the single one. The root of the final set will be either the
	 *            root of first or the second set.<br/>
	 *            <pre>
	 *                0, 1, 2, 3, 4, 5, 6, 7, 8
	 *                after union (0, 1)
	 *
	 *               1  2 3 4 5 6 7 8         Array representation
	 *                \               ===>   1, 1, 2, 3, 4, 5, 6, 7, 8
	 *                 \
	 *                  0
	 *               after union(1, 4)        Array representation
	 *               4  2 3 4 5 6 7 8  ===>   4, 4, 2, 3, 4, 5, 6, 7, 8
	 *              / \
	 *            /    \
	 *           1      0
	 *           
	 *       If we do union of all element in series it is possible that it form skew tree so for finding an element
	 *       the worst case scenario will be O(n)
	 *            </pre>
	 */
	public void union(int[] set, int size, int root1, int root2) {
		if (find(set, root1) == find(set, root2)) {
			return;
		}
		if (root1 < 0 || root1 >= size || root2 < 0 || root2 >= size) {
			return;
		}
		set[root1] = root2;
	}

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet();

		int[] set = {
				0, 1, 2, 3, 4, 5, 6, 7, 8
		};
		ds.makeSet(set, 9);
		ds.union(set, 9, 0, 1);
		ds.union(set, 9, 1, 4);
		ds.union(set, 9, 0, 5);
		int root = ds.find(set, 0);
		int root1 = ds.find(set, 1);
		int root2 = ds.find(set, 4);
		System.out.println("The root of 0 is: " + root);
		System.out.println("The root of 1 is: " + root1);
		System.out.println("The root of 4 is: " + root2);
	}
}
