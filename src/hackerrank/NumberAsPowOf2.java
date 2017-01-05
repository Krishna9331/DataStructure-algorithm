package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 12/27/2016. <pre>
 * Define f(0)=1 and f(n) to be the number of different ways  can be expressed as a sum of integer powers of 2 using each power no more than twice.

 For example, f(10) = 5 since there are five different ways to express 10:

 			1 + 1 + 8
 			1 + 1 + 4 + 4
 			1 + 1 + 2 + 2 + 4
 			2 + 4 + 4
 			2 + 8

 What is f(n) for a given n?

 Input Format

 One integer is given on first line representing n.

 Constraints
 1 <= n <= 10^27

 Output Format

 Print one integer which is the answer to the problem.

 Sample Input 0

 10
 Sample Output 0

 5
 
 Example:
 if m==0 f(m,k)=1;  As per definition as f(0) = 1
 if k<0 f(m,k)=0;   As k is less than 0 so there is no possibility as it should be power as positive integer.
 if k==0 f(m,k)=1;  if k=0 then only one possibility i.e 2^0;
 if m>=power(2,k) f(m,k)=f(m-power(2,k),k)+f(m,k-1);//we can use power(2,k) as one of the numbers or not.
 		Since m is greater than 2^k hence we can break the function recursively to do calculation with
 		f(m - 2^k , k) as m - 2^k can also be bigger than equal to 2^k and f(m, k-1).
 		We can consider it as, either we can include 2^k as one of the number or not.
 		if we include -> f(m-2^k , k) is remaining number to be calculated
 		if we don't include -> f(m, k-1) is the combination for calculation
 		final answer will be sum of above two, hence equation will be:
 		f(m,k)=f(m-power(2,k),k)+f(m,k-1)
 else f(m,k)=f(m,k-1);
 		Since m< 2^k hence we left with only one option that exclude 2^k from combination.
 
 Let's apply the above rule on 6
 g(6)=f(6,2)
 =f(2,2)+f(6,1)
 =f(2,1)+f(4,1)+f(6,0)
 =f(0,1)+f(2,0)+f(2,1)+f(4,0)+1
 =1+1+f(0,1)+f(2,0)+1+1
 =1+1+1+1+1+1
 =6
 </pre>
 */
public class NumberAsPowOf2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 0;
		while (Math.pow(2, i) <= n) {
			i++;
		}
		int count = powerOf2(n, i - 1);
		System.out.println("using recursion: " + count);

		int countDy = powerOf2Dy(n, i - 1);
		System.out.println("Using dynamic programming: " + countDy);

		int[] curr = new int[i];
		int countMax2 = powerOf2WithMaxOccurrence2(n, i - 1);
		System.out.println("Recursion With Max 2 occurrence: " + countMax2);
	}

	private static int powerOf2(int n, int i) {
		if (n == 0 || i == 0) {
			return 1;
		}
		int pow = (int) Math.pow(2, i);
		if (n >= pow) {
			return powerOf2(n - pow, i) + powerOf2(n, i - 1);
		}
		return powerOf2(n, i - 1);
	}

	private static int powerOf2WithMaxOccurrence2(int n, int i) {
		if ((n == 0 || i == 0)) {
			return 1;
		}
		int pow = (int) Math.pow(2, i);
		if (n >= 2*pow) {
			return powerOf2WithMaxOccurrence2(n - 2*pow, i -1 ) + powerOf2WithMaxOccurrence2(n - pow, i) + powerOf2WithMaxOccurrence2(n, i - 1);
		}else if(n > pow){
			return powerOf2WithMaxOccurrence2(n - pow, i) + powerOf2WithMaxOccurrence2(n, i - 1);
		}
		return powerOf2WithMaxOccurrence2(n, i - 1);
	}

	private static int powerOf2Dy(int n, int k) {
		int[][] res = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= k; w++) {
				int p = (int) Math.pow(2, w);
				if (i == 0 || w == 0) {
					res[i][w] = 1;
				} else if (i >= p)
					res[i][w] = res[i - p][w] + res[i][w - 1];
				else
					res[i][w] = res[i][w - 1];
			}
		}

		return res[n][k];
	}
}
