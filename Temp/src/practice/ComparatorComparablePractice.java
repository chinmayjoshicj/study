package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentReportPractice {
	int marks;

	public StudentReportPractice(int marks) {
		super();
		this.marks = marks;
	}

}
class sortStuPractice implements Comparator<StudentPractice>
{
	@Override
	public int compare(StudentPractice o1, StudentPractice o2) {
		// TODO Auto-generated method stub
		return o1.sr.marks-o2.sr.marks;
	}
}

class StudentPractice {
	int StudentId;
	StudentReportPractice sr;

	public StudentPractice(int studentId, StudentReportPractice sr) {
		super();
		StudentId = studentId;
		this.sr = sr;
	}
}
public class ComparatorComparablePractice {
	public static void main(String[] args) {
		List<StudentPractice> list = new ArrayList<>();
		list.add(new StudentPractice(1, new StudentReportPractice(12)));
		list.add(new StudentPractice(11, new StudentReportPractice(132)));
		list.add(new StudentPractice(12, new StudentReportPractice(112)));
		list.add(new StudentPractice(13, new StudentReportPractice(122)));

		Collections.sort(list, new sortStuPractice());
		for (StudentPractice student : list) {
			System.out.println(student.sr.marks);
		}
	}
}
