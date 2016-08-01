package dynamicProgramming;

/**
 * Created by mishrk3 on 7/28/2016.
 */

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * <p>
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * So the output should be 5.
 */
public class CoinChange {

    /**
     * The solution can be divided into set
     * 1)A particular coin say mth is included at least once
     * 2)mth coin is not included
     * hence solution will look like for array of coin S[] with length m and the figure to get n as
     * count(s[], m, n) =  count(s[], m, n-s[m]) + count(s[], m-1, n)
     */
    int count(int[] s, int m, int n) {
        int[][] ls = new int[n + 1][m];

        //if value of n is 0, solution count is 1.i.e do not include any coin
        for (int i = 0; i < m; i++) {
            ls[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i - s[j] >= 0 ? ls[i - s[j]][j] : 0;
                int y = j >= 1 ? ls[i][j - 1] : 0;
                ls[i][j] = x + y;
            }
        }
        return ls[n][m - 1];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int arr[] = {1, 2, 3};
        int n = 4;
        System.out.printf(" %d ", cc.count(arr, 3, n));
    }
}
