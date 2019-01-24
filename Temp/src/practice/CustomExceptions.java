package practice;

class Person {
	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int age, String name) throws MoreAgeException, LessAgeException {
		super();
		if (age > 35) {
			throw new MoreAgeException("Too old");
		}
		if (age < 18) {
			throw new LessAgeException("Too Young");
		}
		this.age = age;
		this.name = name;
	}
}

class LessAgeException extends Exception {
	public LessAgeException(String string) {
		super(string);// TODO Auto-generated constructor stub
	}
}

class MoreAgeException extends Exception {
	public MoreAgeException(String string) {
		super(string);
	}
}

public class CustomExceptions {

	public static void main(String[] args) {
		try {

			Person p1 = new Person(12, "sasd");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			Person p2 = new Person(36, "sasd");
		} catch (MoreAgeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		} catch (LessAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
