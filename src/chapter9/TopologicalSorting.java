package chapter9;

import chapter5.LinkedListQueue;

import static chapter9.GraphUsingList.ListNode;

/**
 * Created by mishrk3 on 1/6/2017.
 */
public class TopologicalSorting {

	public void topologicalSort(Graph graph) {

	}

	public static void main(String[] args) {
		GraphUsingList graph = new GraphUsingList(8, 9);
		doTopologicalSorting(graph);
	}

	private static void doTopologicalSorting(GraphUsingList graph) {
		int[] inDegree = new int[graph.vertex];
		int[] topologicalOrder = new int[graph.vertex];
		int counter = 0;
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		for (ListNode node : graph.adjacent) {
			ListNode q = node.next;
			while (q != node) {
					inDegree[q.vertexNumber] += 1;
				q = q.next;
			}
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.enQueue(i);
			}
		}
		int p = 0;
		while (!queue.isEmpty()) {
			p = queue.deQueue();
			topologicalOrder[counter++] = p;
			ListNode q = graph.adjacent[p];
			q = q.next;
			while (q != graph.adjacent[p]) {
				if (--inDegree[q.vertexNumber] == 0) {
					queue.enQueue(q.vertexNumber);
				}
				q = q.next;
			}
		}
		if (counter != graph.vertex) {
			System.out.println("Graph has cycle");
		} else {
			for (int i : topologicalOrder) {
				System.out.printf(i + " ");
			}
		}
	}

}
