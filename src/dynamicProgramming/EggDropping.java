package dynamicProgramming;

/**
 * Created by mishrk3 on 7/28/2016.
 */

/**
 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from,
 * and which will cause the eggs to break on landing.
 * <p>
 * …..An egg that survives a fall can be used again.
 * …..A broken egg must be discarded.
 * …..The effect of a fall is the same for all eggs.
 * …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 * …..If an egg survives a fall then it would survive a shorter fall.
 * …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
 */
public class EggDropping {

    /**
     * When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
     * <p>
     * 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
     * 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.
     * <p>
     * Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
     * <p>
     * k ==> Number of floors
     * n ==> Number of Eggs
     * eggDrop(n, k) ==> Minimum number of trails needed to find the critical
     * floor in worst case.
     * eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
     * x in {1, 2, ..., k}}
     */

    public int eggDrop(int eggs, int floors) {
        int[][] eggFloor = new int[eggs + 1][floors + 1];
        return 1;
    }

}
