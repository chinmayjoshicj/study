package leetCode;

public class Palandrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(-121));
	}
	public static  boolean isPalindrome(int x) {
        String val= String.valueOf(x);
        int startPointer=0;
        int endPointer=val.length()-1;

        while(startPointer<=endPointer){
            if(val.charAt(startPointer++)==val.charAt(endPointer--)){
                continue;
            }
            else{
                return false;
            }
        }
         return true;
    }

}
