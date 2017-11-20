package hackerEarth;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

/*Architect's Dilemma..!

An Architect has been assigned a project and some number of workers work for him. 
Each of the workers is assigned a fixed amount of work. 
Suddenly, he has been appointed to build a new elegant office by the mayor.
 He won't disappoint mayor and finish the task as quickly as possible.
Now, the architect has some amount of extra work to build the new office.
He wants to assign this extra work to workers in such a way that there are maximum number of workers with same amount of total work. 
It might not be possible to give equal amount of work to each worker. 
He wants to find maximum number of workers possible with same amount of total work. 
It is not necessary that architect assigns all of his extra work.

Input Format:

First line has two integers N , number of workers and W , amount of extra work architect has.
The second line contains N integers separated by single space, a1,a2,....,an
where ai is the amount of fixed work ith

worker has.

Output Format:

Output maximum number of workers that have equal amount of total work.

Input Constraints:
1≤N≤105

1≤W≤107
1≤ai≤106

Sample Input

4 5

5 5 3 1

Sample Output

3

*/
public class ArchitechDilema 
{
	
		    public static void main(String args[] ) throws Exception {
		        Scanner sc=new Scanner(System.in);
				int n=sc.nextInt();
				Long w=sc.nextLong();
				
				Long sum=(long) 0;
				long arr[]=new long[n];
				for (int i = 0; i < n; i++) 
				{
					arr[i]=sc.nextLong();
					sum+=arr[i];
				}
				sum=sum+w;
				Arrays.sort(arr);
				int count=0;
				long conv = convertTo(arr);
				if (sum%n<=conv)
				{
					for (int i = arr.length-1; i >=0; i--) 
					{
						if (arr[i]>conv) {
							continue;
						}
						Long diff=conv-arr[i];
						if (arr[i]!=arr[arr.length-1] && w>0 && diff<=w) 
						{
							arr[i]+=diff;
							w=w-diff;
						}
					}
					for (int i = 0; i < arr.length; i++) 
					{
						if (arr[i]==conv)
						{
							count++;
						}
					}
				}
				else
				{
					count=n;
				}
				System.out.println(count);

		    }
		    static long convertTo(long[] arr){
		    	long maxc=1, c=1, prev=0, retval=0;
		    	for(long i:arr){
		    		if(i==prev){
		    			c++;
		    			continue;
		    		}
		    		else if(c>maxc){
		    			maxc = c;
		    			retval = i;
		    		}
		    		c=1;
		    	}
		    	if(retval>0)
		    	return retval;
		    	else
		    		return arr[arr.length/2];
		    }

}
