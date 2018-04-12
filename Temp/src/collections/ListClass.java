package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListClass implements List<String>
{

	public static void main(String[] args) 
	{
		List<String> listInterface=new ArrayList<>();
		//Example of ArrayList
		System.out.println("Example of ArrayList");
		System.out.println();
		ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
		  list.add("Chinmay");//Adding object in arraylist  
		  list.add("Jason");  
		  list.add("Namita");  
		  list.add("Akhilesh");  
		  //Traversing list through Iterator  
		  Iterator itr=list.iterator();  
		  while(itr.hasNext())
		  {  
			  System.out.println(itr.next());  
		  }  
		  //use of retail all method
		  //The following example the retainAll() method is used to remove it's elements from a list 
		  //that are not contained in the specified collection.
		  ArrayList<String> list2=new ArrayList<String>();  
		  list2.add("Chinmay");  
		  list2.add("Needa");  
		  list.retainAll(list2);
		  System.out.println();
		  System.out.println("iterating the elements after retaining the elements of al2...");  
		  Iterator itr1=list.iterator();  
		  while(itr1.hasNext()){  
		   System.out.println(itr1.next());  
		  }  
		  
		  System.out.println("Example of LinkedList");
		  System.out.println();
		  
		  
		  
		  /* 
	    ArrayList
			- user normal Array behavior but with dynamic memory
			- implement only list so acts like a list
			- slow as it internally uses array, and as array uses 
			  basic bit shifting when some element is deleted.

		Linked List (Faster)
			
			- internally uses Doubly-LinkedList
			- acts as QUEUE as well as List because 
			  it implements LIST and DEQUE Interfaces.
		 
			void add(int index, Object element):
				 It inserts the element at the position ‘index’ in the list.

			void addFirst(Object element) :
				 It inserts the element at the beginning of the list.

			void addLast(Object element) :
				 It appends the element at the end of the list.*/
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends String> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String set(int arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<String> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
