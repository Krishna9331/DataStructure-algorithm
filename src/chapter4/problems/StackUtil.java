package chapter4.problems;

/**
 * Created by mishrk3 on 5/5/2016.
 */
public class StackUtil {

	public static boolean operator(String s) {
		return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "^".equals(s) || "(".equals(s) ||
				")".equals(s);
	}

	public static boolean isLowerPrecedence(String s, String s1) {
		switch (s) {
		case "+":
			return !("+".equals(s1) || "(".equals(s1));
		case "-":
			return !("-".equals(s1) || "(".equals(s1));

		case "*":
			return "/".equals(s1) || "^".equals(s1) || "(".equals(s1);
		case "/":
			return "*".equals(s1) || "^".equals(s1) || "(".equals(s1);

		case "^":
			return "(".equals(s1);

		case "(":
			return false;

		default:
			return false;
		}

	}

	public static Integer doOperation(Integer pop, Integer pop1, String operator) {
		switch (operator) {
		case "+":
			return pop1 + pop;
		case "-":
			return pop1 - pop;
		case "*":
			return pop1 * pop;
		case "/":
			return pop1 / pop;
		default:
			return null;
		}
	}
}
