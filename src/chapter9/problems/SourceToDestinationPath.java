package chapter9.problems;

/**
 * Created by mishrk3 on 2/21/2017.
 */

import chapter9.Graph;
import chapter9.GraphUsingMatrix;

/**
 * Given a graph G find that there is a simple path from source s to destination d. <pre>
 *          4
 *     A -----------> B
 *     |            /   \
 *     |1         /      \ 4
 *     |        /         \
 *     |      /  2         E   F
 *     |    /             /     \
 *     |  /              /4      \
 *     |/      4        /         \
 *     C-------------->D           G
 * In the above graph A to F is not reachable while F to g or A to D is reachable.
 *     </pre> <br/>
 * Logic is to apply DFS starting from the source node and check if it is same as destination otherwise apply DFS on all
 * unvisited connected node of current node.
 */
public class SourceToDestinationPath {

	public boolean hasSimplePath(Graph graph, int src, int dest, boolean[] visited) {
		visited[src] = true;
		if (src == dest) {
			return true;
		}
		for (int t = 0; t < graph.vertex; t++) {
			if (((GraphUsingMatrix) graph).adjacent[src][t] == 1 && !visited[t]) {
				if (hasSimplePath(graph, t, dest, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SourceToDestinationPath std = new SourceToDestinationPath();
		GraphUsingMatrix graph = new GraphUsingMatrix(7, 7);
		boolean[] visited = new boolean[graph.vertex];
		boolean hasPathAToF = std.hasSimplePath(graph, 0, 5, visited);
		System.out.println("There is a path from A to F: " + hasPathAToF);
		visited = new boolean[graph.vertex];
		boolean hasPathAToD = std.hasSimplePath(graph, 0, 3, visited);
		System.out.println("There is a path from A to D: " + hasPathAToD);
	}
}
