package stringManupulations;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			String result = funnyString(s);
			System.out.println(result);
		}
	}

	private static String funnyString(String s) {
		StringBuilder input1 = new StringBuilder();
		input1.append(s);
		input1 = input1.reverse();

		int i = 0;
		boolean valid = true;
		char[] s1 = new char[s.length()];
		String r = input1.toString();
		s1 = s.toCharArray();
		char[] r1 = new char[s.length()];
		r1 = r.toCharArray();
		while (i != s.length() - 1) {
			if (s1[i + 1] - s1[i] == r1[i + 1] - r1[i]) {
			} else if (s1[i + 1] - s1[i] == r1[i] - r1[i + 1]) {
			} else {
				valid = false;
			}
			i++;
		}
		return valid ? "Funny" : "Not Funny";
	}

}
