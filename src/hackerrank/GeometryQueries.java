package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 12/30/2016.
 * <pre>
 *     There are N lines. Each line has an index between 1 and N. The slope of each line is negative, i.e. it goes from upper-left to lower-right.

 There are Q queries. Each of them is in the format L R x y, and you should output whether there is any line with index between L and R and the point (x, y) is under it. If there is, then the answer is YES, otherwise NO.

 As you know, any line splits an infinite plane into two regions. The point (x, y) is under the line if that point is at the same region with point (-infinity, +infinity). If the point lies on the line it does not count.

 Input Format
 The first line contains N, the number of lines. The following N lines each contains two integers m and n that describes the line mx + n = y.

 The next line contains Q, the number of queries. Each subsequent line contains 4 integers L, R, x, y.

 Output Format
 For each query, output one line containing either YES or NO.

 Constraints

 Sample Input

 2
 -1 3
 -2 -4
 3
 1 2 0 0
 1 1 0 0
 2 2 0 0
 Sample Output

 YES
 YES
 NO
 * </pre>
 */
public class GeometryQueries {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Geometry[] gm = new Geometry[n];
		for (int i = 0; i < n; i++) {
			Geometry g = new Geometry(sc.nextInt(), sc.nextInt());
			gm[i] = g;
		}
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (Geometry g : gm) {
				if ((l >= g.m && r <= g.n) && (g.m * x + g.n == y)) {
					System.out.println("YES");
					break;
				}
			}
		}
	}

	public static class Geometry {
		int m;
		int n;

		public Geometry(int m, int n) {
			this.m = m;
			this.n = n;
		}
	}
}
