package stringManupulations;

/*Given an integer k,and two strings s and t,  
 * determine whether or not you can convert  to  
 * by performing exactly k  of the above operations on s. 
 * If it's possible, print Yes; otherwise, print No.*/


/*One condition Failing mentioned in Input*/
public class AppendAndDelete 
{
	public static void main(String[] args) 
	{
		/*Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();*/
        
        String s="aaa";
        String t="a";
        int k=5;
        
        int count=0;
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int change=0;
        int operDel=0;
//        int iteration=s1.length<s2.length?s1.length:s2.length;
        int i=0;
        if (s.equals(t))
        {
        	System.out.println("Yes");
		}
        else
        {
        	for (i= 0; i < s.length(); i++) 
        	{
        		if (i>=t.length())
        		{
					break;
				}
        		if (s1[i]==s2[i] && change==0)
        		{
        			continue;
				}
        		else
        		{
        			count=count+2;
        			change=1;
        		}
			}
        	operDel=count/2;
        	if ((s1.length-s2.length)>0)
        		count += (s1.length-s2.length);
        	else
        		count += (s2.length-s1.length);
        	
        	//System.out.println(count);
        	if (count==k)
        	{
        		System.out.println("Yes");
			}
        	else if (count<k && (operDel>=s.length()||((s.length()-t.length())-k)%2==0))
        	{
        		System.out.println("Yes");
        	}
        	else
        		System.out.println("No");
        	
        	
        }
	}

}
