package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class VatsalBhaiAnagrams {

	static String arr[] = { "eat", "pots", "onset", "stone", "rail", "risen", "caret", "resin", "react", "siren",
			"sitar", "stair", "liar", "stop", "trace", "notes", "tea", "lair" };;
	static String sortArr[] = new String[arr.length];

	public static void main(String[] args) {
		method1();
//		method2();
	}

	private static void method2() 
	{
		HashMap<Integer, ArrayList<String>> map= new HashMap<>();
		for (int i = 0; i < arr.length; i++) 
		{
			int s=0;
			for (int j = 0; j < arr[i].length(); j++) 
			{
				s+=arr[i].charAt(j)-'a';
			}
			if (map.containsKey(s))
			{
				ArrayList<String> arrayList = map.get(s);
				arrayList.add(arr[i]);
				map.put(s, arrayList);
			}
			else
			{
				ArrayList<String> arrayList = new ArrayList<>();
				arrayList.add(arr[i]);
				map.put(s, arrayList);
			}
		}
		for (Entry<Integer,ArrayList<String>>set:map.entrySet())
		{
			System.out.println(set.getValue()+" ");
		}
		System.out.println();
	}

	private static void method1() {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < sortArr.length; i++) {
			sortArr[i] = arr[i];
		}
		for (int i = 0; i < sortArr.length; i++) {
			String s = sortArr[i];
			char[] charArray = s.toCharArray();
			Arrays.sort(charArray);
			sortArr[i] = new String(charArray);
		}
		for (String string : arr) {
			System.out.print(string + " ");
		}
		for (int i = 0; i < sortArr.length; i++) {
			for (int j = 0; j < sortArr.length; j++) {
				if (sortArr[j].equals(sortArr[i])) {
					if (map.containsKey(arr[i])) {
						ArrayList<String> l = map.get(arr[i]);
						l.add(arr[j]);
						map.put(arr[i], l);
					} else {
						ArrayList<String> l = new ArrayList<>();
						l.add(arr[j]);
						map.put(arr[i], l);
					}
				}
			}
		}
		System.out.println();
		Set<Entry<String, ArrayList<String>>> set = map.entrySet();
		for (Entry<String, ArrayList<String>> entry : set) {
			System.out.println(entry);
		}
	}
}
