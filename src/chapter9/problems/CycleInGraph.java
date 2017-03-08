package chapter9.problems;

/**
 * Created by mishrk3 on 3/8/2017.
 */

import chapter9.Graph;
import chapter9.GraphUsingMatrix;

/**
 * Write and algorithm to detect if there is cycle in directed graph.<br/>
 * <pre>
 *
 *             0
 *            / \       0 --> 1
 *          /    \      0 -->2
 *        /       \     1--->2
 *       1-------->2
 * Cycle detection for graph is different than tree, this is because in graph a node can have multiple parents.
 * For detection of cycle in tree we can do DFS and if previously visited node comes again then there is cycle.
 * 
 * However same is not true for graph, In the above graph the tree traversal way will mark as graph has cycle as
 * 2 will come for DFS of 0 as well as DFS of 1, but the graph does not have cycle, the reson is the direction of 
 * edge is from 1 to 2.
 * 
 * The logic for finding cycle in graph is if a visited node comes before all it's descendants is visited in DFS, then
 * the graph has cycle. The reason is pretty clear suppose we start from node A and in the cycle of finding DFS of
 * node A if it is reachable from any of it's descendants this means there is a cycle in graph.
 * </pre>
 */
public class CycleInGraph {

	/**
	 * @param graph
	 *            the matrix graph
	 * @param src
	 *            the source node for DFS
	 * @param visited
	 *            the array of visited vertex
	 * @param currStack
	 *            the array with the vertex started the DFS
	 * @return true id graph has cycle <pre>
	 *     * Lets consider below graph:
	 *             0
	 *            / \       0 --> 1
	 *          /    \      1 -->2
	 *        /       \     2--->0
	 *       1-------->2
	 *
	 *  If DFS starts from 0
	 *  First 0 will be marked as visited
	 *  CurrStack for 0 will be marked as true
	 *  it will discover 1 first, since 1 is not yet visited so it call DFS on 1.
	 *  
	 *  Now 1 will be marked as visited.
	 *  Again currStack for 1 will be marked as true along with 0
	 *  then it will discover 2 and since 2 is also not discovered hence it will mark it assign predecessor of 2 as 1,
	 *  and then call DFS on 2.
	 *  
	 *  Now 2 will be marked as visited
	 *  ans the current stack for 2 will be marked as true, so now all the vertex is marked as true.
	 *  and 2 will discover 0 again but this time 0 is already visited, hence it will go and check if currStack for 0, 
	 *  which is true hence it will mark graph has cycle.
	 *
	 *  Lets consider another graph
	 *             0
	 *            / \       0 --> 1
	 *          /    \      2 -->1
	 *        /       \     2--->0
	 *       1<--------2
	 *
	 *  If DFS starts from 0
	 *  First 0 will be marked as visited
	 *  CurrStack for 0 will be marked as true
	 *  it will discover 1 first, since 1 is not yet visited so it call DFS on 1.
	 *
	 *  Now 1 will be marked as visited.
	 *  Again currStack for 1 will be marked as true along with 0
	 *  Since 1 does not has any edge to discover hence loop will end and the value for one in currStack will be marked
	 *  as false and method will return false to it's caller which is DFS of 0. which will force it to go to else block
	 *  and check if currStack for 1 is true, which is not. Now 0 does not has any other vertex to discover hence loop
	 *  will end for 0 and currStack for 0 will also be made as false and return false.
	 *
	 *  But still we have vertex 2 as not visited hence detectCycle will call DFS for 2
	 *  Now 2 will be marked as visited
	 *  currStack for 2 will be true
	 *  2 will discover 0 but that is already visited hence it will check value of currStack for 0 which is false,
	 *  hence loop for 2 will end and currStack for 2 will be marked false and method will return false.
	 *  That indicates graph does not has cycle.
	 *  </pre>
	 */
	public boolean hasCycle(GraphUsingMatrix graph, int src, boolean[] visited, boolean[] currStack) {
		visited[src] = true;
		currStack[src] = true;
		for (int v = 0; v < graph.vertex; v++) {
			if (graph.adjacent[src][v] == 1) {
				if (!visited[v] && hasCycle(graph, v, visited, currStack)) {
					return true;
				} else if (currStack[v]) {
					return true;
				}
			}
		}
		currStack[src] = false;
		return false;
	}

	public boolean detectCycle(GraphUsingMatrix graph) {
		boolean[] currStack = new boolean[graph.vertex];
		boolean[] visited = new boolean[graph.vertex];
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i] && hasCycle(graph, i, visited, currStack)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CycleInGraph cig = new CycleInGraph();

		GraphUsingMatrix graph = new GraphUsingMatrix(3, 3);
		boolean hasCycle = cig.detectCycle(graph);
		/**
		 * Input: <br/>
		 * Enter pair 0: 0 1 Enter pair 1: 1 2 Enter pair 2: 2 0 output is true;
		 */
		System.out.println(hasCycle);
	}
}
