package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mishrk3 on 12/21/2016.
 *
 * You have an empty sequence, and you will be given  queries. Each query is one of these three types:

 1 x  -Push the element x into the stack.
 2    -Delete the element present at the top of the stack.
 3    -Print the maximum element in the stack.
 Input Format

 The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)

 Constraints



 Output Format

 For each type  query, print the maximum element in the stack on a new line.

 Sample Input

 10
 1 97
 2
 1 20
 2
 1 26
 1 20
 2
 3
 1 91
 3
 Sample Output

 26
 91
 */
public class MaxElementInStack {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Stack<Integer> sc = new Stack();
		Stack<Integer> sc1 = new Stack();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int i = 0; i < n; i++){
			int cmd = scn.nextInt();

			if(cmd == 1){
				int data = scn.nextInt();
				sc.push(data);
				if(sc1.empty() || sc1.peek() <= data){
					sc1.push(data);
				}
			}else if(cmd == 2){
				int d = sc.pop();
				if(sc1.peek() == d){
					sc1.pop();
				}
			}else{
				System.out.println(sc1.peek());
			}
		}
	}
}
