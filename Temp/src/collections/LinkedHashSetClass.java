package collections;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetClass {

	public static void main(String[] args) 
	{
		
		/*	Contains unique elements only like HashSet.
			Provides all optional set operations, and permits null elements.
			Maintains insertion order. */
		
		/*LINKEDHASHSET class EXTENDS HASHSET class which IMPLEMENTS SET interface*/
		
		LinkedHashSet<String> set=new LinkedHashSet<String>();  
		  set.add("Jason");
		  set.add("Namita");
		  set.add("Needa");
		  set.add("Chinmay");  
		  set.add("Chinmay");
		  //Traversing elements  
		  Iterator<String> itr=set.iterator();  
		  while(itr.hasNext())
		  {  
			  System.out.println(itr.next());  
		  }
		
		
	}

}
