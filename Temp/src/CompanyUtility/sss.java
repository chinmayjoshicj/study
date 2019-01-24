package CompanyUtility;

import java.util.HashMap;
import java.util.Map;

public class sss {

	private static String a="";
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		return result;
	}
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		sss other = (sss) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		return true;
	}*/
	public static void main(String args[]) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put(a, "ABC");
		map.put(a, "ABC");
		System.out.println(map.size());
    	/*sss program = new sss();
    	 * 
        char[][] puzzle = { 
        	  { 'V', 'L','K','P','N','I','I','O','R','V','B','S','N','Q','U'},
  			  { 'G','A','G','D','D','T','B','S','K','F','B','X','R','F','C' },
  			  { 'A','U','N','B','O','C','Z','V','X','Y','K','P','V','X','R' },
  			  { 'X','M','H','V','Y','G','R','Q','W','H','U','K','Z','M','D' },
  			  { 'E','O','K','O','F','K','A','L','R','T','C','G','H','Z','X' },
  			  { 'U','E','Z','H','S','K','S','W','W','A','L','Z','D','G','A' },
  			  { 'R','A','T','K','Y','D','Z','H','Y','V','S','U','K','I','Q' },
  			  { 'E','X','U','O','S','Q','X','O','T','A','S','G','V','G','P' },
  			  { 'Q','R','S','C','T','Z','K','T','Y','M','I','U','N','I','F' },
  			  { 'D','R','F','S','S','Z','K','Y','T','E','Z','Z','M','A','R' } ,
  			  { 'B','F','M','M','K','H','H','H','T','H','K','X','W','U','G' },
  			  {'S','N','P','L','O','C','Z','J','T','V','B','O','I','B','A'  },
  			  {'D','K','P','H','Q','Y','W','W','A','U','V','V','V','Q','O'  },
  			  {'D','X','T','R','V','Y','L','K','H','Q','F','S','V','Y','U'  },
  			  {'P','M','O','T','T','C','P','B','O','S','W','D','C','D','V'  }
                          };
        Set<String> words = new HashSet<String>();
        
        String arr[]={"Abhay", "Kumar" , "Anupam", "Saurabh",
      		  "Aruneesh", "Shukla" , "Ashish", "Gupta" ,
      		  "Dhananjay", "Gopalakrishna" , "Harish" ,"RSB" ,
      		  "Hemavathy" ,"Venkataramaiah" , "Lata" ,"Chavan" ,"Mahima" ,"Venkatesh", "Lakshmikant" ,"Sharma" , "Pankaj", "Kumar", "Pankaj" ,
      		  "Sahu", "Prasannakumar" ,"Vasudevamurthy" ,"Ramesh" ,"Ganesan", "Ravi", "Shankar", "Sanjay", "Murthy", "Situ", "Singh", "Srijit", 
      		  "Mukherjee", "Srinivasa" ,"Reddy", "Surendra" ,"Pachchipulsu", "Swarna", "Varun", "Khulbey" ,  "Venkat", "Bollapragada","Vyas", "Krishna"};
        
        for (int i = 0; i < arr.length; i++) 
        {
        	words.add(arr[i]);
        	words.add(new String(new StringBuffer(arr[i]).reverse()));
		}
        Set<String> wordsFound = program.findWords(puzzle, words);
        for(String word : wordsFound) {
            System.out.println(word);
        }*/
    }
}