package chapter9.minspanningtree;

import chapter9.GraphUsingList;
import chapter9.GraphUsingList.ListNode;

import java.util.Iterator;
import java.util.PriorityQueue;

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
public class PrimsAlgo {

	/**
	 * @param graph
	 * @param source
	 * @param val
	 * @return path containing min spanning tree
	 */
	public void findMinSpan(GraphUsingList graph, int source, String[] val) {
		int[] distance = new int[graph.vertex];
		String[] path = new String[graph.vertex];
		for (int i = 0; i < graph.vertex; i++) {
			distance[i] = -1;
		}
		distance[source] = 0;
		PriorityQueue<ListNode> pq = new PriorityQueue<>();
		ListNode srcNode = graph.adjacent[source];
		path[source] = val[source];
		pq.add(srcNode);
		while (!pq.isEmpty()) {
			ListNode curr = pq.poll();
			curr = graph.adjacent[curr.vertexNumber];
			ListNode tmp = curr;
			while (tmp.next.vertexNumber != curr.vertexNumber) {
				ListNode w = tmp.next;
				int d = distance[curr.vertexNumber] + w.weight;
				if (distance[w.vertexNumber] == -1) {
					distance[w.vertexNumber] = w.weight;
					pq.add(w);
					path[w.vertexNumber] = val[curr.vertexNumber] + "-->" + val[w.vertexNumber];
				}
				if (distance[w.vertexNumber] > d) {
					distance[w.vertexNumber] = w.weight;
					updatePriority(pq, w, w.weight);
					path[w.vertexNumber] = val[curr.vertexNumber] + "-->" + val[w.vertexNumber];
				}
				tmp = w;
			}
		}
		for (int i = 0; i < graph.vertex; i++) {
			System.out.println(
					"Distance of " + val[i] + " from " + val[source] + " is: " + distance[i] + " and path is: "
							+ path[i]);
		}
	}

	private void updatePriority(PriorityQueue<ListNode> pq, ListNode w, int d) {
		Iterator<ListNode> iterator = pq.iterator();
		while (iterator.hasNext()) {
			ListNode node = iterator.next();
			if (node.vertexNumber == w.vertexNumber) {
				node.weight = d;
				break;
			}
		}
	}

	public static void main(String[] args) {
		PrimsAlgo pa = new PrimsAlgo();
		GraphUsingList list = new GraphUsingList(5, 6);
		String[] val = new String[5];
		val[0] = "A";
		val[1] = "B";
		val[2] = "C";
		val[3] = "D";
		val[4] = "E";
		pa.findMinSpan(list, 0, val);
	}
}
