package practice;

import java.util.HashMap;
import java.util.Map;

public class TwoStringAnagram {
	public static void main(String[] args) {
		String s1 = "geeksforgeeks";
		String s2 = "forgeeksgeeks";

		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();

		char[] ss1 = s1.toCharArray();
		char[] ss2 = s2.toCharArray();

		for (int i = 0; i < ss1.length; i++) {
			if (map1.containsKey(ss1[i])) {
				map1.put(ss1[i], map1.get(ss1[i]) + 1);
			} else
				map1.put(ss1[i], 1);
		}
		for (int i = 0; i < ss2.length; i++) {
			if (map2.containsKey(ss2[i])) {
				map2.put(ss2[i], map2.get(ss2[i]) + 1);
			} else
				map2.put(ss2[i], 1);
		}

		System.out.println(map1.entrySet());
		System.out.println(map2.entrySet());

		for (Map.Entry<Character, Integer> pair : map1.entrySet()) {
			if (map1.get(pair.getKey()) == map2.get(pair.getKey())) {
				continue;
			} else
				System.out.println("Not Anagrams");
		}
	}
}
