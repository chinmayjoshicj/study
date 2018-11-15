package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import org.omg.CORBA.TRANSACTION_MODE;

/*class TreeNode
{
	TreeNode left=null;
	int data;
	int hd;
	TreeNode right=null;
	TreeNode nextRight=null;
	
	public TreeNode(int data, int i) 
	{
		this.data=data;
		this.hd=i;
	}
	public TreeNode(int data) 
	{
		this.data=data;
	}
}*/

public class TreePractice {
	static TreeNode root = null;
	static TreeNode root1 = null;
	static int min = Integer.MAX_VALUE;
	static Stack<TreeNode> currLevel = new Stack<>();
	static Stack<TreeNode> nextLevel = new Stack<>();
	static boolean leftToRight = true;
	static int height = 0;
	static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
	static ArrayList<Integer> l = new ArrayList<>();

	public static void main(String[] args) {
		root = new TreeNode(20, 0);
		root.left = new TreeNode(8, -1);
		root.left.left = new TreeNode(3, -2);

		root.right = new TreeNode(22, 1);
		// root.right.right=new TreeNode(29,1);

		root.left.right = new TreeNode(12, 0);
		root.left.right.right = new TreeNode(14, 1);

		root.left.right.left = new TreeNode(10, -1);

		/*
		 * root1=new TreeNode(20,0); root1.left=new TreeNode(8,-1);
		 * root1.left.left=new TreeNode(3,-2);
		 * 
		 * root1.right=new TreeNode(22,1);
		 * 
		 * root1.left.right=new TreeNode(12,0); root1.left.right.right=new
		 * TreeNode(14,0);
		 * 
		 * root1.left.right.left=new TreeNode(1,-1);
		 */
		/*
		 * root=new TreeNode(50); root.left = new TreeNode(7); root.right = new
		 * TreeNode(2); root.left.left = new TreeNode(3); root.left.right = new
		 * TreeNode(5); root.right.left = new TreeNode(1); root.right.right =
		 * new TreeNode(30);
		 */
		findMin(root);
		System.out.println("Minimum Element: " + min);
		System.out.println();
		System.out.print("Height of a Tree: ");
		height = HeightOfaTree(root);
		System.out.println(height);
		System.out.println();
		System.out.println("Is Binary Search Tree or Not: " + checkTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println();
		System.out.println();
		System.out.println("Spiral traversal of a tree: ");
		spiralOrderTraversal(root);
		System.out.println();
		System.out.println();
		System.out.println("Level Order Travelsal: ");
		levelOrderTraversal(root);
		System.out.println();
		System.out.println();
		System.out.println("Level Order Without stack Queue: ");
		levelOrderWithoutStackQueue(root);
		 System.out.println();
		 System.out.println();
		 System.out.println("Top View is:");
		 topView(root);
		 System.out.println();
		 System.out.println();
		 //topView2(root);
		 /*for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			 if (entry.getValue().size() > 1) {
				 for (int i = 0; i < l.size(); i++) {
					 if (entry.getValue().contains(l.get(i))) {
						 System.out.print(l.get(i) + " ");
						 break;
					 }
				 }
			 } else
				 System.out.print(entry.getValue().get(0) + " ");
		 }*/
		 System.out.println();
		 System.out.println();
		  System.out.println("Diameter of a tree:");
		 System.out.println(Diameter(root));
//		 System.out.println("Boundry Nodes Clockwise:");
//		 BoundryNodesTraversal(root);
		 System.out.println();
		 System.out.println("Left View Is");
		 LeftView(root,1);
		 System.out.println();
//		 System.out.println("Check if 2 Trees are identical or not: "+checkIdentical(root,root1));
//		 System.out.println();
//		 System.out.println("Deleting Tree: ");
//		 deleteTree(root);
//		 System.out.println();
//		 System.out.println("Normal Tree");
//		 printInorder(root);
//		 System.out.println();
//		 System.out.println("Mirror Image: ");
		 //mirror(root);
		// printInorder(root);
//		 System.out.println();
//		 System.out.println("Root to Leaf Path Sum: "+findRootToLeafSumPath(root,54));
//		 System.out.println();
//		 System.out.println();
		 System.out.println("IreOrder without Recursion: ");
//		 inOrderWithoutRecursion(root);
		 System.out.println();
		 System.out.println();
		 System.out.println("Preorder without Recursion: ");
//		 preorderWithoutRecursion(root);
		 System.out.println();
		 System.out.println();
		 System.out.println("Check if a Tree is Height Balanced: ");
//		 System.out.println(isTreeHeightBalanced(root));
		 System.out.println();
		 System.out.println();
		 /* System.out.println("Convert a Normal Tree into a tree which holds
		// Children Sum Property:");
		// //convert(root);//Wrong because we cannot decrement any Value of Node
		// inorderWithoutRecursion(root);
		// System.out.println();
		// System.out.println();
		// System.out.println("Sum Of Cousin Nodes is:");
		// System.out.println(sumOfCousinNodes(root,2));
//		 System.out.println();
//		 System.out.println();
		 System.out.println("Path Sum Equal to k:");
		 System.out.println(pathSumK(root,31));
		// System.out.println("Sum Of Cousin Nodes is:");
		// ConnectNodesAtSameLevel(root);
		//
		
		 System.out.println();
		 System.out.println();
		 System.out.println("Maximum Width Of a Binary Tree: ");
		 System.out.println(maximumWidthOfBinaryTree(root));
		 */
		 System.out.println();
		 System.out.println("K distance nodes from root");
//		 kDistanceNodesFromRoot(root,2);
		 System.out.println();
		 System.out.println();
		 System.out.println("Grand Parent: ");
//		 findGrandParent(root,3);
		 System.out.println();
		 System.out.println();
		 int paths[]= new int[100];
		 System.out.println("Root To leaf paths are: ");
//		 printAllRootToLeafPaths(root, paths,0);
	}

static	int max_level=0;
	private static void LeftView(TreeNode root,int level)//1
	{
		 if (root==null) return; 
		  
	        // If this is the first node of its level 
	        if (max_level < level) //0
	        { 
	            System.out.print(" " + root.data); 
	            max_level = level;
	        } 
	  
	        // Recur for left and right subtrees 
	        LeftView(root.left, level+1); 
	        LeftView(root.right, level+1); 
	}

	private static int Diameter(TreeNode root) 
	{
		if (root==null) {
			return 0;
		}
		int lheight=HeightOfaTree(root.left);
		int rheight=HeightOfaTree(root.right);
		
		return Integer.max(lheight+rheight+1,Integer.max(Diameter(root.left), Diameter(root.right)));
	}

	private static void topView(TreeNode root) 
	{
		if (root==null) {
			return;
		}
		HashSet<Integer> set= new HashSet<>();
		Queue<TreeNode> q= new LinkedList<>();
		
		q.add(root);
		
		while (!q.isEmpty())
		{
			TreeNode removed = q.remove();
			if (!set.contains(removed.hd))
			{
				set.add(removed.hd);
				System.out.print(removed.data+" ");
			}
			if (removed.left!=null) {
				q.add(removed.left);
			}
			if (removed.right!=null) {
				q.add(removed.right);
			}
		}
		
	}

	private static void levelOrderWithoutStackQueue(TreeNode root) {
		if (root==null) {
			return;
		}
		for (int i = 1; i <= height; i++) 
		{
			printGivelLevel(root,i);
		}
	}

	private static void printGivelLevel(TreeNode root, int level)
	{
		if (root==null) {
			return;
		}
		if (level==1) {
			System.out.print(root.data+" ");
		}
		else if(level>1)
		{
			printGivelLevel(root.left, level-1);
			printGivelLevel(root.right, level-1);
		}
	}

	private static void levelOrderTraversal(TreeNode root)
	{
		if (root==null) {
			return;
		}
		Stack<TreeNode> curr=new Stack<>();
		Stack<TreeNode> next=new Stack<>();
		curr.push(root);
		boolean leftToRight=true;
		while (!curr.isEmpty()) 
		{
			TreeNode temp=curr.pop();
			System.out.print(temp.data+" ");
			if (leftToRight) {
				if (temp.left!=null) {
					next.push(temp.left);
				}
				if (temp.right!=null) {
					next.push(temp.right);
				}
			}
			if (curr.isEmpty())
			{
				Stack<TreeNode>s1=curr;
				curr=next;
				next=s1;
			}
		}	
	}
	private static void spiralOrderTraversal(TreeNode root) 
	{
		if (root==null) {
			return;
		}
		Stack<TreeNode> curr=new Stack<>();
		Stack<TreeNode> next=new Stack<>();
		curr.push(root);
		boolean leftToRight=true;
		while (!curr.isEmpty()) 
		{
			TreeNode temp=curr.pop();
			System.out.print(temp.data+" ");
			if (leftToRight) {
				if (temp.left!=null) {
					next.push(temp.left);
				}
				if (temp.right!=null) {
					next.push(temp.right);
				}
			}
			else
			{
				if (temp.right!=null) {
					next.push(temp.right);
				}
				if (temp.left!=null) {
					next.push(temp.left);
				}
			}
			if (curr.isEmpty())
			{
				leftToRight=!leftToRight;
				Stack<TreeNode>s1=curr;
				curr=next;
				next=s1;
			}
		}	
	}
	private static boolean checkTreeBST(TreeNode root, int minValue, int maxValue) 
	{
		if (root==null) {
			return true;
		}
		if ((root.left!=null && root.left.data>root.data) || (root.right!=null && root.right.data<root.data)) {
			return false;
		}
		return checkTreeBST(root.left, Integer.MIN_VALUE, root.data-1) && checkTreeBST(root.right, root.data+1, Integer.MAX_VALUE);
	}

	private static int HeightOfaTree(TreeNode root) {
		// TODO Auto-generated method stub
		if (root==null) {
			return 0;
		}
		int lheight=HeightOfaTree(root.left)+1;
		int rheight=HeightOfaTree(root.right)+1;
		
		return lheight>rheight?lheight:rheight;
	}

	private static void findMin(TreeNode root) 
	{
		if (root==null) {
			return;
		}
		if (root.data<min) {
			min=root.data;
		}
		if (root.left!=null) {
			findMin(root.left);
		}
		if (root.right!=null) {
			findMin(root.right);
		}
	}
}