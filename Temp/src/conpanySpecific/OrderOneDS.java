package conpanySpecific;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javax.print.attribute.Size2DSyntax;

/*Design a data structure that supports following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

remove(x): Removes an item x from the data structure if present.

search(x): Searches an item x in the data structure.

getRandom(): Returns a random element from current set of elements*/


public class OrderOneDS 
{
	static HashMap<Integer, Integer> map=new HashMap<>();
	static ArrayList<Integer> list= new ArrayList<>();
	
	public static void main(String[] args)
	{
		insert(1);
		insert(2);
		insert(3);
		
		search(1);
		
		getRandom();
		
		remove(2);
		remove(3);
	}
	private static void getRandom() 
	{
		Random r=new Random();
		int index=r.nextInt(list.size());
		System.out.println(index);
	}
	private static void remove(int i) 
	{
		if (map.containsKey(i))
		{
			int index=map.get(i);
			int last=list.get(list.size()-1);
			Collections.swap(list, index, list.size()-1);
			
			System.out.println(map);
			System.out.println(list);
			
			map.remove(i);
			list.remove(list.size()-1);
			
			map.put(last, index);
			
			System.out.println();
			System.out.println(map);
			System.out.println(list);
		}
		else
			System.out.println("Element not present");
	}
	private static void search(int i) 
	{
		System.out.println(map.get(i));
	}
	private static void insert(int i) 
	{
		list.add(i);
		map.put(i, list.size()-1);
	}
}
