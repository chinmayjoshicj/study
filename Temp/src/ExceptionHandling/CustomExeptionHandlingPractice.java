package ExceptionHandling;

public class CustomExeptionHandlingPractice 
{
	public static void main(String[] args) 
	{
		try
		{
			Person p2= new Person("Ameya", 32);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		try
		{
			Person p1= new Person("Chinmay", 19);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
class ToYoungException extends RuntimeException
{
	public ToYoungException(String s) 
	{
		super(s);
	}
}
class ToOldException extends RuntimeException
{
	public ToOldException(String s) 
	{
		super(s);
	}
}
class Person
{
	int age;
	String name;
	
	public Person(String name, int age) 
	{
		if (age>30) {
			throw new ToOldException(name+" You are Too Old");
		}
		else if (age<18) {
			throw new ToYoungException(name+" Too Young");
		}
		else
		{
			this.name=name;
			this.age=age;
			
			System.out.println(name+" You are Prefect");
		}
	}
}