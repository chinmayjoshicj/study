package stringManupulations;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 6
 a b c aa d b
 1 2 3 4  5 6
 3
 1 5 caaab
 0 4 xyz
 2 4 bcdybc
 */
/*Timeout in HackerRank*/
public class DeterminingDNAHealth {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] genes = new String[n];
		for (int genes_i = 0; genes_i < n; genes_i++) {
			genes[genes_i] = in.next();
		}
		int[] health = new int[n];
		for (int health_i = 0; health_i < n; health_i++) {
			health[health_i] = in.nextInt();
		}
		int s = in.nextInt();
		int[] count = new int[s];
		for (int a0 = 0; a0 < s; a0++) {
			int first = in.nextInt();
			int last = in.nextInt();
			String d = in.next();

			for (int j = first; j <= last; j++) {
				
				Pattern pat = Pattern.compile(".*" + genes[j] + ".*");
				Matcher match = pat.matcher(d);
				if (match.find()) {
					count[a0] += health[j] * multiply(d, genes[j]);
				}
			}
		}
		int max = -1;
		;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < count.length; i++) {
			if (max < count[i]) {
				max = count[i];
			}
			if (min > count[i]) {
				min = count[i];
			}
		}
		System.out.print(min + " ");
		System.out.print(max);
	}

	private static int multiply(String d, String pattern) {
		Pattern pat = Pattern.compile(pattern);
		Matcher match = pat.matcher(d);
		int start = 0;
		int end = d.length();
		int count = 0;
		while (match.find()) {
			count++;
			d = d.substring(match.start() + 1, d.length());
			match = pat.matcher(d);
		}
		// System.out.println("Chinmay "+count);
		return count;
	}

}
