package leetCode;

import java.util.Stack;

public class PreviousSmallerElement {

	static int arr[]={2,1,5,6,2,3};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[]= {4,10,5,8,20,15,3,12};
//		int arr[]= {2,1,5,6,2,3};
		int finalArr[]= new int[arr.length];

		Stack<Integer> s= new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() 
					&& s.peek()>=arr[i]) {
				s.pop();
			}
			if(s.isEmpty()) {
				finalArr[i]=-1;
			}else {
//				finalArr[i]=s.peek();
				finalArr[i]=getIndex(s.peek(),i);
			}
			s.push(arr[i]);
		}
		for (int i = 0; i < finalArr.length; i++) {
			System.out.print(finalArr[i]+" ");
		}
	}
	
	private static int getIndex(Integer integer, int index) {
		// TODO Auto-generated method stub
		for (int i = index; i >=0; i--) {
			if(integer==arr[i]) {
				return i;
			}
		}
		return -1;
	}

}
