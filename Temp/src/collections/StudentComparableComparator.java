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
class users implements Comparable<users>{
	String name;
	int id;

	public users(String name, int i) {
		this.name = name;
		id = i;
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
	public int compareTo(users o)
	{
		return this.getName().compareTo(o.getName());
	}
}

public class StudentComparableComparator {
	public static void main(String[] args) {

		ArrayList<users> list = new ArrayList<users>();// Creating arraylist
		list.add(new users("Chinmay", 1));// Adding object in arraylist
		list.add(new users("Akhilesh", 4));
		list.add(new users("Jason", 2));
		list.add(new users("Namita", 3));

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

	public static void test2() {
		ArrayList<users> list = new ArrayList<users>();// Creating arraylist
		list.add(new users("Chinmay", 1));// Adding object in arraylist
		list.add(new users("Jason", 3));
		list.add(new users("Namita", 7));
		list.add(new users("Akhilesh", 2));

		Collections.sort(list, new MyComparator());
		
		System.out.println("---------After Sorting2--------");
		for (users user : list) {
			System.out.println(user.getName());
		}
		
		Collections.sort(list, new MyComparatorID());
		System.out.println("---------After Sorting Number--------");
		for (users user : list) {
			System.out.println(user.getId() +"- "+user.getName());
		}
	}
	
	static class MyComparator implements Comparator<users> {
		@Override
		public int compare(users o1, users o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
	}
	
	static class MyComparatorID implements Comparator<users> {
		@Override
		public int compare(users o1, users o2) {
			return o1.getId()-(o2.getId());
		}
	}
}
