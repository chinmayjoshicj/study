package collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetClass 
{
	
	/*Java HashSet class is used to create a collection that uses a HASH TABLE for storage.
	 *  It inherits the AbstractSet class and implements Set interface.*/
	
	/*Objects that you insert in HashSet are NOT GUARANTEED to be INSERTED IN SAME ORDER. Objects are inserted based on their HASHCODE.
	NULL elements are allowed in HashSet.
	
	NULL elements are allowed in HashSet.
	*/
	
	public static void main(String[] args)
	{
		HashSet<String> set=new HashSet<String>();  
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
