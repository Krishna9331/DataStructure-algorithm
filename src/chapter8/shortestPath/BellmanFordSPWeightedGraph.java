package chapter8.shortestPath;

import chapter5.LinkedListQueue;
import chapter8.Graph;
import chapter8.GraphUsingList;

import static chapter8.GraphUsingList.ListNode;

/**
 * Created by mishrk3 on 2/7/2017.
 */
public class BellmanFordSPWeightedGraph {

	/**
	 * @param graph       graph using adjacency list
	 * @param source      source vertex
	 * @param vertexValue the array containing the vertex name
	 */
	public void bellmanFord(GraphUsingList graph, int source, String[] vertexValue) {
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		queue.enQueue(source);
		String[] path = new String[graph.vertex];
		int[] distance = new int[graph.vertex];
		for (int i = 0; i < graph.vertex; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[source] = 0;
		path[source] = vertexValue[source];
		while (!queue.isEmpty()) {
			int curr = queue.deQueue();
			ListNode currVertex = graph.adjacent[curr];
			currVertex.visited = true;
			ListNode temp = currVertex;
			while (temp.next.vertexNumber != currVertex.vertexNumber) {
				ListNode w = temp.next;
				int d = distance[currVertex.vertexNumber] + w.weight;
				if (d < distance[w.vertexNumber]) {
					distance[w.vertexNumber] = d;
					path[w.vertexNumber] = path[temp.vertexNumber] + "-->" + vertexValue[w.vertexNumber];
					if (!w.visited) {
						queue.enQueue(w.vertexNumber);
					}
				}
				temp = w;
			}
		}

		for (int i = 0; i < graph.vertex; i++) {
			System.out.println("Distance of " + vertexValue[i] + " from " + vertexValue[source] + " is: " + distance[i]
					+ " and path is: " + path[i]);
		}
	}

	public static void main(String[] args) {
		GraphUsingList graph = new GraphUsingList(3, 3);
		BellmanFordSPWeightedGraph blmn = new BellmanFordSPWeightedGraph();
		String[] arr = new String[3];
		arr[0] = "A";
		arr[1] = "B";
		arr[2] = "C";
		blmn.bellmanFord(graph, 0, arr);
	}
}
