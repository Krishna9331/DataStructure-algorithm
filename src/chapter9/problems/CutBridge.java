package chapter9.problems;

/**
 * Created by mishrk3 on 3/1/2017.
 */

import chapter9.Graph;
import chapter9.GraphUsingList;
import chapter9.GraphUsingMatrix;

/**
 * <pre>
 * The cut bridge is edge by removing which graph splits in more than one graph.
 *
 * In an undirected graph, an edge is called cut edge if it is not part of cycle, which means none of the child of
 * a vertex has back edge to ancestor of that vertex.
 *
 *         C---------D----------F
 *       / |         |          |
 *     /   |         |          |
 *   G     B - - - - A          E
 *   
 *   In the above graph DF, FE and CG are cut bridges. We will be using the similar strategy as cut vertex for this as well.
 *</pre>
 */
public class CutBridge {

	private int num = 0;

	public void cutBridge(GraphUsingMatrix graph, int src, int[] low, int[] dfsNum, int[] parent, boolean[] visited) {

		low[src] = dfsNum[src] = ++num;
		visited[src] = true;

		for (int v = 0; v < graph.vertex; v++) {
			if (graph.adjacent[src][v] == 1) {
				if (!visited[v]) {
					parent[v] = src;
					cutBridge(graph, v, low, dfsNum, parent, visited);
					low[src] = Math.min(low[src], low[v]);

					if (parent[src] != -1 && low[v] > dfsNum[src]) {
						System.out.println(String.format("The cut bridge is: %s --->%s", src, v));
					}
				} else if (v != parent[src]) {
					low[src] = Math.min(low[src], dfsNum[v]);
				}
			}
		}
	}

	public void printCutBridge(GraphUsingMatrix graph) {
		int[] parent = new int[graph.vertex];
		int[] low = new int[graph.vertex];
		int[] dfsNum = new int[graph.vertex];
		boolean[] visited = new boolean[graph.vertex];

		for (int i = 0; i < graph.vertex; i++) {
			parent[i] = -1;
		}
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i]) {
				cutBridge(graph, 0, low, dfsNum, parent, visited);
			}
		}
	}

	public static void main(String[] args) {
		GraphUsingMatrix graph = new GraphUsingMatrix(7, 7);
		CutBridge cb = new CutBridge();
		cb.printCutBridge(graph);
	}
}
