package dynamicProgramming;

/**
 * Created by mishrk3 on 7/4/2016.
 */

public class LongestIncreasingSeq {

    static int max_ref;

    /**
     * DYNAMIC PROGRAMMING
     * The longest Increasing sequence is to find the length of longest subsequence of a given sequence such that all
     * element in subsequence is sorted in increasing order. e.g. for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and
     * LIS is {10, 22, 33, 50, 60, 80}.
     * Solution approach: Let arr[0..n-1] be the input array and L(i) be the length of the LIS till index i such that arr[i]
     * is part of LIS and arr[i] is the last element in LIS, then L(i) can be recursively written as.
     * L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there is no such j then L(i) = 1
     */
    static int lis(int[] arr, int n) {
        int[] lis = new int[n];
        int i, j, max = 0;

        //initialize LIS value for for all index
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

		/*
        * calculation of LIS Value:
		* Here we are calculating LIS value for each index starting from second element of array.
		* The below code will have LIS value for each index and if at any index say i the element is greater than the
		* any value of j then the LIST[i] should be increased by 1 as arr[i] the next increasing number in the sequence
		 * of LIS[j]
		*
		* */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        //select the maximum
        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

	/*
    * ------------------------------------BETTER SOLUTION O(nlogn)------------------------------------------------------
	*Step1: If A[i] is smallest among all end
    *candidates of active lists, we will start
    *new active list of length 1.
    *
    *Step2: If A[i] is largest among all end candidates of
    *active lists, we will clone the largest active
    *list, and extend it by A[i].
    *
    * Step3:If A[i] is in between, we will find a list with
    *largest end element that is smaller than A[i].
    *Clone and extend this list by A[i]. We will discard all
    *other lists of same length as that of this modified list.
	*/

    static int ceilIndex(int[] arr, int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (arr[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    static int longestIncreasingSubsequenceLength(int arr[], int size) {
        int[] tailTable = new int[size];
        int len;
        tailTable[0] = arr[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (arr[i] < tailTable[0]) {
                tailTable[0] = arr[i];
            } else if (arr[i] > tailTable[len - 1]) {
                tailTable[len++] = arr[i];
            } else {
                tailTable[ceilIndex(tailTable, -1, len - 1, arr[i])] = arr[i];
            }
        }

        return len;
    }

    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 2};
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n) + "\n");
        System.out.println("Length of lis in O(nlogn) is " + longestIncreasingSubsequenceLength(arr, n) + "\n");
    }
}
