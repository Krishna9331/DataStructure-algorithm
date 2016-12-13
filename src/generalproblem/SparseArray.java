package generalproblem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mishrk3 on 12/13/2016.
 */
public class SparseArray {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String texts = sc.next();
		for(int i=0; i < n-1; i++){
			texts = texts + " " + sc.next();
		}
		int q = sc.nextInt();
		for(int i = 0; i < q; i++){
			Pattern p = Pattern.compile("\\b"+sc.next() + "\\b");
			Matcher m = p.matcher(texts);
			int count = 0;
			while(m.find()){
				count++;
			}
			System.out.println(count);
		}
	}
}

