package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*Comparable

- default sorting order
- java.lang
- oneMethod i.e compareTo()

Comparator

- Customized sorting order
- java.utils
- 2 methods compare(), equals()


java takes the instance of a perticular object*/
class users implements Comparable<users>
{
	String name;
	int id;
	
	public users(String name, int i) 
	{
		this.name=name;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int compareTo(users user) {
		// TODO Auto-generated method stub
		
		//This should only return -1(a negative number),0,1(Positive Number)
		//1 THIS perticular object is greater than the object that we are comparing to
		//2 THIS perticular object is equal to the object that we are comparing to
		//3 THIS perticular object is less than the object that we are comparing to
		return this.getName().compareTo(user.name);// we are comparing THIS to the object passed.
	}
}

public class StudentComparableComparator
{
	public static void main(String[] args) 
	{
		ArrayList<String> listInterface=new ArrayList<>();
		//Example of ArrayList
		System.out.println("Example of ArrayList");
		System.out.println();
		
		ArrayList<users> list=new ArrayList<users>();//Creating arraylist  
		  list.add(new users("Chinmay",1));//Adding object in arraylist  
		  list.add(new users("Jason",2));  
		  list.add(new users("Namita",3));  
		  list.add(new users("Akhilesh",4));
		  
		  System.out.println("Before Sorting");
		  
		 for (users users : list) {
			System.out.println(users.name);
		}
		 
		  System.out.println("");
		  System.out.println("After Sorting");
		  
		  Collections.sort(list);
		  for (users users : list) {
				System.out.println(users.name);
			}
		test2();
		  
	}
	public static void test2()
	{
		System.out.println();
		System.out.println("CompareTo implementation");
		System.out.println();
		
		/*String one="Chinmay";
		String two="Akhilesh";*/
		
		/*Capital letter are inserted before small*/
		String one="Chinmay";
		String two="akhilesh"; /* here it fails */ 
		
		List<String> list= new ArrayList<>();
		list.add(one);
		list.add(two);
		
		Collections.sort(list);
		
		Collections.sort(list, new Comparator<String>() 
		{
			@Override
			public int compare(String o1, String o2) 
			{
				return o1.compareToIgnoreCase(o2);
			}
			
		});
		for (String string : list) {
			System.out.println(string);
		}
		
	}
}
