package chapter8;

import chapter5.LinkedListQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mishrk3 on 1/6/2017.
 */
public class BFSUtil {

	public static void doBFSMatrix(GraphUsingMatrix graph, int u, boolean[] visited) {
		LinkedListQueue<Integer> q = new LinkedListQueue();
		q.enQueue(u);
		while (!q.isEmpty()) {
			u = q.deQueue();
			System.out.println(u);
			visited[u] = true;
			for (int i = 0; i < graph.vertex; i++) {
				if (graph.adjacent[u][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.enQueue(i);
				}
			}
		}
	}

	public static void doBFSList(GraphUsingList graph, int u, boolean[] visited) {
		LinkedListQueue<Integer> q = new LinkedListQueue();
		q.enQueue(u);
		while (!q.isEmpty()) {
			u = q.deQueue();
			System.out.println(u);
			visited[u] = true;
			GraphUsingList.ListNode node = graph.adjacent[u];
			while (node.next.vertexNumber != u) {
				int n = node.next.vertexNumber;
				if (!visited[n]) {
					visited[n] = true;
					q.enQueue(n);
				}
				node = node.next;
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new GraphUsingMatrix(8, 8);
		Graph graph1 = new GraphUsingList(8, 8);
		System.out.println("Using Matrix--->");
		BFSUtil.doBFSTraversal(graph);
		System.out.println("Using List--->");
		BFSUtil.doBFSTraversal(graph1);
	}

	public static void doBFSTraversal(Graph graph) {
		graph.displayGraph();
		boolean[] visited = new boolean[graph.vertex];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i]) {
				if (graph instanceof GraphUsingMatrix) {
					doBFSMatrix((GraphUsingMatrix) graph, i, visited);
				} else {
					doBFSList((GraphUsingList) graph, i, visited);
				}
			}
		}
	}
}
