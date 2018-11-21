package conpanySpecific;

import tree.Node;

public class DiameterOfTree {
	static Node root=null;
	private static void insertNode(node1 root,int i) 
	{
		if(root.data>i)
		{
			if (root.left==null) {
				root.left=new node1(i);
			}
			else
			{
				insertNode(root.left,i);
			}
		}
		else if (root.data<i) {
			if (root.right==null) {
				root.right=new node1(i);
			}
			else
				insertNode(root.right, i);
		}
	}
	
	public static void main(String[] args)
	{
		root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        
        System.out.println(findDiameter(root));
	}

	private static int findDiameter(Node root2) 
	{
		if (root2==null) {
			return 0;
		}
		int lh=0;
		int rh=0;
		if (root2.left!=null) {
			lh=height(root2.left);
		}
		if (root2.right!=null) {
			rh=height(root2.right);
		}
		return Math.max(lh+rh+1,Math.max(findDiameter(root2.left), findDiameter(root2.right)));
	}

	private static int height(Node root1) 
	{
		if (root1==null) {
			return 0;
		}
		int lh=height(root1.left);
		int rh=height(root1.right);
		
		if (lh>rh) {
			return lh+1;
		}
		else
			return rh+1;
	}
	
	
	
}
