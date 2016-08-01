package dynamicProgramming;

/**
 * Created by mishrk3 on 7/28/2016.
 */

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in
 * the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively. Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class ZeroOneKnapsack {

    /**
     * The solution is same as coin change problem:
     * 1)A item can be included
     * 2)It is not included
     * Hence for val[0..n-1] and wt[0..n-1] and knapsack as capacity W, the Solution will look like
     * count(val[], wt[], n, W) = max( val[n-1] + count(val[], wt[], n-1, W-wt[n]),  count(val[], wt[], n-1, W))
     */

    int max(int[] val, int[] weight, int n, int w) {
        int[][] ks = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    ks[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    ks[i][j] = Math.max(val[i - 1] + ks[i - 1][j - weight[i - 1]], ks[i - 1][j]);
                } else {
                    ks[i][j] = ks[i - 1][j];
                }
            }
        }
        return ks[n][w];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack zok = new ZeroOneKnapsack();
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.printf("%d", zok.max(val, wt, 3, W));
    }
}
