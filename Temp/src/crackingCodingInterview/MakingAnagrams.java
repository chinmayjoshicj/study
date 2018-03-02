package crackingCodingInterview;

public class MakingAnagrams {

	public static void main(String[] args)
	{
		/*Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();*/
        System.out.println(numberNeeded("abc", "cde"));
	}

	/*private static int numberNeeded(String first, String second) {
		String a="abcdefghijklmnopqrstuvwxyz";
		int count = 0;
			LinkedHashMap<Character, Integer> map1 = new LinkedHashMap<>();
			LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<>();
			
			for (int i = 0; i < a.length(); i++)
			{
				map1.put(a.charAt(i), 0);
				map2.put(a.charAt(i), 0);
			}
			for (int i = 0; i < first.length(); i++)
			{
				map1.put(first.charAt(i),map1.get(first.charAt(i))+1);
			}
			for (int i = 0; i < second.length(); i++)
			{
				map2.put(second.charAt(i),map2.get(second.charAt(i))+1);
			}
			
			for (Character ch : map1.keySet()) 
			{
				count+=Math.max(map1.get(ch)-map2.get(ch),map2.get(ch)-map1.get(ch));
			}
			
			return count;
	} Second Logic*/

	private static int numberNeeded(String a, String b) 
	{
		int arr1[]=countAlphabets(a);
		int arr2[]=countAlphabets(b);
		int count=0;
		
		for (int i = 0; i < arr2.length; i++) 
		{
			count+=Math.max(arr1[i]-arr2[i],arr2[i]-arr1[i]);
		}
		return count;
	}

	private static int[] countAlphabets(String a) 
	{
		int alphabets[]=new int[26];
		for (int i = 0; i < a.length(); i++) 
		{
			alphabets[a.charAt(i)-'a']=alphabets[a.charAt(i)-'a']+1;
		}
		return alphabets;
	}

}
