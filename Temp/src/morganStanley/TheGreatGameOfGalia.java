package morganStanley;

import java.util.Scanner;

class Node
{
	Node left=null;
	int data;
	Node right=null;
	
	public Node(int item)
	{
		data=item;
		left=right=null;
	}
}
public class TheGreatGameOfGalia 
{
	static Node root=null;
	static int sumOfleafNodes=0;
	static int count=0;
	 static void expectedAmount(int[] a)
	 {
	        permute(a, 0, a.length-1);
	        if (count!=1)
	        {
	        	int gcd=findGcd(sumOfleafNodes,count);
	        	System.out.println(sumOfleafNodes/gcd +"/"+count/gcd);
	        	sumOfleafNodes=0;
	        	count=0;
			}
	        else
	        {
	        	System.out.println(sumOfleafNodes);
	        	sumOfleafNodes=0;
	        	count=0;
	        }
	        
	 }
	 private static int findGcd(int a, int b) {
		 
		     // Everything divides 0 
		     if (a == 0 || b == 0)
		        return 0;
		  
		     // base case
		     if (a == b)
		         return a;
		  
		     // a is greater
		     if (a > b)
		         return findGcd(a-b, b);
		     
		     return findGcd(a, b-a);
	}
	private static void permute(int[] a, int left, int right)
	 {
			if (left==right) 
			{
				count++;
				for (int i = 0; i < a.length; i++)
				{
					insert(a[i],root);
				}
				inOrader(root);
				deleteTree(root);
				/*for (int i = 0; i < a.length; i++) {
					System.out.print(a[i]);
				}
				System.out.println();*/
			}
			else
			{
				for (int i = left; i <= right; i++) 
				{
					a=swap(a,left,i);
					permute(a, left+1, right);
					a=swap(a,left,i);
				}
			}
		}
	 private static void deleteTree(Node node) 
	 {
		 if (node == null)
	            return;
	 
	        /* first delete both subtrees */
	        deleteTree(node.left);
	        deleteTree(node.right);
	 
	        /* then delete the node */
//	        System.out.println("The deleted node is " + node.data);
	        root = null;
	 }
	public static void inOrader(Node node){
			
			if(node != null)
			{
				if (node.left==null && node.right==null)
				{
					sumOfleafNodes=sumOfleafNodes+node.data;
				}
				inOrader(node.left);
//				System.out.println(node.data);
				inOrader(node.right);
			}
		}
	 public static void insert(int item, Node node)
		{
				if(root==null)
				{
					root=new Node(item);
					root.data=item;
					return;
				}
				else if(root.data>item)
				{
					if(root.left==null)
					{
						root.left=new Node(item);
						root.left.data=item;
						return;
					}
					else
						root.left.data=item;
				}
				else
				{
					if(root.right==null)
					{
						root.right=new Node(item);
						root.right.data=item;
						return;
					} else 
					{
						root.right.data=item;
					}
				}
		}
		private static int[] swap(int[] a, int left, int i) 
		{
			int temp;
//			char[] charArray=a.toCharArray();
			//System.out.println(s);
			//System.out.println("Swapping "+charArray[left]+" and "+charArray[i]);
			temp=a[left];
			a[left]=a[i];
			a[i]=temp;
			return a;
		}
	    public static void main(String[] args) 
	    {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int[] a = new int[n];
	            for(int a_i = 0; a_i < n; a_i++)
	            {
	                a[a_i] = in.nextInt();
	            }
	            expectedAmount(a);
	        }
	        in.close();
	    }
}
