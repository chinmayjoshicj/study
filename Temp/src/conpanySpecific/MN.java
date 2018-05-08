package conpanySpecific;

import java.util.Stack;

public class MN {

/*	2. Given a sequence of M and N with M representing increasing and N representing decreasing, output the smallest number that follows this pattern.
	Input : MMMM
	Output : 12345

	Input : NNNN
	Output : 54321

	Input : MMNM
	Output : 2314*/
	
	
	public static void main(String[] args) 
	{
			String cond="MMNM";
			Stack<Integer> s= new Stack<>();
			
			int num=1;
			
			String s1="";
			for (int i = 0; i <= cond.length(); i++)
			{
				s.push(i+1);
				if (i==cond.length() || cond.charAt(i)=='M') {
					while(!s.isEmpty())		
					{
						s1=s1+s.pop()+"";
					}
				}
			}
			System.out.println(s1);
	}
}
