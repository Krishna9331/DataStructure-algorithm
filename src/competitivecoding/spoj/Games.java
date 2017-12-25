package competitivecoding.spoj;

import java.util.Scanner;

/**
 * Problem Statement:

 A player has played unknown number of games. We know the average score of the player
 (sum of scores in all the games / no. of games). Find the minimum number of games the
 player should have played to achieve that average.

 The player can score any non-negative integer score in a game.

 Input:

 The first line consists of an integer t, the number of test cases.
 Each test case consists of a single Rational Number which represents the average score of the player.


 Output:

 For each test case, find the minimum number of matches the player should have played to achieve that average.

 Input Constraints:

 1 <= t <= 1000
 1 <= avg <= 1000000 (maximum 4 digits after the decimal place)

 Example:

 Sample Input:
 3
 5
 5.5
 30.25

 Sample Output:
 1
 2
 4
 */
public class Games {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String avg = sc.next();
            findAndPrintMinimumNumOfGames(avg);
        }

    }

    private static void findAndPrintMinimumNumOfGames(String avg) {
        int idx = avg.indexOf('.');
        int l = avg.length();
        if (idx < 0) {
            System.out.println("1");
        } else {
            int val = (int) Math.pow(10, l - idx - 1);
            String c = avg.substring(0, idx) + avg.substring(idx + 1, l);
            int p = Integer.parseInt(c);
            int n = val / gcd(p, val);
            System.out.println(n);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
