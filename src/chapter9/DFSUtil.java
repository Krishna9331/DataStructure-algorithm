package chapter9;

/**
 * Created by mishrk3 on 12/6/2016.
 */
public class DFSUtil {

	public void doDFSMatrix(GraphUsingMatrix graph, int u, boolean[] visited) {
		visited[u] = true;
		System.out.printf("->" + u);
		print(visited);
		for (int v = 0; v < graph.vertex; v++) {
			if (!visited[v] && graph.adjacent[u][v] == 1) {
				doDFSMatrix(graph, v, visited);
			}
		}
	}

	public void doDFSList(GraphUsingList graph, int u, boolean[] visited) {
		visited[u] = true;
		System.out.printf("->" + u);
		print(visited);
		while (graph.adjacent[u].next.vertexNumber != u) {
			int n = graph.adjacent[u].next.vertexNumber;
			if (!visited[n]) {
				doDFSList(graph, n, visited);
			}
			u = graph.adjacent[u].next.vertexNumber;
		}
	}

	private void print(boolean[] visited) {
		for (boolean b : visited) {
			System.out.printf(" " + b);
		}
		System.out.println();
	}

	void dfsTraversal(Graph graph) {
		boolean[] visited = new boolean[graph.vertex];
		for (int i = 0; i < graph.vertex; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i]) {
				if (graph instanceof GraphUsingMatrix) {
					doDFSMatrix((GraphUsingMatrix) graph, i, visited);
				} else {
					doDFSList((GraphUsingList) graph, i, visited);
				}
			}
		}
	}

	public static void main(String[] args) {
		DFSUtil dfs = new DFSUtil();
		GraphUsingMatrix graphUsingMatrix = new GraphUsingMatrix(8, 8);
		GraphUsingList graphUsingList = new GraphUsingList(8, 8);
		System.out.println("DFS Traversal starting for Matrix Graph...");
		dfs.dfsTraversal(graphUsingMatrix);
		System.out.println("DFS Traversal starting for List Graph...");
		dfs.dfsTraversal(graphUsingList);
	}
}
