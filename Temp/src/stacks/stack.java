package stacks;

public class stack {

	int [] a=new int[5];
	int pointer=0;
	public void push(int data)
	{
		if(pointer<5)
		{
			System.out.println("Pushing "+data+" -->"+pointer);
			a[pointer++]=data;
		}
		else
			System.out.println("Stack is full");
	}
	public int pop()
	{
		int data;
		if((pointer-1)!=-1)
		{
			System.out.println("Poping "+a[pointer-1]+"  -->"+ (pointer-1));
			 data=a[--pointer];
			 return data;
		}	 
		else
			System.out.println("Stack is empty");
		return -1;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		stack s=new stack();
		s.push(1);
		s.push(21);
		s.push(2);
		s.push(31);
		s.push(41);
		s.push(5);
		
		s.push(98);
		System.out.println();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		s.pop();
		
		
		
	}

}
