package chapter9.problems;

import chapter9.Graph;
import chapter9.GraphUsingMatrix;

/**
 * Created by mishrk3 on 2/28/2017. <br/>
 * Given a graph G count the number of simple path between source to destination. <pre>
 *          4
 *     A -----------> B
 *     |            /   \
 *     |1         /      \ 4
 *     |        /         \
 *     |      /  2         E   F
 *     |    /             /     \
 *     |  /              /4      \2
 *     |/      4        /         \
 *     C-------------->D           G
 * In the above graph A to F is not reachable while F to g or A to D is reachable.
 *     </pre>
 */
public class SimplePathCounter {

	private static int count = 0;

	public void getSimplePath(Graph g, int src, int dest, boolean[] visited) {
		visited[src] = true;
		if (src == dest) {
			count++;
			visited[src] = false;
			return;
		}
		for (int t = 0; t < g.vertex; t++) {
			if (((GraphUsingMatrix) g).adjacent[src][t] == 1 && !visited[t]) {
				getSimplePath(g, t, dest, visited);
				visited[t] = false;
			}
		}
	}

	public static void main(String[] args) {
		SimplePathCounter spc = new SimplePathCounter();
		GraphUsingMatrix graph = new GraphUsingMatrix(7, 7);
		boolean[] visited = new boolean[graph.vertex];
		spc.getSimplePath(graph, 0, 1, visited);
		System.out.println("Number of path from A to B: " + count);
		count = 0;
		visited = new boolean[graph.vertex];
		spc.getSimplePath(graph, 0, 5, visited);
		System.out.println("Number of path from A to F: " + count);
	}
}
