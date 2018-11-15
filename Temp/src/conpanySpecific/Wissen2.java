package conpanySpecific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Rectangle
{
	int length;
	int breadth;
	public Rectangle(int length, int breadth) 
	{
		super();
		this.length = length;
		this.breadth = breadth;
	}
}
class sortRectangle implements Comparator<Rectangle>
{
	@Override
	public int compare(Rectangle o1, Rectangle o2) 
	{
		if (o1.length != o2.length) {
			return o2.length - o1.length;
		} else {
			return o2.breadth - o1.breadth;
		}
	}
}
public class Wissen2 {

	public static void main(String[] args) 
	{
		/*int MAX_VALUE = 0x7fffffff;
		System.out.println(MAX_VALUE);*/
		Scanner sc=new Scanner(System.in);
		int inputs= Integer.parseInt(sc.nextLine());
		List<Rectangle> list=new ArrayList<>();
		
		for (int i = 0; i < inputs; i++) {
			String a=sc.nextLine();
			String[] arr=a.split(" ");
//			System.out.println(arr[0]+" "+arr[1]);
			list.add(new Rectangle(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
		}
		Collections.sort(list,new sortRectangle());
		
		for (int i = 0; i < list.size(); i++) 
		{
			System.out.println(list.get(i).length+" "+list.get(i).breadth);
		}
	}
/*	5
	7 5
	7 6
	8 7
	3 2
	9 6 */
}
