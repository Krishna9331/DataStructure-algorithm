package chapter8;

/**
 * Created by mishrk3 on 2/10/2017.
 */

/**
 * <pre>
 * The Fast union operation for disjoint set is achieved using below technique:
 * 		1.Store the height of the tree for the root of the set
 * 		2.Store the root for the other element of the set
 * 	e.g:
 * 	 for set: 0, 1, 2, 3, 4, 5, 6
 * 	    	2
 * 	      /	 \
 * 	    /     \  ===> Array Representation
 * 	   0       1     2, 2, -3, -1, -1, -1, -1
 * 	   
 * 	   for
 * 	    0, 1, 2, 3, 4, 6
 * 	                  /   ==> Array representation
 *                  /      -1, -1, -1, -1, -1, 6, -2
 *                 5 
 * </pre>
 */
public class DisjointSetFastUnion {

	public void makeSet(int[] set, int size) {
		for (int i = 0; i < size; i++) {
			set[i] = -1;
		}
	}

	public int find(int[] set, int x) {
		if (set[x] <= -1) {
			return x;
		} else {
			return find(set, set[x]);
		}
	}

	public void union(int[] set, int root1, int root2) {
		if (find(set, root1) == find(set, root2) && find(set, root2) != -1) {
			return;
		}
		if (set[root2] < set[root1]) {
			set[root2] += set[root1];
			set[root1] = root2;
		} else {
			set[root1] += set[root2];
			set[root2] = root1;
		}
	}

	public static void main(String[] args) {
		DisjointSetFastUnion dsfu = new DisjointSetFastUnion();
		int[] set = {
				0, 1, 2, 3, 4, 5, 6, 7, 8
		};
		dsfu.makeSet(set, 9);
		dsfu.union(set, 0, 1);
		dsfu.union(set, 0, 2);
		dsfu.union(set, 0, 3);
		int root = dsfu.find(set, 0);
		int root1 = dsfu.find(set, 1);
		int root2 = dsfu.find(set, 2);
		int root3 = dsfu.find(set, 3);
		System.out.println("The root of 0 is: " + root);
		System.out.println("The root of 1 is: " + root1);
		System.out.println("The root of 2 is: " + root2);
		System.out.println("The root of 3 is: " + root3);
		dsfu.union(set, 5, 6);
		dsfu.union(set, 5, 7);
		int root5 = dsfu.find(set, 5);
		int root6 = dsfu.find(set, 6);
		int root7 = dsfu.find(set, 7);
		System.out.println("The root of 5 is: " + root5);
		System.out.println("The root of 6 is: " + root6);
		System.out.println("The root of 7 is: " + root7);
		System.out.println("combining two subset each having more than one element...");
		dsfu.union(set, 0, 5);
		int root0 = dsfu.find(set, 0);
		int root5Upd = dsfu.find(set, 5);
		System.out.println("The root of 0 post union is: " + root0);
		System.out.println("The root of 5 post union is: " + root5Upd);
	}
}
