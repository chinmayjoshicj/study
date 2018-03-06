package javaPractice;

public class StaticMethodOverridingParent 
{
    public static void display()
    {
        System.out.println("Welcome to Parent Class");
    }
}
 class Child extends StaticMethodOverridingParent
{
    public static void display()
    {
        System.out.println("Welcome to Child class");
    }
    public static void main(String args[]) 
    {
        //Assign Child class object to Parent reference
        StaticMethodOverridingParent pc = new Child();
        pc.display();
     }
}