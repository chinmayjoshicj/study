package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

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
	static	int max_level=0;
	static Map<Integer, TreeNode> topViewMap= new HashMap<Integer, TreeNode>();

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
//		System.out.println("Spiral traversal of a tree: ");
//		levelOrderTraversal(root);
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
		 for (Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
			System.out.println(entry.getValue().data);
		 }
		 System.out.println();
		 System.out.println();
		  System.out.println("Diameter of a tree:");
		 System.out.println(Diameter(root));
//		 System.out.println("Boundry Nodes Clockwise:");
//		 BoundryNodesTraversal(root);
		 System.out.println();
		 System.out.println("Left View Is");
		 LeftView(root,1);
		 System.out.println("Bottom View");
		 BottomView(root);
		 for (Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
				System.out.println(entry.getValue().data);
			 }
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
		 preorderWithoutRecursion(root);
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

	private static void preorderWithoutRecursion(TreeNode root)
	{
		Stack<TreeNode> s= new Stack<>();
		TreeNode curr= root;
		System.out.println("Chinmay: ");
		while ( curr!=null || !s.isEmpty() ) 
		{
			while(curr!=null)
			{
				System.out.print(curr.data+" ");
				s.push(curr);
				curr=curr.left;
			}
			curr=s.pop();
			curr=curr.right;
		}
		
		/*Stack<TreeNode> s= new Stack<>();
		TreeNode curr= rootNode;
		
		while(curr!=null || !s.isEmpty())
		{
			while(curr!=null)
			{
				System.out.print(curr.data+" ");
				s.push(curr);
				curr=curr.left;
			}
			curr=s.pop();
			curr=curr.right;
		}*/
	}

	private static void BottomView(TreeNode root) 
	{
		if (root==null) {
			return;
		}
		Stack<TreeNode> curr= new Stack<>();
		Stack<TreeNode> next= new Stack<>();
		curr.push(root);
		topViewMap.clear();
		while (!curr.isEmpty())
		{
			TreeNode popped= curr.pop();
			topViewMap.put(popped.hd, popped);
			if (popped.left!=null) {
				next.push(popped.left);
			}
			if (popped.right!=null) {
				next.push(popped.right);
			}
			if (curr.isEmpty()) {
				Stack<TreeNode> s= new Stack<>();
				s=curr;
				curr=next;
				next=s;
			}
		}
	}

	private static void findMin(TreeNode root) {
		if (root==null) {
			return;
		}
		if (min>root.data) {
			min=root.data;
		}
		findMin(root.left);
		findMin(root.right);
	}
	
	private static int HeightOfaTree(TreeNode root) {
		if (root==null) {
			return 0;
		}
		int lh=HeightOfaTree(root.left)+1;
		int rh=HeightOfaTree(root.right)+1;
		
		return Integer.max(lh, rh);
	}
	
	private static boolean checkTreeBST(TreeNode root, int minValue, int maxValue) {
		if (root==null) {
			return true;
		}
		if ((root.left!=null && root.data<=root.left.data) || (root.right!=null && root.data>=root.right.data)) {
			return false;
		}
		return checkTreeBST(root.left, minValue, root.data-1) &&
		checkTreeBST(root.right, root.data+1,maxValue);
	}

	private static void levelOrderTraversal(TreeNode root) 
	{
		if (root==null) {
			return;
		}
		Stack<TreeNode> curr= new Stack<>();
		Stack<TreeNode> next= new Stack<>();
		curr.add(root);
		while (!curr.isEmpty())
		{
			TreeNode popped = curr.pop();
			System.out.print(popped.data+" ");
			if (popped.right!=null) {
				next.add(popped.right);
			}
			if (popped.left!=null) {
				next.add(popped.left);
			}
			if (curr.isEmpty())
			{
				Stack<TreeNode> temp= new Stack<>();
				temp=curr;
				curr=next;						
				next=temp;
			}
		}
	}
	private static void levelOrderWithoutStackQueue(TreeNode root)
		{ 
		    int h = HeightOfaTree(root); 
		    int i; 
		    for (i=1; i<=h; i++) 
		    { 
		        printGivenLevel(root, i); 
		        System.out.println(); 
		    } 
		} 
		/* Print nodes at a given level */
		static void printGivenLevel(TreeNode root, int level) 
		{ 
		    if (root == null) 
		        return; 
		    if (level == 1) 
		        System.out.print(root.data+" "); 
		    else if (level > 1) 
		    { 
		        printGivenLevel(root.left, level-1); 
		        printGivenLevel(root.right, level-1); 
		    } 
		} 
		
	private static void topView(TreeNode root) {
		if (root==null) {
			return;
		}
		Stack<TreeNode> curr= new Stack<>();
		Stack<TreeNode> next= new Stack<>();
		curr.push(root);
		while (!curr.isEmpty())
		{
			TreeNode popped= curr.pop();
			if (!topViewMap.containsKey(popped.hd)) {
				topViewMap.put(popped.hd, popped);
			}
			if (popped.left!=null) {
				next.push(popped.left);
			}
			if (popped.right!=null) {
				next.push(popped.right);
			}
			if (curr.isEmpty()) {
				Stack<TreeNode> s= new Stack<>();
				s=curr;
				curr=next;
				next=s;
			}
		}
	}

	private static int Diameter(TreeNode root) {
		if (root==null) {
			return 0;
		}
		int lh=HeightOfaTree(root.left);
		int rh=HeightOfaTree(root.right);
		
		return Integer.max(lh+rh, Integer.max(Diameter(root.left), Diameter(root.right)));
	}
	private static void LeftView(TreeNode root, int level) {
		if (root==null) {
			return;
		}
		if (max_level<level)
		{
			System.out.println(root.data);
			max_level=level;
		}
		LeftView(root.left, level+1);
		LeftView(root.right, level+1);
	}
}