package hackerrank;

import java.util.Scanner;

/**
 * Created by mishrk3 on 12/16/2016. <pre>
 *
 *     Create a list, , of  empty sequences, where each sequence is indexed from  to . The elements within each of the  sequences also use -indexing.
 Create an integer, , and initialize it to .
 The  types of queries that can be performed on your list of sequences () are described below:
 Query: 1 x y
 Find the sequence, , at index  in ((x ^ lastAnswer)%N) in seqList.
 Append integer  to sequence .
 Query: 2 x y
 Find the sequence, , at index  in ((x ^ lastAnswer)%N) in seqList.
 Find the value of element  in  y%size(where  is the size of seq) and assign it to lastAnswer.
 Print the new value of lastAnswer on a new line
 Task
 Given N, Q, and Q  queries, execute each query.

 Note:  is the bitwise XOR operation, which corresponds to the ^ operator in most languages. Learn more about it on Wikipedia.

 Input Format

 The first line contains two space-separated integers,  (the number of sequences) and  (the number of queries), respectively.
 Each of the  subsequent lines contains a query in the format defined above.

 Constraints

 It is guaranteed that query type  will never query an empty sequence or index.
 Output Format

 For each type  query, print the updated value of  on a new line.

 Sample Input

 2 5
 1 0 5
 1 1 7
 1 0 3
 2 1 0
 2 1 1
 Sample Output

 7
 3
 Explanation

 Initial Values:
	N = 2
 lastAnswer=0
 S0 = {}
 s1 = {}



 Query 0: Append  to sequence ((0 ^ 0)% 2) = 0.
 S0 = {5}
 s1 = {}


 Query 1: Append  to sequence((1 ^ 0)) .


 Query 2: Append  to sequence .



 Query 3: Assign the value at index  of sequence  to , print .


 7
 Query 4: Assign the value at index  of sequence  to , print .


 3
 * </pre>
 */
public class DynamicArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[][] s = new int[n][];
		int[] count = new int[n];
		int lastAnswer = 0;
		for (int i = 0; i < n; i++) {
			s[i] = new int[n];
		}
		for (int i = 0; i < q; i++) {
			int p = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int r = (x ^ lastAnswer) % n;
			if (p == 1) {
				s[r][count[r]] = y;
				count[r] = count[r] + 1;
			}else{
				int v = y % count[r];
				lastAnswer = s[r][v];
				System.out.println(lastAnswer);
			}
		}
	}
}
