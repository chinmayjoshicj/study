package awesome;

import java.util.Scanner;

public class ArrayLeftRotation {

	private static int[] arrayLeftRotation(int[] a, int n, int k) 
	{
		int[] output = new int[n];
		int j=0;
        for (int i = k; i < output.length; i++)
        {
			output[j++]=a[i];
		}
	      for (int i = 0; i < k; i++)
	      {
			output[j++]=a[i];
	      }
	return output;
	
	
	/*k=a.length-k;
	int b[]=new int[a.length];
	for (int i = 0; i < b.length; i++) {
		b[i]=a[i];
	}
	for (int i = 0; i < a.length; i++) 
	{
			a[(i+k)%a.length]=b[i];
	}
	return a;*/
}
	
	public static void main(String[] args) 
	{
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	      
	        int[] output = new int[n];
	        output = arrayLeftRotation(a, n, k);
	        for(int i = 0; i < n; i++)
	            System.out.print(output[i] + " ");
	      
	        System.out.println();
	}


}
