package awesome;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class ImmutableString {
	public static void main(String[] args) {
		/*
		 * int i = Integer.parseInt("1001", 2); int mask = 9;
		 * 
		 * System.out.println(Integer.toHexString(1212));
		 * 
		 * System.out.println((i & mask) == 9); }
		 */

//		System.out.println(Math.pow(2, 64));

		String a1 = "abc";
		String a2 = "abc";

		String a3 = new String("abc");
		String a4 = new String("abc");

		System.out.println();

		System.out.println("ac ");
		System.out.println(a1 == a2);
		System.out.println("a1.equals(a2): " + a1.equals(a2));

		System.out.println();

		System.out.println("a3==a4: ");
		System.out.println(a3 == a4);
		System.out.println("a3.equals(a4): " + a3.equals(a4));

		LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<>();

		String s = "i love programming very much";

		for (int i = 0; i < s.length(); i++) {
			lmap.put(s.charAt(i), 1);
		}
		for (Entry<Character, Integer> entry : lmap.entrySet()) {
			System.out.print(entry.getKey());
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2) {
					return o1 - o2;
				} else
					return o2 - o1;
			}
		});
		pq.add(5);
		pq.add(3);
		pq.add(1);
		System.out.println();
		System.out.println(pq);
		System.out.println();
		System.out.println("Print in Reverse: ");
		printRev(s, 0);
		System.out.println();
		System.out.println();
		System.out.println("Print Words in reverse ");
		revWordsinSting(s, 0);
		System.out.println();
		System.out.println();
		System.out.println("Print first non repeating character ");
		s = "geeksforgeeks";
		printFirstNonRepeatingCharacter(s);
		try {
			System.exit(0);
		} catch (Exception e) {

		} finally {
			System.out.println("Chinmay");
		}
	}

	private static void printFirstNonRepeatingCharacter(String s) {
		LinkedHashMap<Character, Integer> lmap = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (lmap.containsKey(s.charAt(i))) {
				lmap.put(s.charAt(i), lmap.get(s.charAt(i)) + 1);
			} else
				lmap.put(s.charAt(i), 1);
		}
		for (Entry<Character, Integer> entry : lmap.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;
			}
		}
	}

	private static void revWordsinSting(String s, int i) {
		String s1[] = s.split(" ");
		revWords(s1, i);
	}

	private static void revWords(String[] s1, int i) {
		if (i >= s1.length) {
			return;
		}
		revWords(s1, i + 1);
		System.out.print(s1[i] + " ");
	}

	private static void printRev(String s, int i) {
		if (i >= s.length())
			return;

		printRev(s, i + 1);
		System.out.print(s.charAt(i) + "");
	}
}
