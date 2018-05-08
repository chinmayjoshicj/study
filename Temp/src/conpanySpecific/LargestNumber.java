package conpanySpecific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int inputs=Integer.parseInt(sc.nextLine());
		ArrayList<String> a=new ArrayList<>();
		
		for (int i = 0; i < inputs; i++)
		{
			String s=sc.nextLine();
			a.add(s);
		}
		
		Collections.sort(a,new Comparator<String>() {
			@Override
			public int compare(String x, String y) {
				
				String xy=x+y;
				String yx=y+x;
				
				return xy.compareTo(yx)>0?-1:1;
			}
		});
		System.out.println(a);
	}
}
