package chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mishrk3 on 11/18/2016.
 */
public class GraphUsingList extends Graph {

	public ListNode[] adjacent; // contains head pointer to linked list
	public Edge[] edges; // for kruskal algo

	public static class Edge implements Comparable<Edge> {
		public int src;
		public int dest;
		public int weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge edge) {
			return this.weight - edge.weight;
		}
	}

	public static class ListNode implements Comparable<ListNode> {
		public int vertexNumber;
		public ListNode next;
		public int weight;
		public boolean visited; // used in bellmanford algo

		public ListNode(int vertexNumber, ListNode next) {
			this.vertexNumber = vertexNumber;
			this.next = next;
			this.weight = 1;
			this.visited = false;
		}

		@Override
		public int compareTo(ListNode node) {
			return this.weight - node.weight;
		}
	}

	public GraphUsingList(int vertex, int edge) {
		this.vertex = vertex;
		this.edge = edge;
		adjacent = new ListNode[vertex];
		this.edges = new Edge[edge];
		for (int i = 0; i < vertex; i++) {
			adjacent[i] = new ListNode(i, null);
			adjacent[i].next = adjacent[i];
		}
		System.out.println("Creating graph please enter " + edge + " connecting vertex pair separated by space...");
		System.out.println("The below entries are invalid");
		System.out.println("pair already connected");
		System.out.println("pair more then vertex size");
		System.out.println("invalid pair(other than integer)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < edge; i++) {
			try {
				System.out.println("Enter pair " + i + ":");
				String[] st = br.readLine().split(" ");
				int x = Integer.parseInt(st[0]);
				int y = Integer.parseInt(st[1]);
				if (x >= vertex || y >= vertex) {
					throw new IOException();
				}
				int w = 1;
				if (st.length > 2) {
					w = Integer.parseInt(st[2]);
				}
				Edge e = new Edge(x, y, w);
				edges[i] = e;
				ListNode temp = new ListNode(y, null);
				temp.weight = w;
				ListNode q = adjacent[x];
				temp.next = adjacent[x];
				while (q.next != adjacent[x]) {
					q = q.next;
				}
				q.next = temp;

			} catch (IOException | IndexOutOfBoundsException ex) {
				System.out.println("Exception occurred please re enter the pair...");
				i--;
			}
		}
	}

	public static void main(String[] args) {
		GraphUsingList graph = new GraphUsingList(4, 5);
		System.out.println("Graph is created, displaying graph...");
		graph.displayGraph();
	}

	public void displayGraph() {
		for (ListNode list : adjacent) {
			ListNode q = list;
			do {
				System.out.printf(q.vertexNumber + "->");
				q = q.next;
			} while (q.next != list);
			System.out.printf(q.vertexNumber + "");
			System.out.println();
		}
	}
}
