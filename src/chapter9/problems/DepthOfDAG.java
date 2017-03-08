package chapter9.problems;

/**
 * Created by mishrk3 on 3/8/2017.
 */

import chapter5.LinkedListQueue;
import chapter9.Graph;
import chapter9.GraphUsingMatrix;

/**
 * Write and algorithm to find depth of a directed graph.<br/>
 * <pre>
 *            3      2      1
 *          \   \   /      /|
 *           \   \/      /  |    1 ---> 4
 *            \ / \    /   /     1 ---> 6
 *             7   \ /    /      2 ---> 7
 *            /| \  4   /        3 ---> 4
 *          /  |  \/  /          3 ---> 7
 *         0   \ / \/            7 ---> 0
 *              5  6             7 ---> 5
 *                               7 ---> 6
 *                               4 ---> 5
 *   Input:
 *   Enter pair 0:
 	1 4
	 Enter pair 1:
 	1 6
 	Enter pair 2:
 	2 7
 	Enter pair 3:
 	3 4
 	Enter pair 4:
 	3 7
 	Enter pair 5:
 	7 0
 	Enter pair 6:
 	7 5
 	Enter pair 7:
 	7 6
 	Enter pair 8:
 	4 5
 * </pre>
 */
public class DepthOfDAG {

	public static final int SENTINEL = -1;

	public int findDepthOfDAG(GraphUsingMatrix graph) {
		int[] inDegree = new int[graph.vertex];
		int counter = 0;
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		// calculate in-degree for each vertex
		for (int i = 0; i < graph.vertex; i++) {
			for (int j = 0; j < graph.vertex; j++) {
				if (graph.adjacent[i][j] == 1) {
					inDegree[j] += 1;
				}
			}
		}
		//insert the vertex with in-degree 0
		for (int i = 0; i < graph.vertex; i++) {
			if (inDegree[i] == 0) {
				queue.enQueue(i);
			}
		}
		//put the sentinel for marking end of level
		queue.enQueue(SENTINEL);
		while (!queue.isEmpty()) {
			int v = queue.deQueue();
			if (v == -1) {
				counter++;
				if (!queue.isEmpty()) {
					queue.enQueue(SENTINEL);
				}
			} else {
				for (int p = 0; p < graph.vertex; p++) {
					if (graph.adjacent[v][p] == 1 && --inDegree[p] == 0) {
						queue.enQueue(p);
					}
				}
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		DepthOfDAG dod = new DepthOfDAG();

		GraphUsingMatrix graph = new GraphUsingMatrix(8, 9);
		int depth = dod.findDepthOfDAG(graph);
		System.out.println(depth);
	}
}
