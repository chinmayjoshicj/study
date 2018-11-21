package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentReport {
	int marks;

	public StudentReport(int marks) {
		super();
		this.marks = marks;
	}
}

class Student {
	int StudentId;
	StudentReport sr;

	public Student(int studentId, StudentReport sr) {
		super();
		StudentId = studentId;
		this.sr = sr;
	}
}

class sortStudent implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.sr.marks - o2.sr.marks;
	}
}

public class ComparatorComparable {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, new StudentReport(12)));
		list.add(new Student(11, new StudentReport(132)));
		list.add(new Student(12, new StudentReport(112)));
		list.add(new Student(13, new StudentReport(122)));

		Collections.sort(list, new sortStudent());
		for (Student student : list) {
			System.out.println(student.sr.marks);
		}
	}

}
