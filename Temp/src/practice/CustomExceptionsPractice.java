package practice;

class PersonPractice {
	int age;
	

	public PersonPractice(int age) throws TooHighAgeException, TooLessAgeException {
		super();
		this.age = age;
		if (age>30) {
			throw new TooHighAgeException("high");
		}
		if (age<18) {
			throw new TooLessAgeException("less");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
 class TooHighAgeException extends RuntimeException
 {
	 TooHighAgeException(String s){
		 super(s);
	 }
 }
 
 class TooLessAgeException extends RuntimeException
 {
	 TooLessAgeException(String s){
		 super(s);
	 }
 }


public class CustomExceptionsPractice {
	public static void main(String[] args)  {
//		try {
			PersonPractice p1=new PersonPractice(17);
//		} catch (TooHighAgeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
