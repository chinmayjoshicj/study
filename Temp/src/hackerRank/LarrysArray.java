package hackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


//InComplete Solution
public class LarrysArray {
	static int A[]= {1,6,5,2,4,3};
		
		static String larrysArray(int[] A) {
			int arr[]=Arrays.copyOf(A, A.length);
			for (int i = 0; i < arr.length-2; i++) {
//				for (int j = i; j <= arr.length-3; j++) {
				int count=0;
				System.out.println("For i="+i);
				while (count<3) {
					int temp1=arr[i];
					int temp2=arr[i+1];
					arr[i+1]=arr[i+2];
					arr[i]=temp2;
					arr[i+2]=temp1;
					for (int k = 0; k < arr.length; k++) {
						System.out.print(arr[k]+" ");
					}
					System.out.println();
					if (check(arr)) {
						System.out.println("YES");
						return "YES";
					}
					count++;
				}
					
				System.out.println();
			}
			
			return "NO";
	    }

	    private static boolean check(int[] arr) {
	    	for (int i = 1; i < arr.length; i++) {
				if (arr[i-1]<=arr[i]) {
					continue;
				}
				else {
					return false;
				}
			}
	    	return true;
		}

		private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	    	
	    	String result = larrysArray(A);
	    	System.out.println(result);
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//	        int t = scanner.nextInt();
//	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//	        for (int tItr = 0; tItr < t; tItr++) {
//	            int n = scanner.nextInt();
//	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//	            int[] A = new int[n];
//
//	            String[] AItems = scanner.nextLine().split(" ");
//	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//	            for (int i = 0; i < n; i++) {
//	                int AItem = Integer.parseInt(AItems[i]);
//	                A[i] = AItem;
//	            }
//
//	            String result = larrysArray(A);
//
//	            bufferedWriter.write(result);
//	            bufferedWriter.newLine();
//	        }
//
//	        bufferedWriter.close();
//
//	        scanner.close();
	    }
}
