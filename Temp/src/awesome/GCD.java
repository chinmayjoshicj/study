package awesome;

public class GCD {

	int r;
	int q;
	int temp;
     public int compute(int num1,int num2) {
    	 
    	 while((num1%num2)!=0)
    	 {
    		 temp=r;
	    	 if (num1<num2)
	    	 {
	    		 r=num2%num1;
	    		 q=num2/num1;    	
	    		 return compute(r,num1);
	    	 }
	    	 else
	    	 {
	    		 int temp1=num1;
	    		 num1=num2;
	    		 num2=temp1;
	    		 r=num2%num1;
	    		 q=num2/num1;	
	    		 return compute(r,num1);
	    	 }
    	 }
    	 return temp;
	}
    public static void main(String[] args) {
       GCD g= new GCD();
       int num1=31;
       int num2=2;
       if(num1%num2==0)
       {
    	   System.out.println(num1/num2);
       }
       else if(num2%num1==0)
       {
    	   System.out.println(num2/num1);
       }
       else
       {
    	   System.out.println(g.compute(num1,num2));
       }
    }
}