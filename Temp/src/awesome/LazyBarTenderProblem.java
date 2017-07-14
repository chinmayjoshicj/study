package awesome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class LazyBarTenderProblem 
{
	static char maxDrinksCust='a';
	static	ArrayList<Integer> maxDrinksArray=new ArrayList<Integer>();
	private static void findLeastDrinksToBeSold(HashMap<Character, ArrayList<Integer>> map) 
	{
		int len=10000;
		int count=0;
		for (Entry<Character, ArrayList<Integer>> entry : map.entrySet()) 
		{
			maxDrinksArray.addAll(entry.getValue());
		}
		HashMap<Integer, Integer> result= new HashMap<Integer, Integer>();
		for (Integer integer : maxDrinksArray) 
		{
			result.put(integer, 1);
		}
		for (Integer integer : maxDrinksArray) 
		{
			
		}
	}
	public static void main(String[] args) 
	{
		HashMap<Character, ArrayList<Integer>> map= new HashMap<Character, ArrayList<Integer>>();
		ArrayList<Integer> choice1=new ArrayList<Integer>();
		choice1.add(1);
		choice1.add(2);
		choice1.add(3);
		ArrayList<Integer> choice2=new ArrayList<Integer>();
		choice2.add(2);
		choice2.add(4);
		ArrayList<Integer> choice3=new ArrayList<Integer>();
		choice3.add(3);
		choice3.add(4);
		ArrayList<Integer> choice4=new ArrayList<Integer>();
		choice4.add(4);
		choice4.add(5);
		ArrayList<Integer> choice5=new ArrayList<Integer>();
		choice5.add(5);
		choice5.add(6);
		map.put('a', choice1);
		map.put('b', choice2);
		map.put('c', choice3);
		map.put('d', choice4);
		map.put('e', choice5);

		findLeastDrinksToBeSold(map);	
	}


}
