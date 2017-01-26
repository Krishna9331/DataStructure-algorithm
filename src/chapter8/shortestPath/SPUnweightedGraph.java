package chapter8.shortestPath;

import chapter5.LinkedListQueue;
import chapter8.GraphUsingList;
import static chapter8.GraphUsingList.ListNode;

/**
 * Created by mishrk3 on 1/10/2017. <pre>
 *       c -> A  -> B ->E -> G
 *       A -> D
 *       B -> D
 *       c -> F
 *       D -> F
 *       D -> G
 *       G -> F
 * </pre>
 */
public class SPUnweightedGraph {

	public void shortestPath(GraphUsingList graph, int p, String[] val) {
		int v = p;
		int[] distance = new int[graph.vertex];
		String[] path = new String[graph.vertex];
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		for (int i = 0; i < graph.vertex; i++) {
			distance[i] = -1;
		}
		distance[v] = 0;
		path[v] = "" + val[v];
		queue.enQueue(v);
		while (!queue.isEmpty()) {
			v = queue.deQueue();
			ListNode node = graph.adjacent[v];
			while (node.next.vertexNumber != v) {
				int n = node.next.vertexNumber;
				if (distance[n] == -1) {
					distance[n] = distance[v] + 1;
					path[n] = path[v] + "-> " + val[n];
					queue.enQueue(n);
				}
				node = node.next;
			}
		}
		for (int i = 0; i < graph.vertex; i++) {
			System.out.println(
					"Distance of " + val[i] + " from " + val[p] + " is: " + distance[i] + " and path is: " + path[i]);
		}
	}

	public static void main(String[] args) {
		GraphUsingList graph = new GraphUsingList(7, 10);
		SPUnweightedGraph sp = new SPUnweightedGraph();
		String[] val = new String[graph.vertex];
		val[0] = "A";
		val[1] = "B";
		val[2] = "C";
		val[3] = "D";
		val[4] = "E";
		val[5] = "F";
		val[6] = "G";
		sp.shortestPath(graph, 2, val);
	}
}
