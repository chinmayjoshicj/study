package conpanySpecific;

import java.util.ArrayList;

class node1
{
	node1 left=null;
	int data;
	node1 right=null;
	
	public node1(int data)
	{
		this.data=data;
	}
}
public class lowestCommonAncestor {

	static ArrayList<Integer> p1=new ArrayList<>();
	static ArrayList<Integer> p2=new ArrayList<>();
	static node1 root = new node1(1);
	static boolean v1=false;
	static boolean v2=false;
	public static void main(String[] args) 
	{
		insertNode(root,5);
		insertNode(root,4);
		insertNode(root,3);
		insertNode(root,6);
		insertNode(root,7);
		insertNode(root,8);
		
		
		/*root = new node(20);
        root.left = new node(8);
        root.right = new node(22);
        root.left.left = new node(4);
        root.left.right = new node(12);
        root.left.right.left = new node(10);
        root.left.right.right = new node(14);*/
		
		//preorder(root);
			
		int a=7;
		int b=8;
		node1 lcaFin=lca(root,a,b);
		
		if (v1 && v2) {
			System.out.println(lcaFin.data);
			return;
		}
		if (v1 && find(lcaFin,b)) {
			System.out.println(lcaFin.data);
			return;
		}
		if (v2 && find(lcaFin,a)) {
			System.out.println(lcaFin.data);
		}
	}
	private static boolean find(node1 lcaFin, int b) 
	{
		if (lcaFin==null) {
			return false;
		}
		if (lcaFin.data==b || find(lcaFin.left, b) || find(lcaFin.right, b)) {
			return true;
		}
		return false;
	}
	private static node1 lca(node1 root2, int i, int j) 
	{
		if (root2==null)
		{
			return null;
		}
		if (root2.data==i)
		{
			v1=true;
			return root2;
		}
		if (root2.data==j) {
			v2=true;
			return root2;
		}
		node1 left=lca(root2.left, i, j);
		node1 right=lca(root2.right,i,j);
		
		if (left!=null && right!=null) {
			return root2;
		}
		
		if (left!=null) {
			
			return left;
		}
		else if(right!=null)
		{
			return right;
		}
		return null;
 	}
	private static void preorder(node1 root) 
	{
		if (root==null) {
			return;
		}
		else
		{
			preorder(root.left);
			System.out.println(root.data);
			preorder(root.right);
		}
	}
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
}
