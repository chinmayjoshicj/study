package awesome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LazyBarTenderProblemSaravaran {
	static ArrayList<Integer> leastDrinksArray = new ArrayList<Integer>();
	static HashMap<Integer, ArrayList<Character>> map2 = new HashMap<Integer, ArrayList<Character>>();
	static HashMap<Integer, ArrayList<Character>> resultMap = new HashMap<Integer, ArrayList<Character>>();

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
		Set<Entry<Integer, ArrayList<Character>>> entrySet1 = resultMap.entrySet();
		for (Entry<Integer, ArrayList<Character>> entry : entrySet1) // removal
		{
			if (!entry.getValue().isEmpty())
				System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}

	private static HashMap<Integer, ArrayList<Character>> getMaxLenValues(HashMap<Integer, ArrayList<Character>> map1) {

		while (!map1.isEmpty()) {
			Integer drink = getMaxCustomer(map1);

			ArrayList<Character> customers = map1.get(drink);
			resultMap.put(drink, customers);
			map1.remove(drink);

			Set<Entry<Integer, ArrayList<Character>>> entrySet2 = map1.entrySet();

			for (Entry<Integer, ArrayList<Character>> entry : entrySet2) // removal
			{
				ArrayList<Character> temCustomers = entry.getValue();
				for (Character character : customers) {
					if (temCustomers.contains(character)) {
						temCustomers.remove(character);
					}
				}
			}
		}
		return resultMap;
	}

	private static Integer getMaxCustomer(HashMap<Integer, ArrayList<Character>> map1) {
		Integer drinkMax = 0;
		Set<Entry<Integer, ArrayList<Character>>> entrySet = map1.entrySet();
		for (Entry<Integer, ArrayList<Character>> entry : entrySet) {
			if (drinkMax == 0) {
				drinkMax = entry.getKey();
			}
			if (entry.getValue().size() > drinkMax) {
				drinkMax = entry.getKey();
			}
		}
		return drinkMax;
	}

	public static void main(String[] args) {
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
		// choice3.add(2);
		choice3.add(4);
		ArrayList<Integer> choice4 = new ArrayList<Integer>();
		choice4.add(4);
		choice4.add(5);
		// choice4.add(5);
		ArrayList<Integer> choice5 = new ArrayList<Integer>();
		choice5.add(5);
		choice5.add(6);
		// choice5.add(4);
		map.put('a', choice1);
		map.put('b', choice2);
		map.put('c', choice3);
		map.put('d', choice4);
		map.put('e', choice5);

		findLeastDrinksToBeSold(map);
	}

}
