package crackingCodingInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class RansomNote 
{
	Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note) 
    {
    	magazineMap=new HashMap<>();
    	noteMap=new HashMap<>();
    	String a[]=magazine.split(" ");
        for (int i = 0; i < a.length; i++)
        {
        	if (magazineMap.containsKey(a[i]))
        	{
        		magazineMap.put(a[i], magazineMap.get(a[i])+1);
			}
        	else
        		magazineMap.put(a[i], 1);
		}
        a=note.split(" ");
        for (int i = 0; i < a.length; i++) 
        {
        	if (noteMap.containsKey(a[i]))
        	{
        		noteMap.put(a[i], noteMap.get(a[i])+1);
			}
        	else
        		noteMap.put(a[i], 1);
		}
        
    }
    
    public boolean solve() 
    {
    	for (Entry<String, Integer> entry : noteMap.entrySet())
		{
    		
    		String key=entry.getKey();
    		int count=noteMap.get(key);
    		/*while(count!=0)
    		{*/
    			
			    if (!magazineMap.containsKey(key))
			    {
					return false;
				}
			    else
			    {
			    	if (magazineMap.get(key)==0) 
			    	{
			    		return false;
					}
			    	else
			    	{
			    		magazineMap.put(key, magazineMap.get(key)-1);
			    	}
			    /*}
			    count--;*/
    		}
		}
		return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }

}
