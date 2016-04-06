package chapter2.backtracking;

/**
 * Created by mishrk3 on 4/4/2016.
 */
public class StringPermutation {

    /**
     *
     * @param str an empty array
     * @param n size of the string
     * @param k an integer to produce set of number ranging from 0 to k-1 for string generation
     *
     *          The logic for this problem is very similar to BinaryBitString
     *          1)put the 0 at the (n-1)th position and find all the combination of all other digits including 0.
     *          2)repeat same thing for 1 to k-1
     *
     *          The order for this is k^n
     */
    public void generateString(int[] str, int n, int k) {
        if (n < 1) {
            print(str);
        } else {
            for (int j = 0; j < k; j++) {
                str[n - 1] = j;
                generateString(str, n - 1, k);
            }
        }
    }

    private void print(int[] num) {
        for (int i : num) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        int[] as = new int[3];
        sp.generateString(as, as.length, as.length + 2);
    }
}
