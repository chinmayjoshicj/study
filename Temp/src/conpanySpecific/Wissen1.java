package conpanySpecific;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;


class myComparatorLeast implements Comparator<Map.Entry<Integer, Integer>>
{
	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
	{
		if (o1.getValue()==o2.getValue())
		{
			return o2.getKey()-o1.getKey();
		}
		else
			return o1.getValue()-o2.getValue();
	}
}
class myComparatorMost implements Comparator<Map.Entry<Integer, Integer>>
{
	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
	{
		if (o1.getValue()==o2.getValue())
		{
			return o1.getKey()-o2.getKey();
		}
		else
			return o2.getValue()-o1.getValue();
	}
}
public class Wissen1 {

	public static void main(String[] args)
	{
		List<Integer> list =  new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		int inputs= Integer.parseInt(sc.nextLine());
		HashMap<Integer, List<Integer>> mapForDel= new HashMap<>();
		LinkedHashMap<Integer, Integer> freqMap = new LinkedHashMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> pqLeastFreq= new PriorityQueue<>(new myComparatorLeast());
		PriorityQueue<Map.Entry<Integer, Integer>> pqMostFreq= new PriorityQueue<>(new myComparatorMost());
		for (int i = 0; i < inputs; i++) 
		{
			//System.out.println("What you want to perform:");
			int a=sc.nextInt();
			switch (a) {
			case 1:
				//System.out.println("What You want to add:");
				Integer num=sc.nextInt();
				list.add(num);
				if (mapForDel.containsKey(num))
				{
					List<Integer>l=mapForDel.get(num);
					l.add(list.size()-1);
					mapForDel.put(num, l);
					freqMap.put(num, freqMap.get(num)+1);
					pqMostFreq.clear();
					pqMostFreq.addAll(freqMap.entrySet());
					pqLeastFreq.clear();
					pqLeastFreq.addAll(freqMap.entrySet());
					
					//System.out.println("Chinmay ");
					/*while (!pqMostFreq.isEmpty()) {
						System.out.println(pqMostFreq.peek().getKey()+" "+pqMostFreq.peek().getValue());
						pqMostFreq.poll();
					}*/
				}
				else
				{
					List<Integer>l=new ArrayList<>();
					l.add(list.size()-1);
					mapForDel.put(num,l);
					freqMap.put(num, 1);
					pqMostFreq.clear();
					pqMostFreq.addAll(freqMap.entrySet());
					pqLeastFreq.clear();
					pqLeastFreq.addAll(freqMap.entrySet());
//					System.out.println("Priority Queue");
					/*while (!pqMostFreq.isEmpty()) {
		                System.out.println(pqMostFreq.peek().getKey()+" "+pqMostFreq.peek().getValue());
		                pqMostFreq.poll();
					}*/
				}
				break;
			
			case 2:
				//System.out.println("What You want to Delete:");
				Integer remVal=sc.nextInt();
				if (mapForDel.containsKey(remVal))
				{
					List<Integer> indexArr=mapForDel.get(remVal);
					int removeIndex=indexArr.get(0);
					indexArr.remove(0);
					mapForDel.put(remVal, indexArr);
					list.remove(removeIndex);
					freqMap.put(remVal, freqMap.get(remVal)-1);
					if (freqMap.get(remVal)==0) {
						freqMap.remove(remVal);
					}
					
					pqMostFreq.clear();
					pqMostFreq.addAll(freqMap.entrySet());
					pqLeastFreq.clear();
					pqLeastFreq.addAll(freqMap.entrySet());
				}
				else
				{
					System.out.println("No Existance");
				}
				break;
			
			case 3:
				System.out.println(pqMostFreq.peek().getKey());
				break;	
			case 4:
				System.out.println(pqLeastFreq.peek().getKey());
				break;
			default:
				break;
			}			
		}
	}
}