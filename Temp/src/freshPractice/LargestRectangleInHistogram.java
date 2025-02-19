package freshPractice;

import java.util.Stack;

class LargestRectangleInHistogram {
	
	
//    static int maxArea=0;
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
//    	int heights[]= {2,4};
    	int heights[]= {4,2,1,5,6,3,2,4,2};
		System.out.println(largestRectangleArea(heights));
	}
    static int maxArea = 0;

    public static int largestRectangleArea(int[] heights) {
        int prevSmallestArr[] = new int[heights.length];
        prevSmallestArr = prevSmallest(heights, prevSmallestArr);
        for (int i = 0; i < heights.length; i++) {
            if (prevSmallestArr[i] != -1) {
                int area = Math.min(heights[i], heights[prevSmallestArr[i]]) * ((i - prevSmallestArr[i]) + 1);
                maxArea = Math.max(area, maxArea);
            } else {
                maxArea = Math.max(heights[i], maxArea);

            }
        }
        return maxArea;
    }

    private static int[] prevSmallest(int[] heights, int prevSmallest[]) {
        // TODO Auto-generated method stub
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty()
                    && s.peek() >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                prevSmallest[i] = -1;
            } else {
                prevSmallest[i] = getIndex(s.peek(), i, heights);
            }
            s.push(heights[i]);
        }
        return prevSmallest;
    }

    private static int getIndex(Integer integer, int index, int[] heights) {
        // TODO Auto-generated method stub
        for (int i = index; i >= 0; i--) {
            if (integer == heights[i]) {
                return i;
            }
        }
        return -1;
    }
}
