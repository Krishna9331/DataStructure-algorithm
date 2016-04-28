package chapter2.backtracking;

/**
 * Created by mishrk3 on 4/28/2016.
 */
public class AllStringCombination {

	/**
	 * @param strings an empty String array of size same as length of s
	 * @param s       the string array for which, combination has to be generated(e.g ["A", "B", "C"])
	 *                The logic for below algorithm is:
	 *                Step 1:  replace the nth place of the blank array with each of the entry of the s.(A, then B and
	 *                then C), where n is length of the s.
	 *                Step 2: which ever character has been used at last place remove that character from s (so if "A"
	 *                has been used the remaining s will be ["B", "C"])
	 *                step3: recursively follow the steps for the rest of the place of the blank array.
	 *                Call can be traced as
	 *                <pre>
	 *                               ([], ["A", "B", "C"]}
	 *                               {combination(["A"], ["B", "C"])}-->
	 *                               		{Combination(["B","A"], ["C"]} --> CBA(recursion breaks)
	 *                               		{Combination(["C","A"], ["B"]} --> BCA
	 *                               {combination(["B"], ["A", "C"])}
	 *                  			        {Combination(["A","B"], ["C"]} --> CAB
	 *                               		{Combination(["C","B"], ["A"]} --> ACB
	 *                               {combination(["C"], ["A", "B"])}
	 *                               		{Combination(["A","C"], ["B"]} --> BAC
	 *                               		{Combination(["B","C"], ["A"]} --> ABC
	 *               </pre>
	 */
	public void combination(String[] strings, String[] s) {
		if (s.length < 1) {
			for (String s1 : strings)
				System.out.print(s1);
			System.out.println();
		} else {
			int n1 = s.length;
			for (int i = 0; i < n1; i++) {
				strings[n1 - 1] = s[i];
				String[] s2 = new String[n1 - 1];
				for (int j = 0; j < i; j++) {
					s2[j] = s[j];
				}
				for (int j = i; j < s2.length; j++) {
					s2[j] = s[j + 1];
				}
				combination(strings, s2);
			}
		}
	}

	public static void main(String[] args) {
		AllStringCombination asc = new AllStringCombination();
		String[] s = new String[3];
		String[] s1 = new String[] { "A", "B", "C" };
		asc.combination(s, s1);
	}
}
