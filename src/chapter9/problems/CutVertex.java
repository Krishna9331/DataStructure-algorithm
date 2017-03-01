package chapter9.problems;

/**
 * Created by mishrk3 on 2/28/2017.
 */

import chapter9.GraphUsingMatrix;

/**
 * <pre>
 * The cut vertex is also known as Articulation point.
 * 
 * In an undirected graph, a vertex is called cut vertex if removing that vertex and all connected edge to that edge the 
 * graph gets divided into more than one graph.
 *
 *         C---------D----------F
 *       / |         | \      /
 *     /   |         |  \   /
 *   G     B - - - - A    E
 *
 *   In the above graph D and C is cut vertex
 *   removing D -> {E, F} and {A, B, C, G}
 *   removing C -> {E, F} and {A, B, C, G}
 *
 *   A graph is called bi-connected if the graph is connected after removing any vertex.
 *   
 * Logic for below calculation is done using DFS which gives O(V+E) solution for this problem.
 * We maintain two array dfsNum which contains the order in which a particular vertex is traversed.
 * and low where low[v] keeps contains lowest number of vertex that is reachable from v by taking zero or more
 * tree edge and then possibly one back edge(in that order).
 * low[u] = min(disc[u], disc[w]) 
 * where w is an ancestor of u and there is a back edge from
 * some descendant of u to w.
 * DFS tree, a vertex u is articulation point if one of the following two conditions is true.
 * 		1) u is root of DFS tree and it has at least two children.
 * 		2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge
 * 		   to one of the ancestors (in DFS tree) of u. which is if  low[v] > dfsNum[u].
 * </pre>
 */
public class CutVertex {

	private int num = 0;

	public void cutVertex(GraphUsingMatrix graph, int src, int[] low, int[] dfsNum, int[] parent, boolean[] visited) {
		visited[src] = true;
		int children = 0;
		low[src] = dfsNum[src] = ++num;
		for (int v = 0; v < graph.vertex; v++) {
			if (graph.adjacent[src][v] == 1) {
				if (!visited[v]) {
					children++;
					parent[v] = src;
					cutVertex(graph, v, low, dfsNum, parent, visited);
					// Check if the subtree rooted with v has a connection to
					// one of the ancestors of source
					low[src] = Math.min(low[src], low[v]);
					// if it is root
					if (parent[src] == Integer.MIN_VALUE && children > 1) {
						System.out.println("Articulation point: " + src);
					}
					// If it is not root and low value of one of its child
					// is more than discovery value of source.
					if (parent[src] != Integer.MIN_VALUE && low[v] >= dfsNum[src]) {
						System.out.println("Articulation point: " + src);
					}
				} else if (v != parent[src]) {
					// Update low value of source for parent function calls
					low[src] = Math.min(low[src], dfsNum[v]);
				}
			}
		}
	}

	public void printCutVertex(GraphUsingMatrix graph, int src) {
		int[] low = new int[graph.vertex];
		int[] dfsNum = new int[graph.vertex];
		int[] parent = new int[graph.vertex];
		boolean[] visited = new boolean[graph.vertex];
		for (int i = 0; i < graph.vertex; i++) {
			dfsNum[i] = -1;
			parent[i] = Integer.MIN_VALUE;
		}
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i])
				cutVertex(graph, src, low, dfsNum, parent, visited);
		}
	}

	public static void main(String[] args) {
		GraphUsingMatrix graph = new GraphUsingMatrix(7, 8);
		CutVertex cv = new CutVertex();
		cv.printCutVertex(graph, 0);
		System.out.println("Operation finished...");
	}
}
