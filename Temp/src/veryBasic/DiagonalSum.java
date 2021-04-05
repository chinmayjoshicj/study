package veryBasic;

import java.io.IOException;

//public class DiagonalSum {
//
//	public static void main(String[] args) {
//		/*
//	     * Complete the 'diagonalDifference' function below.
//	     *
//	     * The function is expected to return an INTEGER.
//	     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
//	     */
//
//	    public static int diagonalDifference(List<List<Integer>> arr) {
//	    // Write your code here
//	    int sum1=0;
//	        int sum2=0;
//	        for (int i = 0; i < arr.size(); i++) {
//	            for (int j = 0; j < arr.size(); j++) {
//	                
//	                System.out.println("i "+i+" j "+j+" val "+arr[i][j]);
//	                if(i==j) {
//	                    sum1+=arr[i][j];                    
//	                }
//	                if(i+j==arr.length-1) {
//	                    sum2+=arr[i][j];                    
//	                }
//	            }
//	        }
//	    return sum1-sum2;
//
//	}

	public class DiagonalSum {
	    public static void main(String[] args) throws IOException {

//	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        int[][] arr = {{1, 2}, {3, 4}};

	       System.out.println(diagonalDifference(arr));
	       
	    }

		private static int diagonalDifference(int[][] arr) {
			int sum1=0;
	        int sum2=0;
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr[0].length; j++) {
	                
	                System.out.println("i "+i+" j "+j+" val "+arr[i][j]);
	                if(i==j) {
	                    sum1+=arr[i][j];                    
	                }
	                if(i+j==arr.length-1) {
	                    sum2+=arr[i][j];                    
	                }
	            }
	        }
	    return sum1-sum2;

		}
}
