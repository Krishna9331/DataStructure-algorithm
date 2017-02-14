package chapter9.minspanningtree;

import java.util.Arrays;
import java.util.PriorityQueue;

import chapter8.DisjointSetFastUnion;
import chapter9.GraphUsingList;
import chapter9.GraphUsingList.Edge;

/**
 * Created by mishrk3 on 2/9/2017.
 */
/**
 * <pre>
 *          4
 *     A -----------> B
 *     |            /   \
 *     |1         /      \ 4
 *     |        /         \
 *     |      /  2         E
 *     |    /             /
 *     |  /              /4
 *     |/      4        /
 *     C-------------->D
 * </pre>
 */
public class KruskalAlgo {

	public void findMinSpanningTree(GraphUsingList graph, String[] val) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (Edge e : graph.edges) {
			pq.add(e);
		}
		int[] vertexSet = new int[graph.vertex];
		Edge[] edges = new Edge[graph.vertex - 1];
		DisjointSetFastUnion set = new DisjointSetFastUnion();
		set.makeSet(vertexSet, graph.vertex);
		int numOfEdge = 0;
		while (!pq.isEmpty() && numOfEdge < graph.vertex - 1) {
			Edge edge = pq.poll();
			if (set.find(vertexSet, edge.src) != set.find(vertexSet, edge.dest)) {
				edges[numOfEdge++] = edge;
			}
		}
		Arrays.stream(edges).forEach(e -> System.out.println(e.src + "-->" + e.dest));
		System.out.println("Representation in terms of value.................");
		Arrays.stream(edges).forEach(e -> System.out.println(val[e.src] + "-->" + val[e.dest]));
	}

	public static void main(String[] args) {
		KruskalAlgo ks = new KruskalAlgo();
		GraphUsingList list = new GraphUsingList(5, 6);
		String[] val = new String[5];
		val[0] = "A";
		val[1] = "B";
		val[2] = "C";
		val[3] = "D";
		val[4] = "E";
		ks.findMinSpanningTree(list, val);
	}

}
