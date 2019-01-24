package practice;

import java.util.Stack;

public class BalanceParenthesisPractice {
	public static void main(String[] args) {
		String exp = "[()]{}{[()()]()}";

		System.out.println(method1(exp, 0, exp.length() - 1));
		System.out.println(method2(exp, 0, exp.length() - 1));
	}

	private static boolean method1(String exp, int start, int end) {
		Stack<Character> s1 = new Stack<>();
		if (exp.charAt(0) == '}' || exp.charAt(0) == ']' || exp.charAt(0) == ')') {
			return false;
		}
		s1.push(exp.charAt(0));
		int i = 1;
		while (i != exp.length()) {
			if (exp.charAt(i) == '[' || exp.charAt(i) == '{' || exp.charAt(i) == '(') {
				s1.push(exp.charAt(i));
			} else {
				if (exp.charAt(i) == ']') {
					if (s1.pop() != '[') {
						return false;
					}
				}
				if (exp.charAt(i) == '}') {
					if (s1.pop() != '{') {
						return false;
					}
				}
				if (exp.charAt(i) == ')') {
					if (s1.pop() != '(') {
						return false;
					}
				}
			}
			i++;
		}
		if (!s1.empty()) {
			return false;
		}
		return true;
	}

	private static boolean method2(String exp, int start, int end) {
		if (start > end) {
			return false;
		}
		char closing = 0;
		if (exp.charAt(start) == '}' || exp.charAt(start) == ']' || exp.charAt(start) == ')') {
			return false;
		}
		if (exp.charAt(start) == '(') {
			closing = ')';
		}
		if (exp.charAt(start) == '[') {
			closing = ']';
		}
		if (exp.charAt(start) == '{') {
			closing = '}';
		}

		int count = 0;
		int i = start;
		for (i = start; i <= end; i++) {
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
		if (i == end) {
			return false;
		}
		if (i == 1) {
			return method2(exp, start + 2, end);
		}
		return method2(exp, start + 1, i - 1) && method2(exp, i + 1, end);

	}
}
