package chapter9.problems;

/**
 * Created by mishrk3 on 3/7/2017.
 */

import chapter9.Graph;
import chapter9.GraphUsingMatrix;

/**
 * Count Number of connected components of a graph which is represented in adjacent matrix. <br/>
 * <pre>
 *     We can use DFS traversal with one extra counter.
 * </pre>
 */
public class ConnectedComponent {

	private void findConnectedComp(GraphUsingMatrix graph, int src, boolean[] visited) {
		visited[src] = true;

		for (int v = 0; v < graph.vertex; v++) {
			if (graph.adjacent[src][v] == 1 && !visited[v]) {
				findConnectedComp(graph, v, visited);
			}
		}

	}

	private void printConnectedCompCount(GraphUsingMatrix graph) {
		boolean[] visited = new boolean[graph.vertex];

		int count = 0;

		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i]) {
				findConnectedComp(graph, i, visited);
				count++;
			}
		}

		System.out.println("The number of connected components are: " + count);
	}

	public static void main(String[] args) {
		ConnectedComponent cc = new ConnectedComponent();
		GraphUsingMatrix graph = new GraphUsingMatrix(5, 4);
		cc.printConnectedCompCount(graph);
	}
}
