package ExceptionHandling;

/*try {
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
	the control will be transferred to finally block(if present) and then rest program will be executed.*/

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
