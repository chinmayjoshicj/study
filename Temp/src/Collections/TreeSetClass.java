package Collections;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetClass {

	public static void main(String[] args)
	{
		/*Contains unique elements only like HashSet.
		 
		Access and retrieval times are quiet fast.
		
		Maintains ASCENDING order.*/
		
		  TreeSet<String> set=new TreeSet<String>();  
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
