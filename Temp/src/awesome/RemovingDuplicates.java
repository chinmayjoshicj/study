package awesome;

import java.util.Scanner;

public class RemovingDuplicates 
{
	 /*static String s="baab";
	    public static void main(String[] args)
	    {
	        char a[]=s.toCharArray();
	        removeDuplicates(a,0);
	        if (s.isEmpty())
	        {
	        	System.out.println("Empty String");
			}
	        else
	        {
	        	System.out.println(s);
	        }
	    }

	    private static void removeDuplicates(char[] a, int start) 
	    {
	        int i=0;
	        if (start>=a.length-1)
	        {
	            s=String.valueOf(a);
	            return;
	        }
	        for (i = 0; i < a.length-1; i++)
	        {
	            if (a[i]==a[i+1])
	            {
	                int k=i;
	                for (int j = i+2; j < a.length; j++) 
	                {
	                    a[k++]=a[j];
	                }
	                i--;
	                String s=String.valueOf(a);
	                a=s.substring(0, a.length-2).toCharArray();
	                break;
	            }
	        }
	        removeDuplicates(a, i);
	    }*/
	static String ss=null;
    static String super_reduced_string(String s)
    {
        ss=s;
            char a[]=ss.toCharArray();
	        removeDuplicates(a,0);
	        if (ss.isEmpty())
	        {
	        	System.out.println("Empty String");
	        }
			return ss;
    }
     private static void removeDuplicates(char[] a, int start) 
	    {
	        int i=0;
	        if (start>=a.length-1)
	        {
	            ss=String.valueOf(a);
	            return;
	        }
	        for (i = 0; i < a.length-1; i++)
	        {
	            if (a[i]==a[i+1])
	            {
	                int k=i;
	                for (int j = i+2; j < a.length; j++) 
	                {
	                    a[k++]=a[j];
	                }
	                i--;
	                String s=String.valueOf(a);
	                a=s.substring(0, a.length-2).toCharArray();
	                break;
	            }
	        }
	        removeDuplicates(a, i);
	    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
