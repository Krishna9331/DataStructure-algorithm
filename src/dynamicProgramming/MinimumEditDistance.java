package dynamicProgramming;

import java.util.Arrays;

import static java.lang.Math.min;

/**
 * <pre>
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Delete
 * Replace
 * All of the above operations are of equal cost.Given two strings str1 and str2 and below operations that
 * can performed on str1. e.g abcdef -> azced
 * To convert abcdef to azced we need 3 opration as below:
 *  1. At index 1 convert b to z
 *  2. delete index 3
 *  3. at index 5 convert f to d.
 *  We will use dynamic programming for it and the formula to identify table will be:
 *  <code>
 *      if(str1[i] == str2[j] then
 *          table[i][j] = table[i-1][j-1]  //No cost
 *      else
 *          table[i][j] = min( table[i-1][j], // deleting an element
 *                             table[i-1][j-1], // Replacing
 *                             table[i][j-1]    // Inserting
 *                            ) + 1; //Considering cost of all Insert Deleter and Replace is 1.
 *  </code>
 *
 *  The initialization condition for the dynamic programming will be as below
 *  table[i][0] = i  //need i operation to make string of length i to Null (0 length means NULL) by deleting
 *  table[0][j] = j  //Need j operation to make Null to string of length j by inserting
 * </pre>
 */

public class MinimumEditDistance {

    public int minimumEditDistance(final String str1, final String str2) {
        final int n = str1.length();
        final int m = str2.length();
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        final int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //initialization condition from string of length i to null
                table[i][0] = i;
                //initialization condition from null to string of length j
                table[0][j] = j;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //if characters are same no operation required
                if (str1CharArray[j - 1] == str2CharArray[i - 1]) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    //find minimum cost of insert, delete and replace and add 1
                    table[i][j] = min(min(table[i - 1][j], table[i - 1][j - 1]), table[i][j - 1]) + 1;
                }
            }
        }
        printOperation(table, str1CharArray, str2CharArray, str1);
        return table[m][n];
    }

    private void printOperation(int[][] table, char[] str1Array, char[] str2Array, String str1) {
        final int n = str1Array.length;
        final int m = str2Array.length;

        int i = m;
        int j = n;
        int comp = table[i][j];
        int idx = i;
        while (i > 0 && j > 0) {
            //verify if characters are equal
            if (comp == table[i - 1][j - 1] && str1Array[j - 1] == str2Array[i - 1]) {
                comp = table[i - 1][j - 1];
                i--;
                j--;
            }
            //verify if replacement is needed
            else if (comp - 1 == table[i - 1][j - 1]) {
                comp = table[i - 1][j - 1];
                System.out.println("Replace: " + str1Array[j - 1] + " at index: " + (j - 1) + " of: " + str1
                        + " with: " + str2Array[i - 1]);
                i--;
                j--;
            }
            //verify if insertion is needed
            else if (comp - 1 == table[i][j - 1]) {
                comp = table[i][j - 1];
                System.out.println("Delete: " + str1Array[j - 1] + " at index: " + (j - 1) + " of: " + str1);
                j--;
            }
            //verify if deletion is needed
            else if (comp - 1 == table[i - 1][j]) {
                comp = table[i - 1][j];
                System.out.println("Insert: " + str2Array[i - 1] + " at index: " + (i - 1) + " of: " + str1);
                i--;
            }
        }

        if( i > 0) {
            while(i > 0) {
                System.out.println("Insert: " + str2Array[i - 1] + " at index: " + (i - 1) + " of: " + str1);
                i--;
            }
        }

        if( j > 0) {
            while(j > 0) {
                System.out.println("Delete: " + str1Array[j - 1] + " at index: " + (j - 1) + " of: " + str1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        final MinimumEditDistance med = new MinimumEditDistance();
        System.out.println("Minimum Edit distance from converting abcdef to azced is: " +
                med.minimumEditDistance("abcdef", "azced"));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Minimum Edit distance from converting graffe to giraffe is: " +
                med.minimumEditDistance("graffe", "giraffe"));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Minimum Edit distance from converting cat to cati is: " +
                med.minimumEditDistance("cat", "cati"));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Minimum Edit distance from converting llusion to illusion is: " +
                med.minimumEditDistance("llusion", "illusion"));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("Minimum Edit distance from converting illusion to llusion is: " +
                med.minimumEditDistance("illusion", "llusion"));
    }
}
