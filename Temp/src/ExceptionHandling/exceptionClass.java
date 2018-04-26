package ExceptionHandling;

/*
Throwable (Root This is  class, not an Interface like others Cloneable,Runnable,Serializable all are Interfaces) . It has 2 CHILD Classes

Exception:  
1) Most of the times Exception are caused by our program. Say you are reading a file you will get FileNotFoundException
2) Exception are RECOVERABLE. 
	Say you are reading a file located at some Location say at Server. If FileNotFoundException Occurs the We can say Please use file from LOCAL Machine in catch BLOCK.
	So Exceptions are RECOVERABLE.

Error: 

1) Not Caused by our program, normally it is caused by lack of resources. Say OutOfMemoryError.

2) NonRecoverable.

 * try {
		// block of code to monitor for errors
		// the code you think can raise an exception
}
catch (ExceptionType1 exOb) {
	// exception handler for ExceptionType1
}
catch (ExceptionType2 exOb) {
	// exception handler for ExceptionType2
}
	// optional
finally {
	// block of code to be executed after try block ends
}*/


/*
1) A CATCH clause CANNOT exist WITHOUT A TRY statement.

2) It is NOT COMPULSORY to have FINALLY clauses whenever a TRY/CATCH BLOCK IS PRESENT.

3) The TRY BLOCK CANNOT be present without EITHER CATCH CLAUSE OR FINALLY CLAUSE.

4) Any CODE CANNOT BE PRESENT IN BETWEEN the TRY, CATCH, FINALLY blocks.*/


/* CASE 1: Exception occurs in try block and handled in catch block: 

	If a statement in try block raised an exception, 
	then the rest of the try block doesn’t execute and control passes to the corresponding catch block.
	After executing catch block, 
	the control will be transferred to finally block(if present) and then rest program will be executed.


Throwable(Root This is  class not an Interface like others Cloneable,Runnable,Serializable all are Interfaces) . It has 2 CHILD Classes

Exception:  
1) Most of the times Exception are caused by our program. Say you are reading a file you will get FileNotFoundException
2) Exception are RECOVERABLE. 
	Say you are reading a file located at some Location say at Server. If FileNotFoundException Occurs the We can say Please use file from LOCAL Machine in catch BLOCK.
	So Exceptions are RECOVERABLE.

Error: 

1) Not Caused by our program, normally it is caused by lack of resources. Say OutOfMemoryError.

2) NonRecoverable.



Difference Between Checked and UnCheckedException


Checked:

Say we create a writer object to abc.txt file.
Then will try compile this code.
Then immediately Compile will say at runtime compiler will say unreported Exception java.io.FileNotFoundException must be caught or declared to be thrown.
Here Advantage is that at RunTime program will not face any issues.


 Unchecked Exception
 
 This compiler will not check.
 Occurs at RunTime.
 Say 10/0. This compiler will never.(ArithmaticException)
 Compulsary it will occur at RunTime.
 
 
*/
public class exceptionClass 
{
	public static void main(String[] args) 
	{
		// array of size 4.
        int[] arr = new int[4];
        try
        {
            int i = arr[4];
                 
            // this statement will never execute
            // as exception is raised by above statement
            System.out.println("Inside try block");
        }
        // not a appropriate handler
        catch(NullPointerException ex)
        {
            System.out.println("Exception has been caught");
        }
        /*catch(ArrayIndexOutOfBoundsException ex) //Actual Exception to be catch
        {
            System.out.println("Exception caught in Catch block");
        }*/
        finally
        {
            System.out.println("finally block executed");
        }
         
        // rest program will be excuted
        System.out.println("Outside try-catch clause");
	}

}
