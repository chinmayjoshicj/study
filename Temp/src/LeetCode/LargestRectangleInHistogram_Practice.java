package leetCode;

import java.util.Stack;

class LargestRectangleInHistogram_Practice {
	
	
//    static int maxArea=0;
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
//    	int heights[]= {2,4};
//    	int heights[]= {4,2,1,5,6,3,2,4,2};
    	int heights[]= {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}
    static int maxArea = 0;

    public static int largestRectangleArea(int[] heights) {
        int prevSmallestArr[] = new int[heights.length];
        prevSmallestArr = prevSmallest(heights, prevSmallestArr);
        for (int i = 0; i < prevSmallestArr.length; i++) {
			System.out.print(prevSmallestArr[i]+" ");
		}
        System.out.println();
        
        int nextSmallestArr[] = new int[heights.length];
        nextSmallestArr = nextSmallest(heights, nextSmallestArr);
        for (int i = 0; i < nextSmallestArr.length; i++) {
        	System.out.print(nextSmallestArr[i]+" ");
        }
        System.out.println();
        
        for (int i = 0; i < nextSmallestArr.length; i++) {
        	int currArea=(nextSmallestArr[i]-prevSmallestArr[i]-1)*heights[i];
        	maxArea=Math.max(currArea, maxArea);
		}
        return maxArea;
    }

    private static int[] nextSmallest(int[] heights, int[] nextSmallestArr) {
		// TODO Auto-generated method stub
    	Stack<Integer> s= new Stack<Integer>();
    	for (int i = heights.length-1; i >=0; i--) {
			while (!s.isEmpty() && heights[s.peek()]>heights[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				nextSmallestArr[i]=-1;
			}
			else {
				nextSmallestArr[i]=s.peek();
			}
			s.add(i);
		}
		return nextSmallestArr;
	}

	private static int[] prevSmallest(int[] heights, int prevSmallest[]) {
		Stack<Integer> s= new Stack<Integer>();
		for (int i = 0; i < heights.length; i++) {
			
			while (!s.isEmpty()
                    && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
			if(s.isEmpty()) {
				prevSmallest[i]=-1;
			}
			else {
				prevSmallest[i]=s.peek();
			}
			s.add(i);
		}
        return prevSmallest;
    }
}
