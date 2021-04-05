package hackerRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BearAndSteadyGene {

static int steadyGene(String gene) {
	
	HashMap<Character, Integer> charMap=new HashMap<Character, Integer>();
	charMap.put('A',0);
	charMap.put('T',0);
	charMap.put('G',0);
	charMap.put('C',0);
	for (int i = 0; i < gene.length(); i++) {
		if (charMap.containsKey(gene.charAt(i))) {
			Integer count = charMap.get(gene.charAt(i));
			charMap.put(gene.charAt(i), count+1);
		}
	}
	
	for (Entry<Character, Integer> entry : charMap.entrySet()) { 
    System.out.println("Key = " + entry.getKey() + 
                     ", Value = " + entry.getValue()); 
	
	}
	return 0; 
	
}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        String gene = scanner.nextLine();
    	String gene="GAAATAAA";
        int result = steadyGene(gene);	
        System.out.println();
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

