package generalproblem;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mishrk3 on 12/26/2016. <pre>
 *     In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform  operations of the following  types:

 append(W) - Append string W to the end of .
 delete(W) - Delete the last K characters of .
 print(K) - Print the Kth character of .
 undo() - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
 Input Format

 The first line contains an integer,Q, denoting the number of operations.
 Each line i of the Q subsequent lines (where 0<=i<Q) defines an operation to be performed.
 Each operation starts with a single integer,  t(where t in {1, 2, 3, 4]}), denoting a type of operation as defined in the Problem Statement above.
 If the operation requires an argument,  is followed by its space-separated argument. For example, if t=1 and W=abcd, line  will be 1 abcd.

 Constraints

 The sum of the lengths of all  in the input .
 All input characters are lowercase English letters.
 It is guaranteed that the sequence of operations given as input is possible to perform.
 Output Format

 Each operation of type  must print the  character on a new line.

 Sample Input

 8
 1 abc
 3 3
 2 3
 1 xy
 3 2
 4
 4
 3 1
 Sample Output

 c
 y
 a
 Explanation

 Initially, S is empty. The following sequence of 8 operations are described below:

 .S="" We append abc to , so S="abc".
 Print the 3rd character on a new line. Currently, the 3rd character is c.
 Delete the last 3 characters in S (abc), so S="".
 Append "xy" to S, so S="xy.
 Print the 2nd character on a new line. Currently, the 2nd character is y.
 Undo the last update to , making  empty again (i.e., S="").
 Undo the next to last update to  S(the deletion of the last  characters), making S="abc".
 Print the 1st character on a new line. Currently, the 1st character is a.
 *
 * </pre>
 */
public class TextEditor {
	private static Stack<Event> eventStack = new Stack<>();
	private static String s = "";

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int opr = sc.nextInt();
			String opd = null;
			if (opr != 4) {
				opd = sc.next();
			}
			Event ev = new Event(opr, opd);
			doOperation(ev);
		}
	}

	private static void doOperation(Event ev) {
		if (ev.operation == 1) {
			s = s + ev.operand;
			eventStack.push(ev);
		} else if (ev.operation == 2) {
			int op = Integer.parseInt(ev.operand);
			String st = s.substring(s.length() - op, s.length());
			ev.operand = st;
			s = s.substring(0, s.length() - op);
			eventStack.push(ev);
		} else if (ev.operation == 4) {
			undo();
		} else {
			int pos = Integer.parseInt(ev.operand);
			System.out.println(s.charAt(pos - 1));
		}
	}

	private static void undo() {
		Event ev = eventStack.pop();
		if (ev.operation == 1) {
			int len = ev.operand.length();
			s = s.substring(0, s.length() - len);
		} else if (ev.operation == 2) {
			s = s + ev.operand;
		} else {
			undo();
		}
	}

	public static class Event {
		int operation;
		String operand;

		public Event(int operation, String operand) {
			this.operation = operation;
			this.operand = operand;
		}
	}
}
