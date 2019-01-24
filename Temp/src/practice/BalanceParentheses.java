package practice;

import java.util.Stack;

public class BalanceParentheses {
	public static void main(String[] args) {
		String exp = "[()]{}{[()()]()}";
		exp = "{}";
		method1();
		System.out.println(method2(exp, 0, exp.length() - 1));
	}

	private static boolean method2(String exp, int start, int end) {

		if (start > end) {
			return false;
		}
		int count = 0;
		char closing = 0;
		if (exp.charAt(start) == '[') {
			closing = ']';
		}
		if (exp.charAt(start) == '{') {
			closing = '}';
		}
		if (exp.charAt(start) == '(') {
			closing = ')';
		}
		int i = 1;
		for (i = 1; i <= end; i++) {
			if (exp.charAt(i) == exp.charAt(start)) {
				count++;
			}
			if (exp.charAt(i) == closing) {
				if (count == 0) {
					break;
				}
				count--;
			}
		}
		if (i == end)// if no closing bracket founds
		{
			return false;
		}
		if (i == 1) {
			return method2(exp, start + 2, end);
		}
		return method2(exp, start + 1, i - 1) && method2(exp, i + 1, end);
	}

	private static void method1() {
		String exp = "[()]{}{[()()]()";
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '[' || exp.charAt(i) == '(' || exp.charAt(i) == '{') {
				s.push(exp.charAt(i));
			} else if (s.empty()) {
				System.out.println("Not Balanced");
			} else
				s.pop();
		}
		if (s.isEmpty()) {
			System.out.println("Balanced");
		} else
			System.out.println("Not Balanced");
	}
}
