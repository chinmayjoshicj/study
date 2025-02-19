package leetCode;

public class ContainerWithMostWater_Practice {

	static int height[]= {1,8,6,2,5,4,8,3,7};
	static int maxArea=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		maxArea(arr);
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		/* NOT Optimised
		 * for (int i = 0; i < height.length; i++) { for (int j = i+1; j <
		 * height.length; j++) { int area=Math.min(arr[i], arr[j])*(j-i);
		 * if(area>maxArea) { maxArea=area; } } }
		 */
		
		//Two Pointer Approach
		int leftPointer=0;
		int rightPointer=height.length-1;
		
		while (leftPointer<rightPointer) {
			int currArea=Math.min(height[leftPointer], height[rightPointer])*(rightPointer-leftPointer);
			if(maxArea<currArea) {
				maxArea=currArea;
			}
			else if(leftPointer<rightPointer) {
				leftPointer++;
			}
			else {
				rightPointer++;
			}
		}
		
        return maxArea;
    }
}
