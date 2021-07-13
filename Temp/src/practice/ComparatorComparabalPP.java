package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class student implements Comparable<student>{
	int marks;
	String subject;
	
	public student(int marks, String subject) {
		super();
		this.marks = marks;
		this.subject = subject;
	}


	@Override
	public int compareTo(student s ) {
		if(s.marks<this.marks) {
			return -1;
		}
		else if(s.marks==this.marks) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
public class ComparatorComparabalPP {

	public static void main(String[] args) {
		ArrayList<student> list = new ArrayList<student>();
		list.add(new student(12, "Maths"));
		list.add(new student(10, "Sci"));
		list.add(new student(9, "geo"));
		list.add(new student(11, "ll"));
		
		Collections.sort(list);
		for (student student : list) {
			System.out.println(student.marks);
		}

	}

}
