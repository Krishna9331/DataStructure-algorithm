package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 3/11/2017.
 */
public class MinEnergyForBot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
		}
		int e = 0;
		int currHeight = h[n - 1];
		for (int j = n - 1; j >= 0; j--) {
			int d = (e + h[j]);
			e = d/2 + d%2;
		}
		System.out.println(e);
	}
}
