
package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	private String[] entries;

	public Dictionary(String[] entries) {
		this.entries = entries;
	}

	public boolean contains(String word) {
		return Arrays.asList(entries).contains(word);
	}

	static HashSet<String> set = new HashSet<String>();
	static String dict[] = { "tow", "toe", "town" };

	public static Set<String> longestWord(String letters, Dictionary dict) {
		Set<String> result = new HashSet<String>();
		if (dict.contains(letters)) {
			result.add(letters);
		}
		check(letters, 0, letters.length() - 1);
		return result;
	}

	public static void check(String letters, int start, int end) {
		if (start == end) {
			set.add(letters);
		} else {
			for (int i = start; i <= end; i++) {
				letters = swap(letters, start, i);
				check(letters, start + 1, end);
				letters = swap(letters, start, i);
			}
		}
	}

	public static String swap(String letters, int start, int end) {
		char[] chararr = letters.toCharArray();

		char temp;
		temp = chararr[start];
		chararr[start] = chararr[end];
		chararr[end] = temp;
		String a = "";
		/*for (int i = 0; i < chararr.length; i++) {
			a += chararr[i];
		}
		return a;*/
		return new String(chararr);
	}

	public static void main(String args[]) {	
		check("ote", 0, "ote".length() - 1);
		for (int i = 0; i < dict.length; i++) {
			if (set.contains(dict[i])) {
				System.out.println("Word in Dictionary is: ");
				System.out.println(dict[i]);
			}
		}

	}
}
