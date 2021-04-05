package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentReportPractice {

	int marks;
	String subject;
	public StudentReportPractice(int marks,String sub) {
		super();
		this.marks = marks;
		this.subject=sub;
	}
}
//class sortStuPractice implements Comparator<StudentPractice>
//{
//
//	@Override
//	public int compare(StudentPractice s1, StudentPractice s2) {
//		// TODO Auto-generated method stub
//		return s1.sr.marks-s2.sr.marks;
//	}
//	
//}

class StudentPractice implements Comparable<StudentPractice>{
	int stuID;
	StudentReportPractice sr;
	public StudentPractice(int stuID, StudentReportPractice sr) {
		super();
		this.stuID = stuID;
		this.sr = sr;
	}
		@Override
		public int compareTo(StudentPractice s) {
			// TODO Auto-generated method stub
			return this.sr.subject.compareTo(s.sr.subject);
		}

}
public class ComparatorComparablePractice {
	public static void main(String[] args) {
		List<StudentPractice> list = new ArrayList<StudentPractice>();
		list.add(new StudentPractice(1, new StudentReportPractice(12,"Maths")));
		list.add(new StudentPractice(11, new StudentReportPractice(132,"Science")));
		list.add(new StudentPractice(12, new StudentReportPractice(112,"Geo")));
		list.add(new StudentPractice(13, new StudentReportPractice(122,"CS")));

		Collections.sort(list);
		for (StudentPractice student : list) {
			System.out.println(student.sr.subject);
		}
	}
}
