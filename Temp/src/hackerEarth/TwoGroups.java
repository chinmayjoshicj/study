package hackerEarth;

import java.util.Scanner;
/*Incomplete*/
public class TwoGroups {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for (int i = 0; i < n; i++) 
		{
			/*calculateFact(sc.nextInt()%(Math.pow(10, 9)+7));*/
			System.out.println((Math.pow(2,sc.nextInt()-1)-1)*2%(Math.pow(10, 9)+7));
		}
	}

}
