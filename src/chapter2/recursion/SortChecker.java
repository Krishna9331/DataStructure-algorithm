package chapter2.recursion;

/**
 * Created by mishrk3 on 4/4/2016.
 */
public class SortChecker {
    public boolean isSorted(int[] numbers) {
        return check(numbers, 0, 1);
    }

    private boolean check(int[] numbers, int startIndex, int nextIndex) {
        int low = numbers[startIndex];
        int high = numbers[nextIndex];
        if (low > high) return false;
        else if (nextIndex < numbers.length - 1) {
            return check(numbers, nextIndex, nextIndex + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        SortChecker sc = new SortChecker();
        int[] as = {1, 4, 7, 9};
        if (sc.isSorted(as)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Not sorted");
        }

    }
}
