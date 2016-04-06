package chapter2.recursion;

/**
 * Created by mishrk3 on 4/4/2016.
 */
public class Factorial {

    public int fact(int n) {
        return go(n, 1);
    }

    //tail recursion
    private int go(int n, int acc) {
        if (n <= 0) {
            return acc;
        }
        return go(n - 1, n * acc);
    }

}
