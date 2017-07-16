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
	static HashMap<Integer,ArrayList<Character>> map2=new HashMap<Integer, ArrayList<Character>>();
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
		getMaxLenValues(len,map,map1);
		 Set<Entry<Integer, ArrayList<Character>>> entrySet3 = map2.entrySet();
		for (Entry<Integer, ArrayList<Character>> entry : entrySet3) 
		 {
			 if (entry.getValue().size()==0)
			 {
				 map1.remove(entry.getKey());
			 }
		 }
		Set<Entry<Integer, ArrayList<Character>>> entrySet4 = map2.entrySet();
		System.out.println("The Least required number of Drinks required are:");
		System.out.print(map2+"-->");
		for (Entry<Integer, ArrayList<Character>> entry : entrySet4) 
		{
			System.out.print(entry.getKey()+" ");
		}
	}
	private static HashMap<Integer, ArrayList<Character>> getMaxLenValues(int len,HashMap<Character, ArrayList<Integer>> map, HashMap<Integer, ArrayList<Character>> map1) 
	{
		if (len==0)
		{
			return null;
		}
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
		 map2.putAll(map1);
		 
		 if (!a1.isEmpty()) {
			
			 boolean flag=false;
			 for (Entry<Integer, ArrayList<Character>> entry : entrySet2) //removal
			 {
				 for (Character character : a1)
				 {
					 if (entry.getValue().contains(character))
					 {
						 
						 if (!flag)
						 {
							 if (entry.getValue().equals(a1))//contains a1
							 {
								 flag=true;
								 break;
							 }
						}
						 if (map2.containsKey(entry.getKey()))
						 {
							 ArrayList<Character> a= new ArrayList<Character>();
							 a=map2.get(entry.getKey());
							 a.remove(character);
							 map2.put(entry.getKey(), a);
						 }
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
		 getMaxLenValues(--len,map,map2);
		 return map2;
	}
	public static void main(String[] args)
	{
		HashMap<Character, ArrayList<Integer>> map= new HashMap<Character, ArrayList<Integer>>();
		ArrayList<Integer> choice1=new ArrayList<Integer>();
		choice1.add(1);
		choice1.add(2);
		ArrayList<Integer> choice2=new ArrayList<Integer>();
		choice2.add(5);
		choice2.add(3);
		choice2.add(4);
		ArrayList<Integer> choice3=new ArrayList<Integer>();
		choice3.add(3);
		choice3.add(2);
		choice3.add(1);
		ArrayList<Integer> choice4=new ArrayList<Integer>();
		choice4.add(2);
		choice4.add(5);
		choice4.add(4);
		ArrayList<Integer> choice5=new ArrayList<Integer>();
		choice5.add(6);
//		choice5.add(4);
//		choice5.add(1);
		map.put('a', choice1);
		map.put('b', choice2);
		map.put('c', choice3);
		map.put('d', choice4);
		map.put('e', choice5);

		findLeastDrinksToBeSold(map);	
	}


}
