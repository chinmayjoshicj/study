package hackerEarth;

import java.util.Scanner;

/*Sorted Arrays
Alice has recently found an array a
containing N integers. As we all know Alice loves sorted array so, 
he wants to sort the array.
To sort an array Alice can add 1 to any integer in the array in 1 move.
Alice wants to find minimum number of moves needed to sort this array. 
Remember that after sorting the array, all elements in it should be distinct.*/

public class SortAnArray {

	public static void main(String[] args) 
	{
		 Scanner s = new Scanner(System.in);
	     String n = s.nextLine();
	     int arr[]=new int[Integer.parseInt(n)];
	     for (int i = 0; i < arr.length; i++) 
	     {
	    	 arr[i]=s.nextInt();
	     }
	     int count=0;
	     for (int i = 0; i < arr.length-1; i++) 
	     {
	    	 if (arr[i+1]<arr[i])
	    	 {
	    		 count+=arr[i]-arr[i+1];
	    		 arr[i+1]=arr[i+1]+(arr[i]-arr[i+1]);
	    	 }
	    	 if (arr[i+1]==arr[i])
	    	 {
	    		 count+=1;
	    		 arr[i+1]=arr[i+1]+1;
	    	 }
	     }
	     System.out.println(count);
	}

}
