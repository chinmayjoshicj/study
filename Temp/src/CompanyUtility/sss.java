package CompanyUtility;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class sss {

    public Set<String> findWords(char[][] puzzle, Set<String> words) {
        Set<String> foundWords = new HashSet<String>();
        int minimumWordLength = findMinimumWordLength(words);
        Set<String> possibleWords = findPossibleWords(puzzle, minimumWordLength);
        for(String word : words) {
            for(String possibleWord : possibleWords) {
                if(possibleWord.contains(word) || possibleWord.contains(new StringBuffer(word).reverse())) {
                    foundWords.add(word);
                    break;
                }
            }
        }       
        return foundWords;
    }

    private int findMinimumWordLength(Set<String> words) {
        int minimumLength = Integer.MAX_VALUE;
        for(String word : words) {
            if(word.length() < minimumLength)
                minimumLength = word.length();
        }
        return minimumLength;
    }

    private Set<String> findPossibleWords(char[][] puzzle, int minimumWordLength) {
        Set<String> possibleWords = new LinkedHashSet<String>();
        int dimension = puzzle.length; //Assuming puzzle is square
        if(dimension >= minimumWordLength) {
            /* Every row in the puzzle is added as a possible word holder */
            for(int i = 0; i < dimension; i++) {
                if(puzzle[i].length >= minimumWordLength) {
                    possibleWords.add(new String(puzzle[i]));
                }
            }
            /* Every column in the puzzle is added as a possible word holder */
            for(int i = 0; i < dimension; i++) {
                StringBuffer temp = new StringBuffer();
                for(int j = 0; j < dimension; j++) {
                    temp = temp.append(puzzle[j][i]);
                }
                possibleWords.add(new String(temp));
            }
            /* Adding principle diagonal word holders */
            StringBuffer temp1 = new StringBuffer();
            StringBuffer temp2 = new StringBuffer();
            for(int i = 0; i < dimension; i++) {
                temp1 = temp1.append(puzzle[i][i]);
                temp2 = temp2.append(puzzle[i][dimension - i - 1]);
            }
            possibleWords.add(new String(temp1));
            possibleWords.add(new String(temp2));
            /* Adding non-principle diagonal word holders */
            for(int i = 1; i < dimension - minimumWordLength; i++) {
                temp1 = new StringBuffer();
                temp2 = new StringBuffer();
                StringBuffer temp3 = new StringBuffer();
                StringBuffer temp4 = new StringBuffer();
                for(int j = i, k = 0; j < dimension && k < dimension; j++, k++) {
                    temp1 = temp1.append(puzzle[j][k]);
                    temp2 = temp2.append(puzzle[k][j]);
                    temp3 = temp3.append(puzzle[dimension - j - 1][k]);
                    temp4 = temp4.append(puzzle[dimension - k - 1][j]);
                }
                possibleWords.add(new String(temp1));
                possibleWords.add(new String(temp2));
                possibleWords.add(new String(temp3));
                possibleWords.add(new String(temp4));
            }
        }
        return possibleWords;
    }

    public static void main(String args[]) {
    	sss program = new sss();
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
        
        String arr[]={/*"Abhay", "Kumar" , "Anupam", "Saurabh",
      		  "Aruneesh", "Shukla" , "Ashish", "Gupta" ,
      		  "Dhananjay", "Gopalakrishna" , "Harish" ,"RSB" ,*/
      		  "Hemavathy" ,/*"Venkataramaiah" , "Lata" ,"Chavan" ,"Mahima" ,"Venkatesh", "Lakshmikant" ,"Sharma" , "Pankaj", "Kumar", "Pankaj" ,
      		  "Sahu", "Prasannakumar" ,"Vasudevamurthy" ,"Ramesh" ,"Ganesan", "Ravi", "Shankar", "Sanjay", "Murthy", "Situ", "Singh", "Srijit", 
      		  "Mukherjee", "Srinivasa" ,"Reddy", "Surendra" ,"Pachchipulsu", "Swarna", "Varun", "Khulbey" ,  "Venkat", "Bollapragada","Vyas", "Krishna"*/};
        
        for (int i = 0; i < arr.length; i++) 
        {
        	words.add(arr[i]);
        	words.add(new String(new StringBuffer(arr[i]).reverse()));
		}
        Set<String> wordsFound = program.findWords(puzzle, words);
        for(String word : wordsFound) {
            System.out.println(word);
        }
    }
}