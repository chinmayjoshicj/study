package awesome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class LazyBarTenderProblem 
{
	static char maxDrinksCust='a';
	static	ArrayList<Integer> leastDrinksArray=new ArrayList<Integer>();
	private static void findLeastDrinksToBeSold(HashMap<Character, ArrayList<Integer>> map) 
	{
		HashMap<Integer,ArrayList<Character>> map1= new HashMap<Integer, ArrayList<Character>>();
		
		 Set<Entry<Character, ArrayList<Integer>>> entrySet = map.entrySet();
		 
		 for (Entry entry : entrySet) 
		 {
		    //System.out.println(entry.getValue());
		    ArrayList<Integer> a=new ArrayList<Integer>();
		    a.addAll((Collection<? extends Integer>) entry.getValue());
		    //System.out.println(a);
		    for (Integer integer : a)
		    {
		    	if (!leastDrinksArray.contains(integer)) 
		    	{
		    		leastDrinksArray.add(integer);
				}
			}
		 }
		 Set<Entry<Character, ArrayList<Integer>>> entrySet1 = map.entrySet();
		 
		 for (Entry entry : entrySet1) 
		 {
		    for (Integer integer : leastDrinksArray)
		    {
		    	 ArrayList<Integer> a=new ArrayList<Integer>();
		    	 a=(ArrayList<Integer>) entry.getValue();
		    	 if (a.contains(integer)) 
		    	 {
		    		if (map1.containsKey(integer))
		    		{
		    			ArrayList<Character> temp=map1.get(integer);
		    			for (Character character : temp)
		    			{
		    				Character c=(Character) entry.getKey();
		    				if (!temp.contains(c))
		    				{
		    					temp.add(c);
		    					break;		    					
							}
						}
		    			map1.put(integer,temp);
					}
		    		else
		    		{
		    			ArrayList<Character> a1=new ArrayList<Character>();
		    			a1.add((Character) entry.getKey());
		    			map1.put(integer, a1);
		    		}
		    	 }
		    	 }
			}
		 Set<Entry<Integer, ArrayList<Character>>> entrySet2 = map1.entrySet();
		 
		 System.out.println(map1);
		 int len=0;
		 
		 for (Entry<Integer, ArrayList<Character>> entry : entrySet2) 
		 {
			 if (entry.getValue().size()>len)
			 {
				 len=entry.getValue().size();
			 }
		 }
		map1=getMaxLenValues(len,map,map1);
	}
	private static HashMap<Integer, ArrayList<Character>> getMaxLenValues(int len,HashMap<Character, ArrayList<Integer>> map, HashMap<Integer, ArrayList<Character>> map1) 
	{
		 Set<Entry<Integer, ArrayList<Character>>> entrySet2 = map1.entrySet();
		 ArrayList<Character> a1=new ArrayList<Character>();
		 for (Entry<Integer, ArrayList<Character>> entry : entrySet2) 
		 {
			 if (entry.getValue().size()==len)
			 {
	    			a1.addAll(entry.getValue());
	    			break;
			 }
		 }
		 HashMap<Integer,ArrayList<Character>> map2=new HashMap<Integer, ArrayList<Character>>();
		 map2.putAll(map1);
		 for (Entry<Integer, ArrayList<Character>> entry : entrySet2) //removal
		 {
			 for (Character character : a1)
			 {
				if (entry.getValue().contains(character))
				{
					if (entry.getValue().equals(a1))//contains a1
					{
			    			continue;
					}
					if (map2.containsKey(entry.getKey())) {
						ArrayList<Character> a= new ArrayList<Character>();
						a=map2.get(entry.getKey());
						a.remove(character);
						map2.put(entry.getKey(), a);
					}
				}
			 }
		 }
		 
		 HashMap<Integer,ArrayList<Character>> map3=new HashMap<Integer, ArrayList<Character>>();
		 map3.putAll(map2);
		 Set<Entry<Integer, ArrayList<Character>>> entrySet = map3.entrySet();
		 for (Entry<Integer, ArrayList<Character>> entry : entrySet) //removal
		 {
			 if (entry.getValue().isEmpty())
			 {
				 map2.remove(entry.getKey());
			 }
		 }
		 
		 
		 System.out.println(map2);
		return map2;
	}
	public static void main(String[] args) 
	{
		HashMap<Character, ArrayList<Integer>> map= new HashMap<Character, ArrayList<Integer>>();
		ArrayList<Integer> choice1=new ArrayList<Integer>();
		choice1.add(3);
		choice1.add(7);
		choice1.add(5);
		choice1.add(2);
		choice1.add(9);
		ArrayList<Integer> choice2=new ArrayList<Integer>();
		/*choice2.add(2);
		choice2.add(4);
		choice2.add(5);*/
		choice2.add(5);
		ArrayList<Integer> choice3=new ArrayList<Integer>();
		choice3.add(2);
		choice3.add(3);
		ArrayList<Integer> choice4=new ArrayList<Integer>();
		choice4.add(4);
		ArrayList<Integer> choice5=new ArrayList<Integer>();
		choice5.add(3);
		choice5.add(4);
		choice5.add(5);
		choice5.add(7);
		map.put('a', choice1);
		map.put('b', choice2);
		map.put('c', choice3);
		map.put('d', choice4);
		map.put('e', choice5);

		findLeastDrinksToBeSold(map);	
	}


}
