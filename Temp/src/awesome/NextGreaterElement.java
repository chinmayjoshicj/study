package awesome;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) 
	{
		int a[]={2,4,1,7,5,9};
		Stack<Integer> s= new Stack<>();
		int i=0;
		while(i<a.length-1)
		{
			s.push(a[i++]);
			Integer peek = s.peek();
			if(peek<a[i])
			{
				while(!s.isEmpty()){
					peek=s.pop();
					System.out.println(peek+"-"+a[i]);
				}
			}
		}
	}

}

