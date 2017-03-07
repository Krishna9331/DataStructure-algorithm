package chapter9.problems;

/**
 * Created by mishrk3 on 3/1/2017.
 */

import chapter4.LinkedListStack;
import chapter9.GraphUsingMatrix;

/**
 * <pre>
 *In a directed graph two vertices u and v are called strongly connected if and only if there exists path from u to v and
 * there is path from v to u.
 * 1) A vertex is strongly connected to itself.
 * 2) If a vertex u is strongly connected to vertex v then vice versa is also true.
 * 3) If a vertex u is strongly connected to v and v is strongly connected to x then u is strongly connected to x.
 *
 * 			1------>0--------->	3
 * 			^     /				|
 * 		    |   /				| it is 3 -> 4
 * 		    | /  				|
 * 		    2  					4
 *
 * 		    here 1 ->0, 0 -> 2 and 2 -> 1 is strongly connected, However 0 -> 3 is not.
 *
 *  In the above graph if we start the DFS from 0, 1 or 2 we will get a single tree, However doing so from 3t  o4 will 
 *  be a forest as graph can not traversed to all nodes starting from 3 or 4.
 *
 *  if we do a DFS of graph and store vertices according to their finish times, we make sure that the finish time of a
 *  vertex that connects to other SCCs (other that its own SCC), will always be greater than finish time of vertices in
 *  the other SCC(proof at http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/strongComponent.htm).
 *  For example, in DFS of above example graph, finish time of 0 is always greater
 *  than 3 and 4 (irrespective of the sequence of vertices considered for DFS). And finish time of 3 is always greater
 *  than 4. DFS doesn’t guarantee about other vertices, for example finish times of 1 and 2 may be smaller or greater
 *  than 3 and 4 depending upon the sequence of vertices considered for DFS. So to use this property, we do DFS
 *  traversal of complete graph and push every finished vertex to a stack. In stack, 3 always appears after 4, and 0
 *  appear after both 3 and 4.
 *
 *
 * 		  A----->B
 *		  | \    |  A -> B
 *		  |  \   |  B -> C
 *		  |   \  |  C -> D
 *		  |    \ |  A -> D
 *		  D<-----C  C -> A
 *
 *
 * </pre>
 */
public class StronglyConnectedComponent {
	private int counter = 0;

	public void findSCCs(GraphUsingMatrix graph, int src, int[] low, int[] dfsNum, boolean[] visited,
			LinkedListStack<Integer> stack, int[] table) {
		low[src] = dfsNum[src] = ++counter;
		visited[src] = true;
		stack.push(src);
		for (int v = 0; v < graph.vertex; v++) {
			if (graph.adjacent[src][v] == 1 && table[v] == -1) {
				if (dfsNum[v] == -1) {
					findSCCs(graph, v, low, dfsNum, visited, stack, table);
				}
				low[src] = Math.min(low[src], low[v]);
			}
		}
		if (low[src] == dfsNum[src]) {
			while (table[src] != counter) {
				table[stack.pop()] = counter;
			}
			++counter;
		}
	}

	public void printSCCs(GraphUsingMatrix graph) {
		int[] low = new int[graph.vertex];
		int[] dfsNum = new int[graph.vertex];
		boolean[] visited = new boolean[graph.vertex];
		int[] table = new int[graph.vertex];
		LinkedListStack<Integer> stack = new LinkedListStack<>();

		for (int i = 0; i < graph.vertex; i++) {
			dfsNum[i] = -1;
			table[i] = -1;
		}
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i]) {
				findSCCs(graph, 0, low, dfsNum, visited, stack, table);
			}
		}

		for (int i = 0; i < table.length; i++) {
			System.out.println(String.format("The vertex %s falls in group %s", i, table[i]));
		}
	}

	public static void main(String[] args) {
		StronglyConnectedComponent scc = new StronglyConnectedComponent();

		GraphUsingMatrix graph = new GraphUsingMatrix(5, 5);
		scc.printSCCs(graph);

		System.out.println();
		GraphUsingMatrix graph1 = new GraphUsingMatrix(4, 5);
		scc.printSCCs(graph1);
	}
}
