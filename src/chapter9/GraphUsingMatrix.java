package chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mishrk3 on 11/11/2016.
 */
public class GraphUsingMatrix extends Graph {

	public int[][] adjacent;

	public GraphUsingMatrix(int vertex, int edge, int[][] adjacent) {
		this.vertex = vertex;
		this.edge = edge;
		this.adjacent = adjacent;
	}

	public GraphUsingMatrix(int vertex, int edge) {
		this.vertex = vertex;
		this.edge = edge;
		this.adjacent = new int[vertex][vertex];
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
				if (adjacent[x][y] == 1 || x >= vertex || y >= vertex) {
					throw new IOException();
				}
				adjacent[x][y] = 1;
			} catch (IOException | IndexOutOfBoundsException ex) {
				System.out.println("Exception occurred please re enter the pair...");
				i--;
			}
		}
	}

	public void displayGraph() {
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				System.out.print(adjacent[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		GraphUsingMatrix graph = new GraphUsingMatrix(4, 5);
		graph.displayGraph();
	}
}
