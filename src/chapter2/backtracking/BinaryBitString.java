package chapter2.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mishrk3 on 4/4/2016.
 */
public class BinaryBitString {

    List<String> binarybit = new ArrayList<>();

    /**
     * @param numbers an empty array
     * @param n       an integer
     *                This method generates all possible binary number of size n
     *                <p>
     *                The main logic for this code is for getting binary bit of size n follow below steps:
     *                1)get the list of binary bit of size (n-1) say list L1.
     *                2)reverse the list L1 and we name it as L2.
     *                3)modify L1's each element by prefixing 0.
     *                4)modify each element of L2 by prefixing 1.
     *                5)concatenate L1 and L2
     *                <p>
     *                for achieving this we are using recursion as below:
     *                1)replace the last digit as 0 and recursively find the all combination of element of size (n-1)
     *                2)replace the last digit as 1 and recursively find all the combination of element of size (n-1)
     *
     *                The logic has order of 2^n
     */
    void binaryBit(int[] numbers, int n) {
        if (n < 1) {
            binarybit = push(numbers, binarybit);
        } else {
            numbers[n - 1] = 0;
            binaryBit(numbers, n - 1);
            numbers[n - 1] = 1;
            binaryBit(numbers, n - 1);
        }
    }

    private List<String> push(int[] numbers, List<String> bit) {
        String str = "";
        for (int i : numbers) {
            System.out.print(i);
            str += i;
        }
        System.out.println();
        bit.add(str);
        return bit;
    }

    public static void main(String[] args) {
        BinaryBitString bs = new BinaryBitString();
        int[] as = new int[3];
        bs.binaryBit(as, as.length);
    }
}
