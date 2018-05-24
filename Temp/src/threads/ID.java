package threads;
/*
 * ID Class contains the synchronized keyword to prevent
 * multiple threads from accessing the getID() method at the same time
 */

public class ID 
{
   private static int counter; // initialized to 0 by default
   public static synchronized int getID()
   {
	   System.out.print(Thread.currentThread().getName()+" ");
	   System.out.println(counter++);
      return counter;
   }

    
}
