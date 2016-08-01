package dynamicProgramming;

/**
 * Created by mishrk3 on 7/29/2016.
 */
public class LongestDecreasingSequence {

    public int maxDecSeq(int[] arr, int n) {

        int[] dcs = new int[n];
        for (int i = 0; i < n; i++) {
            dcs[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dcs[i] < dcs[j] + 1) {
                    dcs[i] = dcs[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = dcs[i] > max ? dcs[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ele = {45, 22, 9, 33, 21, 50, 11, 60, 2};
        LongestDecreasingSequence lds = new LongestDecreasingSequence();
        System.out.println(lds.maxDecSeq(ele, 9));
    }

}
