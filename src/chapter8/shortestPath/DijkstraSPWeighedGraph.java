package chapter8.shortestPath;

/**
 * Created by mishrk3 on 1/26/2017.
 */

import java.util.PriorityQueue;

import chapter8.GraphUsingList;

import static chapter8.GraphUsingList.ListNode;

/**
 * <pre>
 * 1. It uses greedy method: Always pick the next closest vertex to the source.
 * 2. Uses Priority queue to store unvisited vertices by distance from s.
 * 3. Does not work with negative weights.
 * 
 * Difference between unweighted shortest path and Dijkstra's Algorithm:
 * 
 * 1. To represent weights in adjacency list each vertex contains the weights of the edge(in addition to identifier)
 * 2. Instead of ordinary queue we use Priority queue(distances are prioritised) and vertex with the smallest distance is selected for processing.
 * 3. The distance to a vertex is calculated by by sum of the weights of the edges on the path from the source to that vertex.
 * 4. We update the distances in case the newly computed distance is smaller than old distance which we have already computed.
 * 
 * If Binary heap is used complexity is O(ElogV) and if array is used in priority queue complexity will be O(E + v^2)
 * </pre>
 */
public class DijkstraSPWeighedGraph {

	public void dijkstra(GraphUsingList graph, int s, String[] val) {
		PriorityQueue<ListNode> queue = new PriorityQueue();
		String[] path = new String[graph.vertex];
		int[] distance = new int[graph.vertex];
		ListNode v = graph.adjacent[s];
		ListNode w;
		queue.add(v);
		for (int i = 0; i < graph.vertex; i++) {
			distance[i] = -1;
		}
		distance[v.vertexNumber] = 0;
		v.weight = 0;
		path[v.vertexNumber] = "" + val[v.vertexNumber];
		while (!queue.isEmpty()) {
			v = queue.poll();
			v = graph.adjacent[v.vertexNumber];
			w = v;
			do {
				int d = distance[v.vertexNumber] + w.weight;
				if (distance[w.vertexNumber] == -1) {
					distance[w.vertexNumber] = d;
					path[w.vertexNumber] = path[v.vertexNumber] + "-->" + val[w.vertexNumber];
					queue.add(w);
				}
				if (distance[w.vertexNumber] > d) {
					distance[w.vertexNumber] = d;
					path[w.vertexNumber] = path[v.vertexNumber] + "-->" + val[w.vertexNumber];

				}
				w = w.next;
			} while (w != v);
		}

		for (int i = 0; i < graph.vertex; i++) {
			System.out.println(
					"Distance of " + val[i] + " from " + val[s] + " is: " + distance[i] + " and path is: " + path[i]);
		}
	}

	public static void main(String[] args) {
		DijkstraSPWeighedGraph sp = new DijkstraSPWeighedGraph();
		GraphUsingList list = new GraphUsingList(5, 6);
		String[] val = new String[5];
		val[0] = "A";
		val[1] = "B";
		val[2] = "C";
		val[3] = "D";
		val[4] = "E";
		sp.dijkstra(list, 0, val);
	}

}
