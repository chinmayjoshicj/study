package ExceptionHandling;

public class customException  extends RuntimeException {

	/*If a method does not handle a checked exception, the method must declare it using the throws keyword. 
	 
	 * The throws keyword appears at the end of a method's signature.
	 
		You can throw an exception, either a newly instantiated one or 
		an exception that you just caught, by using the throw keyword.
		Try to understand the difference between throws and throw keywords, 
		throws is used to postpone the handling of a checked exception and throw is used to invoke an exception explicitly.*/
	
	/*A method can declare that it THROWS more than one exception, 
	in which case the exceptions are declared in a LIST SEPARATED BY COMMAS. 
	For example, the following method declares that it throws a REMOTEEXCEPTION and an INSUFFICIENTFUNDSEXCEPTION*/
	
		private static final long serialVersionUID = 4664456874499611218L;
		
		private String errorCode="Unknown_Exception";
		
		public customException(String message, String errorCode)
		{
			super(message);
			this.errorCode=errorCode;
		}
		
		public String getErrorCode(){
			return this.errorCode;
		}

	}