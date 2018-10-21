package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * <pre>
 *
 * Lilah has a string,S , of lowercase English letters that she repeated infinitely many times.
 *
 * Given an integer,n , find and print the number of letter a's in the first n letters of Lilah's infinite string.
 *
 * For example, S = abcac if n =10 the string  and , the substring we consider is abcacabcac,
 * the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.
 *
 * ##Function Description
 *
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 *
 * repeatedString has the following parameter(s):
 *
 * s: a string to repeat
 * n: the number of characters to consider
 * Input Format
 *
 * The first line contains a single string, s.
 * The second line contains an integer, n.
 * </pre>
 * <p>
 * Constraints
 * 1 < |s| < 100
 * 1 <= n <= 10^12
 * <p>
 * For 25% of the test cases, n <= 10^6.
 */

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long count = 0;
        int len = s.length();
        long q = n/len;
        long r = n % len;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == 'a') {
                count++;
            }
        }
        count = count * q;
        for(int i = 0; i< r; i++) {
            if(s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);
        scanner.close();
    }

}
