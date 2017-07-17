package awesome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LazyBarTenderProblem {
	static ArrayList<Integer> leastDrinksArray = new ArrayList<Integer>();
	static HashMap<Integer, ArrayList<Character>> map2 = new HashMap<Integer, ArrayList<Character>>();
	static HashMap<Integer, ArrayList<Character>> map4 = new HashMap<Integer, ArrayList<Character>>();

	private static void findLeastDrinksToBeSold(HashMap<Character, ArrayList<Integer>> map) {

		HashMap<Integer, ArrayList<Character>> map1 = new HashMap<Integer, ArrayList<Character>>();

		Set<Entry<Character, ArrayList<Integer>>> entrySet = map.entrySet();
		for (Entry<Character, ArrayList<Integer>> entry : entrySet)
		{
			ArrayList<Integer> value = entry.getValue();
			for (Integer integer : value) 
			{
				ArrayList<Character> arrayList = map1.get(integer);
				if (arrayList == null) 
				{
					arrayList = new ArrayList<Character>();
				}
				arrayList.add(entry.getKey());
				map1.put(integer, arrayList);
			}
		}
		System.out.println(map1);
		getMaxLenValues(map1);
		
		System.out.println("The Least required number of Drinks required are:");
		Set<Entry<Integer, ArrayList<Character>>> entrySet1 = map4.entrySet();
		for (Entry<Integer, ArrayList<Character>> entry : entrySet1) // removal
		{
			System.out.println(entry.getKey());
		}
	}

	private static HashMap<Integer, ArrayList<Character>> getMaxLenValues(HashMap<Integer, ArrayList<Character>> map1) 
	{
		int len=0;
		Set<Entry<Integer, ArrayList<Character>>> entrySet = map1.entrySet();
		 for (Entry<Integer, ArrayList<Character>> entry : entrySet) 
		 {
			 if (entry.getValue().size()>len)
			 {
				 len=entry.getValue().size();
			 }
		 }
		if (len == 0) 
		{
			return null;
		}
		Set<Entry<Integer, ArrayList<Character>>> entrySet2 = map1.entrySet();
		ArrayList<Character> a1 = new ArrayList<Character>();
		Integer key=null;
		for (Entry<Integer, ArrayList<Character>> entry : entrySet2) 
		{
			if (entry.getValue().size() == len) 
			{
				map4.put(entry.getKey(), entry.getValue());
				a1.addAll(entry.getValue());
				key=entry.getKey();
				break;
			}
		}
		map2.putAll(map1);
		map1.remove(key);
		if (!a1.isEmpty()) 
		{
			boolean flag = false;
			for (Entry<Integer, ArrayList<Character>> entry : entrySet2) // removal
			{
				for (Character character : a1) 
				{
					if (entry.getValue().contains(character)) 
					{
						if (!flag) 
						{
							if (entry.getKey().equals(key))// contains a1
							{
								flag = true;
								break;
							}
						}
						if (map2.containsKey(entry.getKey())) 
						{
							ArrayList<Character> a11 = new ArrayList<Character>();
							a11 = map2.get(entry.getKey());
							a11.remove(character);
							map2.put(entry.getKey(), a11);
						}
					}
				}
			}
		}
		HashMap<Integer, ArrayList<Character>> map3 = new HashMap<Integer, ArrayList<Character>>();
		map3.putAll(map2);

		Set<Entry<Integer, ArrayList<Character>>> entrySet1 = map3.entrySet();
		for (Entry<Integer, ArrayList<Character>> entry : entrySet1) // removal
		{
			if (entry.getValue().isEmpty()) 
			{
				map2.remove(entry.getKey());
			}
		}
		System.out.println(map2);
	
		getMaxLenValues(map1);
		System.out.println(map4);
		return map2;
	}

	public static void main(String[] args) 
	{
		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		ArrayList<Integer> choice1 = new ArrayList<Integer>();
		choice1.add(1);
		choice1.add(2);
		choice1.add(3);
		ArrayList<Integer> choice2 = new ArrayList<Integer>();
		choice2.add(2);
		choice2.add(4);
		ArrayList<Integer> choice3 = new ArrayList<Integer>();
		choice3.add(3);
//		 choice3.add(2);
		choice3.add(4);
		ArrayList<Integer> choice4 = new ArrayList<Integer>();
		choice4.add(4);
		 choice4.add(5);
//		choice4.add(5);
		ArrayList<Integer> choice5 = new ArrayList<Integer>();
		choice5.add(5);
		 choice5.add(6);
//		 choice5.add(4);
		map.put('a', choice1);
		map.put('b', choice2);
		map.put('c', choice3);
		map.put('d', choice4);
		map.put('e', choice5);

		findLeastDrinksToBeSold(map);
	}

}
