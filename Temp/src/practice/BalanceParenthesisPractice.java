package practice;

import java.util.Stack;

public class BalanceParenthesisPractice {
	public static void main(String[] args) {
		String exp = "[()]{}{[()()]()}";
		exp = "(()){{}(}";
		char[] charArray = exp.toCharArray();
		System.out.println(method1(exp, 0, exp.length() - 1));
		System.out.println(check(exp));
	}

	private static boolean method1(String exp, int start, int end) {
		if (exp.charAt(0) == '}' && exp.charAt(0) == ']' && exp.charAt(0) == ')') {
			return false;
		}
		Stack<Character> s = new Stack<>();
		int pointer = 0;
		while (!s.isEmpty() || pointer < exp.length()) {
			if (exp.charAt(pointer) == '{' || exp.charAt(pointer) == '[' || exp.charAt(pointer) == '(') {
				s.push(exp.charAt(pointer));
			} else {
				char pop = s.pop();
				if (exp.charAt(pointer) == '}') {
					if (pop != '{') {
						return false;
					}
				}
				if (exp.charAt(pointer) == ']') {
					if (pop != '[') {
						return false;
					}
				}
				if (exp.charAt(pointer) == ')') {
					if (pop != '(') {
						return false;
					}
				}
			}
			pointer++;
		}
		if (!s.isEmpty()) {
			return false;
		}
		return true;
	}

	static char findClosing(char c) {
		if (c == '(')
			return ')';
		if (c == '{')
			return '}';
		if (c == '[')
			return ']';
		return 0;
	}

	// function to check if parenthesis are
	// balanced.
	static boolean check(String expr) {
		int n = expr.length();
		// Base cases
		if (n == 0)
			return true;
		if (n == 1)
			return false;
		if (expr.charAt(0) == ')' || expr.charAt(0) == '}' || expr.charAt(0) == ']')
			return false;

		// Search for closing bracket for first
		// opening bracket.
		char closing = findClosing(expr.charAt(0));

		// count is used to handle cases like
		// "((()))". We basically need to
		// consider matching closing bracket.
		int i, count = 0;
		for (i = 1; i < n; i++) {
			if (expr.charAt(i) == expr.charAt(0))
				count++;
			if (expr.charAt(i) == closing) {
				if (count == 0)
					break;
				count--;
			}
		}

		// If we did not find a closing
		// bracket
		if (i == n)
			return false;

		// If closing bracket was next
		// to open
		if (i == 1)
			return check(expr.substring(2, n - 2));

		// If closing bracket was somewhere
		// in middle.
		return check(expr.substring(1, i - 1)) && check(expr.substring(i + 1, n - i - 1));
	}

	// Driver program to test above function

}
