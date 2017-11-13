package hackerEarth;

import java.util.Scanner;

/*
 A group of friends is going on a vacation to a beach by a car. One of them is suffering from a severe fever and needs to be taken to hospital in nearest town immediately.

Assume that car consumes one unit of petrol every unit of distance it travels. The hospital is located in town situated at co-ordinate 0. The car is D
units away from the town. On this road, between the town and the current location of the car, there are N

petrol stations where the friends can stop to acquire additional petrol.

As the fever is getting worse with time, the friends want to make the minimum possible number of stops for petrol on the way to the town. Fortunately, the capacity of the petrol tank on their car is so large that there is no limit to the amount of petrol it can hold. The car has some initial amount of petrol in tank which is denoted by P

.

Determine the minimum number of stops needed to reach the town, or if the freinds cannot reach the town at all.

Note:
The town is situated at co-ordinate 0. All the other distances are given with respect to town's location.

Input Format:

    First line contains an integer N

, number of petrol stations on the way to town.
Each of the next N
lines contains 2 space-separated integers S and F describing a petrol station: S, the distance from the town to the station and F
, the amount of petrol available at that station.
Next line contains 2
space separated integers D and P

    .

Output Format:

    Output a single integer giving the minimum number of stops necessary to reach the town. If it is not possible to reach the town, output −1

    .

Input Constraints:

    1≤N≤105

1≤D,P,S,F≤109

Sample Input

4

3 15

6 4

8 5

15 6

20 17

Sample Output

1

Explanation

There are 4 petrol stations on the way to town at distance 3, 6, 8, 15 from the town. These fuel stops can supply up to 15, 4, 5, and 6 units of petrol, respectively. The car is currently located 20 units away from the town. The car has 17 units of petrol initially.

Car drives 17 units and stops at station at distance 3 from the town to acquire petrol and drives to the town. Thus minimum number of stops required to drive to the town is 1.
Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.*/

/*Incomlete*/
public class FeverHelp {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
        String n = s.nextLine();// no of petrol pumps
        Long petrolPumpTownDist[]=new Long[Integer.parseInt(n)];
        Long amountPetrolAvailable[]=new Long[Integer.parseInt(n)];
        
        Long maxPetrolAvail=(long) 0;
        
        for (int i = 0; i < amountPetrolAvailable.length; i++) 
        {
        	petrolPumpTownDist[i]=s.nextLong();
        	amountPetrolAvailable[i]=s.nextLong();
        	maxPetrolAvail+=amountPetrolAvailable[i];
		}
       
		Long d=s.nextLong();//units away from town
		Long p=s.nextLong();//amount of petrol available
		
		Long moreNeededPetorl=d-p;
		 
		if (d>maxPetrolAvail && d>p) 
		{
			System.out.println("-1");
			System.exit(0);
		}
		if (p>=d) 
		{
			System.out.println("0");
			System.exit(0);
		}
		Long tempPetrol[]=new Long[Integer.parseInt(n)];
		
		tempPetrol=amountPetrolAvailable.clone();
		int maxindex=getmMax(amountPetrolAvailable);
		amountPetrolAvailable[maxindex]=(long) -1;
		
		int stopages=0;
		
		for (int i = 0; i < tempPetrol.length; i++) 
		{
			if (d>tempPetrol[maxindex]+p)
			{
				maxindex=getmMax(amountPetrolAvailable);
			}
			else
			{
				stopages+=1;
			}
			d=petrolPumpTownDist[maxindex];
			p=p-petrolPumpTownDist[maxindex];
			if (d<=0 || p>=d)
			{
				break;
			}
			
			moreNeededPetorl=moreNeededPetorl-amountPetrolAvailable[maxindex];
		}
		/*if ( )
		{
			
		}*/
		System.out.println(stopages);
	}

	private static int getmMax(Long[] amountPetrolAvailable) 
	{
		Long max=(long) 0;
		int index=-1;
		for (int i = 0; i < amountPetrolAvailable.length; i++) 
		{
			if (max<amountPetrolAvailable[i])
			{
				max=amountPetrolAvailable[i];
				index=i;
			}
		}
		return index;
	}

}
