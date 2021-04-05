package dynamicProgramming;

public class MaxSumOfRectIn2DArray {

	static int arr[][]= {{  6, -5, -7,  4,  4},
			{ -9,  3, -6,  5,  2},
			{-10,  4,  7, -6,  3},
			{ -8,  9, -3,  3, -7}};
//	static int arr[][]= {{ 1, 2, -1,-4,-20},
//						 {-8,-3, 4,  2,  1},
//						 { 3, 8, 10, 1,  3},
//						 {-4,-1, 1,  7, -6}};
	
	static int runRowSum[]=new int[arr.length];
	static int maxRectSum=arr[0][0];
	static int leftTopIndex=0;
	static int leftBottomIndex=0;
	static int rightTopIndex=0;
	static int rightBottomIndex=0;
	public static void main(String[] args) {
		int right=0;
		int left = 0;
		for (left = 0; left < arr[0].length; left++) {
			for (right= 0; right< arr[0].length; right++) {
				if (left<=right) {
					prepareRunnRowSum(left,right);
				}
				runRowSum=new int[arr.length];
			}
			right++;
		}
		System.out.println("Max Sum is "+maxRectSum);
		System.out.println();
	}

	private static void prepareRunnRowSum(int left,int right) {
		int runRowSumIndex=0;
		System.out.println("maxRowSum: left "+left+" right "+right);
			while (runRowSumIndex<runRowSum.length) {
				for (int i = left; i <=right; i++) {
					runRowSum[runRowSumIndex]+=arr[runRowSumIndex][i];
			}				
				runRowSumIndex++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(runRowSum[i]+" ");
		}
		System.out.println();
		applyKadance(runRowSum,left,right);
		System.out.println("leftTopIndex= "+leftTopIndex);
		System.out.println("rightTopIndex= "+rightTopIndex);
		System.out.println("leftBottomIndex= "+leftBottomIndex);
		System.out.println("rightBottomIndex= "+rightBottomIndex);
		
	}

	private static void applyKadance(int[] runRowSum,int left,int right) {
		// TODO Auto-generated method stub
		int currSum=runRowSum[0];
		int sol[]=new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			System.out.println("currSum+arr[i]"+(currSum+runRowSum[i])+ " > "+runRowSum[i]+" ?");
			if((currSum+runRowSum[i])>runRowSum[i]) {
				System.out.println("Yes Greater , Extent the sum from previous Value!!");
				sol[i]=currSum+runRowSum[i];
			}
			else
			{
				sol[i]=runRowSum[i];
			}
			currSum=sol[i];
			if (sol[i]>maxRectSum) {
				maxRectSum=sol[i];	
				leftTopIndex=left;
				rightTopIndex=right;
				leftBottomIndex=i;
				rightBottomIndex=i;
			}
		}
	}

}
