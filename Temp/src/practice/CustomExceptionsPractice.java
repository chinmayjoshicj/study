package practice;

class PersonPractice {
	int age;

	public void setAge(int age) {
		this.age = age;
	}

	public PersonPractice(int age) throws MoreAgeException, LowAgeException {
		super();
		if (age > 40) {
			throw new MoreAgeException("Too Old");
		}
		if (age < 18) {
			throw new LowAgeException("Too Young");
		}
		this.age = age;
	}
}

class MoreAgeException extends Exception {
	public MoreAgeException(String string) {
		super(string);
	}
}

class LowAgeException extends Exception {
	public LowAgeException(String string) {
		super(string);
	}
}

public class CustomExceptionsPractice {
	public static void main(String[] args) {
		try {
			PersonPractice p = new PersonPractice(0);
		} catch (MoreAgeException | LowAgeException e) {
			System.out.println(e.getMessage());
		}
		try {
			PersonPractice p1 = new PersonPractice(70);
		} catch (MoreAgeException | LowAgeException e) {
			System.out.println(e.getMessage());
		}
	}
}
