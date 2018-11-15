package practice;

public class BalanceParenthesisPractice 
{
	public static void main(String[] args) 
	{
		String exp="[()]{}{[()()]()}";
		
		System.out.println(method(exp,0,exp.length()-1));
	}
	private static boolean method(String exp, int start, int end) 
	{
		if (start>end) {
			return false;
		}
		char closing = 0;
		if (exp.charAt(start)=='}' || exp.charAt(start)==']' || exp.charAt(start)==')')
		{
			return false;
		}
		if (exp.charAt(start)=='(')
		{
			closing=')';
		}
		if (exp.charAt(start)=='[')
		{
			closing=']';
		}
		if (exp.charAt(start)=='{')
		{
			closing='}';
		}
		
		int count=0;
		int i=start;
		for (i = start; i <= end; i++) 
		{
			if (exp.charAt(i)==exp.charAt(start))
			{
				count++;
			}
			if (exp.charAt(i)==closing) 
			{
				if (count==0) {
					break;	
				}
				count--;
			}
		}
		if (i==end) {
			return false;
		}
		if (i==1)
		{
			return method(exp, start+2, end);
		}
		return method(exp, start+1, i-1) && method(exp, i+1, end);
		 
	}
}
