package practice;

import java.util.Stack;

class TreeNode
{
	TreeNode left=null;
	int data;
	TreeNode right=null;
	
	public TreeNode(int data) 
	{
		this.data=data;
	}
}

public class Tree 
{
	static TreeNode root=null;
	static int min=Integer.MAX_VALUE;
	static Stack<TreeNode> currLevel= new Stack<>();
	static Stack<TreeNode> nextLevel= new Stack<>();
	static boolean leftToRight=true;
	static int height=0;
	public static void main(String[] args) 
	{
		root=new TreeNode(20);
		root.left=new TreeNode(8);
		root.left.left=new TreeNode(3);
		
		root.right=new TreeNode(22);
		
		root.left.right=new TreeNode(12);
		root.left.right.right=new TreeNode(14);
		
		root.left.right.left=new TreeNode(10);
		
		findMin(root);
		System.out.println("Minimum Element: "+min);
		System.out.println();
		System.out.println("Height of a Tree:");
		System.out.println(HeightOfaTree(root));
		System.out.println("Is Binary Tree or Not: "+checkTreeBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
		System.out.println();
		System.out.println("Spiral traversal of a tree: ");
		spiralOrderTraversal(root);
		System.out.println();
		System.out.println();
		System.out.println("Diameter of a tree:");
		System.out.println(Diameter(root));
		System.out.println("Boundry Nodes Clockwise:");
		BoundryNodesTraversal(root);
		System.out.println();
	}
	private static void BoundryNodesTraversal(TreeNode rootNode)
	{
//		System.out.println(rootNode.data);
		TreeNode temp=rootNode;
		while (temp.left!=null && temp.right!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.right;
		}
		printLeafNodes(rootNode);
		temp=rootNode;
		while (temp.left!=null && temp.right!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.left;
		}
	}
	private static void printLeafNodes(TreeNode rootNode)
	{
		if (rootNode==null) {
			return;
		}
		if (rootNode.left==null && rootNode.right==null)
		{
			System.out.print(rootNode.data+" ");
		}
		printLeafNodes(rootNode.right);
		printLeafNodes(rootNode.left);
	}
	private static int Diameter(TreeNode rootNode)
	{
		if (rootNode==null) {
			return 0;
		}
		int lheight=HeightOfaTree(rootNode.left);
		int rheight=HeightOfaTree(rootNode.right);
		
		return Math.max(lheight+rheight+1, Math.max(Diameter(rootNode.left), Diameter(rootNode.left)));
	}
	private static int HeightOfaTree(TreeNode rootNode) 
	{
		if (rootNode==null)
		{
			return 0;
		}
		int lheight=HeightOfaTree(rootNode.left)+1;
		int rheight=HeightOfaTree(rootNode.right)+1;
		
		return lheight>rheight?lheight:rheight;
	}
	private static void spiralOrderTraversal(TreeNode rootNode) 
	{
		currLevel.push(rootNode);
		TreeNode t= null;
		while (!currLevel.isEmpty()) 
		{
			t=currLevel.pop();
			System.out.print(t.data+" ");
			
			if (leftToRight) 
			{
				if (t.left!=null) {
					nextLevel.push(t.left);
				}
				if (t.right!=null) {
					nextLevel.push(t.right);
				}
			}
			else
			{
				if (t.right!=null) {
					nextLevel.push(t.right);
				}
				if (t.left!=null) {
					nextLevel.push(t.left);
				}
			}
			if (currLevel.isEmpty() && !nextLevel.isEmpty()) 
			{
				leftToRight=!leftToRight;
				Stack<TreeNode> temp=currLevel;
				currLevel=new Stack<>();
				currLevel=nextLevel;
				nextLevel=temp;				
			}
		}
	}
	private static boolean checkTreeBST(TreeNode rootNode, int minValue, int maxValue) 
	{
		if (rootNode==null){
			return true;
		}
		if (rootNode.data>maxValue || rootNode.data<minValue) {
			return false;
		}
		return checkTreeBST(rootNode.left, minValue, rootNode.data-1) &&
												checkTreeBST(rootNode.right, rootNode.data+1, maxValue);
	}
	private static void findMin(TreeNode rootNode) 
	{
		if (rootNode==null) {
			return;
		}
		if (rootNode.data<min) {
			min=rootNode.data;
		}
		if (rootNode.left!=null) {
			findMin(rootNode.left);
		}
		if (rootNode.right!=null) {
			findMin(rootNode.right);
		}
	}
}