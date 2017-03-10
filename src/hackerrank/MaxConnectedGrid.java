package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 3/7/2017.
 */
public class MaxConnectedGrid {

	private static int max = 0;
	private static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (count > max) {
					max = count;
				}
				if (grid[i][j] == 1 && !visited[i][j]) {
					count = 1;
					doDFS(grid, i, j, n, m, visited);
				}
			}
		}

		System.out.println(max);
	}

	private static boolean isValid(int[][] grid, int row, int col, int n, int m, boolean[][] visited) {
		return (row >= 0 && row < n) && (col >= 0 && col < m) && (grid[row][col] == 1 && !visited[row][col]);
	}

	private static void doDFS(int[][] grid, int row, int col, int n, int m, boolean[][] visited) {
		visited[row][col] = true;
		int rowNbr[] = new int[] {
				-1, -1, -1, 0, 0, 1, 1, 1
		};
		int colNbr[] = new int[] {
				-1, 0, 1, -1, 1, -1, 0, 1
		};

		for (int k = 0; k < 8; k++) {
			if (isValid(grid, row + rowNbr[k], col + colNbr[k], n, m, visited)) {
				count++;
				doDFS(grid, row + rowNbr[k], col + colNbr[k], n, m, visited);
			}
		}
	}
}
