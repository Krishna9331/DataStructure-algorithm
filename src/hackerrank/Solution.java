package hackerrank;

import java.io.BufferedReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int p = 0;
		for(int i = 0; i < t; i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			p = (s + (m-1))%n;
			System.out.println(p);
		}
	}
}

abstract class One{
	public abstract void m1();
}
abstract class Two extends One{
}
