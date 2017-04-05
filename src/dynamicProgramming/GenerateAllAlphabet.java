package dynamicProgramming;

/**
 * Created by mishrk3 on 4/5/2017.
 */

/**
 * <pre>
 * If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings.

	 For example:
	 Input: "1123". You need to general all valid alphabet codes from this string.

	 Output List
	 aabc //a = 1, a = 1, b = 2, c = 3
	 kbc // since k is 11, b = 2, c= 3
	 alc // a = 1, l = 12, c = 3
	 aaw // a= 1, a =1, w= 23
	 kw // k = 11, w = 23
 </pre>
 */
public class GenerateAllAlphabet {

	private static int ans = 0;

	public static int DP(int[] a, int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (i > 1 && a[i - 2] <= 2 && a[i - 1] <= 6) {
				dp[i] = dp[i - 1] + dp[i - 2] + 1;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[n] + 1; // +1 for base case where all characters are made of single digits
	}

	public static int print(int[] a, int i, int n, String s) {
		if (i == n) {
			ans++;
			System.out.println(s);
			return 0;
		}

		if (i < n - 1 && a[i + 1] <= 6 && a[i] <= 2) {
			print(a, i + 2, n, new String(s + (char) (a[i] * 10 + a[i + 1] + 'a' - 1)));
		}
		print(a, i + 1, n, new String(s + (char) (a[i] + 'a' - 1)));
		return ans;
	}

	public static void main(String[] args) {
		GenerateAllAlphabet gaa = new GenerateAllAlphabet();
		int [] a = {
		1, 1, 2, 3
		};
		int result = DP(a, 4);
		System.out.println(result);
		int result1 = print(a, 0, 4, "");
		System.out.println(result1);
	}
}
