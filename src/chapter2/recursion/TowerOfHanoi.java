package chapter2.recursion;

/**
 * Created by mishrk3 on 4/4/2016.
 */
public class TowerOfHanoi {
    void toh(int n, char from, char to, char via) {
        if (n == 1) {
            System.out.println("Move disk 1 from: " + from + " to: " + to);
            return;
        } else {
            toh(n - 1, from, via, to);
            System.out.println("Move disk: " + n + " from: " + from + " to: " + to);
            toh(n - 1, via, to, from);
        }
    }

    public static void main(String[] args) {
        TowerOfHanoi th = new TowerOfHanoi();
        th.toh(5, 'A', 'B', 'C');
    }
}
