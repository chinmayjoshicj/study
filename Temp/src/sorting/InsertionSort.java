package sorting;

import java.util.Scanner;

public class InsertionSort {

	public static void insertionSortPart2(int[] ar)
    {       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
		if (ar.length==0)
		{
			System.out.println("Length of Array id Zero");
		}
		for (int i = 1; i < ar.length; i++) 
		{
			for (int j = 0; j < i; j++)
			{
				if (ar[j]>ar[i])
				{
					int temp=ar[j];
					ar[j]=ar[i];
					ar[i]=temp;
				}
			}
			printArray(ar);
		}
    }  
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }

}
