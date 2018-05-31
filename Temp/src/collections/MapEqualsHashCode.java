package collections;

import java.util.HashMap;
import java.util.Map;

class Student
{
	private String regNum;

	public Student(String string) {
		this.regNum=string;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	
	public boolean equals(Object o)
	{
		if (o!=null && o instanceof Student) 
		{
			String regNum=((Student)o).getRegNum();
			if (regNum!=null && regNum.equals(this.getRegNum())) {
				return true;
			}
		}
		return false;
	}
	public int HashCode() {
		return this.regNum.hashCode();
	}
}
class ReportCard 
{
	public ReportCard()
	{
		super();
		this.mathScore = (int) Math.random();
	}
	private int mathScore;
	
	public int getMathScore() {
		return mathScore;
	}
	
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
}

public class MapEqualsHashCode {

	public static void main(String[] args)
	{
		Student s1=new Student("S1");
		Student s2=new Student("S1");

		Map<Student, ReportCard> studentReport=new  HashMap<Student, ReportCard>();
		studentReport.put(s1, new ReportCard());
		studentReport.put(s2, new ReportCard());
		
		System.out.println(s1.equals(s2));
		
		System.out.println(studentReport.size());//Should ideally print 1 becoz equals method is overridden but printing 2 need to check
}
	
}
