package addInfinitumContest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mishrk3 on 1/2/2017.
 */
public class CoPrimeArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			for(int i = 1; i<=m; i++){
				if(m%i == 0){
					list.add(i);
				}
			}
			for(int i : list){
				int [] arr = new int[n];
				int count = 0;
				arr[count] = i;
				int j = 0;
				while (count < n-1){
					if(gcd(arr[count], list.get(j)) == 1){
						count++;
						arr[count] = j;
					}
					j++;
				}
			}
		}
	}
	private static int gcd(int a, int b) {
		if (a == b)
			return a;

		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}
}
