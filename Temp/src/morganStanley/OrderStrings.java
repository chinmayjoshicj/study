package morganStanley;

import java.util.Arrays;
import java.util.Scanner;

public class OrderStrings 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		String arr[]=new String[n];
		for (int i = 0; i < n; i++) 
		{
				arr[i]=sc.nextLine();
		}
		String lastLine=sc.nextLine();
		int column=Integer.parseInt(lastLine.split(" ")[0]);
		String order=lastLine.split(" ")[1];
		String typeSort=lastLine.split(" ")[2];
		
		Double sortArr[]=new Double[n];
		String sortArrLexi[]=new String[n];
		for (int i = 0; i < sortArr.length; i++) 
		{
				if (typeSort.equals("numeric")) 
				{
//					sortArr[i]=Integer.parseInt(arr[i].split(" ")[column-1]);
				}
				else
					sortArrLexi[i]=arr[i].split(" ")[column-1];
		}
		if (order.equals("false"))
		{
			if (typeSort.equals("numeric"))
			{
				Arrays.sort(sortArr);
			}
			if (!typeSort.equals("numeric"))
			{
				Arrays.sort(sortArrLexi);
			}
		}
		for (int i = 0; i < sortArrLexi.length; i++)
		{
			for (int j = 0; j < sortArrLexi.length; j++)
			{
				
			}
		}
	}
}
