package collections;

import java.util.ArrayList;
import java.util.TreeSet;

public class TreeSetDemo {
	
	/*TreeSet implements the SORTEDSET INTERFACE so duplicate values are not allowed.
 
	TreeSet does not preserve the insertion order of elements but elements are sorted by keys.
	
	TreeSet does not allow to insert Heterogeneous objects. 
	
	It will throw CLASSCASTEXCEPTION at Runtime if trying to ADD HETROGENEOUS OBJECTS.
	
	TreeSet is basically implementation of a self-balancing binary search tree like Red-Black Tree. 
	
	Therefore operations like add, remove and search take O(Log n) time. And operations like printing n elements in sorted order takes O(n) time.*/
	
	// Elements get stored in default natural
    // Sorting Order(Ascending)
	
	/*Null Insertion:
		If we INSERT NULL in a TreeSet, it THROWS NULL POINTER EXCEPTION 
		because while inserting NULL it will get compared to existing elements and null can not be compared to any value.*/

	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
        al.add("GeeksforGeeks");
        al.add("GeeksQuiz");
        al.add("Practice");
        al.add("Compiler");
        al.add("Compiler"); //will not be added
 
        // Creating a TreeSet object from ArrayList
        TreeSet ts4 = new TreeSet(al);
 
        // [Compiler,GeeksQuiz,GeeksforGeeks,Practice] {It  will print in ascending order} {Here GeeksQuiz,GeeksforGeeks is printed as Q is in caps }
        System.out.println(ts4);
	}

}
