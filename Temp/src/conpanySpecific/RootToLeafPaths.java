package conpanySpecific;

import java.util.ArrayList;

import tree.Node;

public class RootToLeafPaths {

	static Node root=null;
	private static void insertNode(node root,int i) 
	{
		if(root.data>i)
		{
			if (root.left==null) {
				root.left=new node(i);
			}
			else
			{
				insertNode(root.left,i);
			}
		}
		else if (root.data<i) {
			if (root.right==null) {
				root.right=new node(i);
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
        int len=0;
        int path[]=new int[1000];
        printPaths(root,path,len);
	}
	private static void printPaths(Node root2, int[] path, int len) 
	{
		if (root==null) {
			return;
		}
		path[len++]=root2.data;
		if (root2.left==null && root2.right==null){
			for (int i = 0; i < len; i++) 
			{
				System.out.print(path[i]+" ");
			}
			System.out.println();
		}
		
		if (root2.left!=null) {
			printPaths(root2.left, path,len);
		}
		if (root2.right!=null) {
			printPaths(root2.right, path,len);
		}
	}
}
