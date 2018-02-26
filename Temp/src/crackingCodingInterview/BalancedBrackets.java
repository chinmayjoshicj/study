package crackingCodingInterview;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}

	private static boolean isBalanced(String expression) {
		Stack<Character> bracket = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			Character b = expression.charAt(i);
			if (b == '{' || b == '[' || b == '(') {
				bracket.push(b);
				continue;
			} else {
				Character a = null;
				if (!bracket.isEmpty()) {
					a = bracket.peek();
				} else
					return false;

				if (a == '[') {
					if (b != ']') {
						return false;
					}
				} else if (a == '{') {
					if (b != '}') {
						return false;
					}
				} else if (a == '(') {
					if (b != ')') {
						return false;
					}
				}
				bracket.pop();
			}
		}
		if (!bracket.isEmpty()) {
			return false;
		}
		return true;
	}

}
