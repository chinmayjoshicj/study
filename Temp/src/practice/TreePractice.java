package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import stringManupulations.RichieRich;

import java.util.PriorityQueue;
import java.util.Queue;
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
	static Queue<TreeNode> levelOrder = new LinkedList<TreeNode>();
	static boolean leftToRight = true;
	static int height = 0;
	static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
	static ArrayList<Integer> l = new ArrayList<>();
	static int max_level = 0;
	static Map<Integer, TreeNode> topViewMap = new HashMap<Integer, TreeNode>();
	static Map<Integer, TreeNode> leftViewMap = new HashMap<Integer, TreeNode>();
	static HashSet<TreeNode> leftViewHashSet = new HashSet<TreeNode>();
	static Map<Integer, TreeNode> bottomViewMap = new HashMap<Integer, TreeNode>();

	public static void main(String[] args) {
//		root = new TreeNode(20, 0);
		root = new TreeNode(5, 0);
		root = new TreeNode(2, 0);
//		root.left = new TreeNode(8, -1);
		root.left = new TreeNode(1, -1);
//		root.left.left = new TreeNode(3, -2);

//		root.right = new TreeNode(22, 1);
		root.right = new TreeNode(3, 1);
//		root.right.left = new TreeNode(3, 1);
//		root.right.right = new TreeNode(6, 1);
		// root.right.right=new TreeNode(29,1);

//		root.left.right = new TreeNode(12, 0);
//		root.left.right = new TreeNode(12, 0);
//		root.left.right.right = new TreeNode(14, 1);
//		 root.left.right.right.right = new TreeNode(13, 2);

//		root.left.right.left = new TreeNode(10, -1);

		/*
		 * root1=new TreeNode(20,0); root1.left=new TreeNode(8,-1); root1.left.left=new
		 * TreeNode(3,-2);
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
		 * TreeNode(5); root.right.left = new TreeNode(1); root.right.right = new
		 * TreeNode(30);
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
		System.out.println("Level Order Travelsal: ");
		levelOrderTraversal(root);
		System.out.println();
		System.out.println();
		System.out.println("Spiral traversal of a tree: ");
		spiralOrderTraversal(root);
		System.out.println();
		System.out.println();
		System.out.println("Level Order Without stack Queue: ");
		levelOrderWithoutStackQueue(root);
		System.out.println();
		System.out.println();
		System.out.println("Top View is:");
		topView(root);
		for (Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
		System.out.println();
		System.out.println();
//		// topView2(root);
//		for (Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
//			System.out.print(entry.getValue().data + " ");
//		}
//		System.out.println();
//		System.out.println();
//
		System.out.println("Diameter of a tree:");
		System.out.println(Diameter(root));
//
		System.out.println("Boundry Nodes Clockwise:");
		BoundryNodesTraversal(root);
//		System.out.println();
//		System.out.println("Left View Is");
//		LeftViewMy(root);
//		for (Entry<Integer, TreeNode> entry : leftViewMap.entrySet()) {
//			System.out.print(/* entry.getKey()+" "+ */entry.getValue().data + " ");
//		}
//		System.out.println();
//		System.out.println("Bottom View");
//		BottomView(root);
//		for (Entry<Integer, TreeNode> entry : bottomViewMap.entrySet()) {
//			System.out.print(entry.getValue().data + " ");
//		}
//		System.out.println();
//		// System.out.println("Check if 2 Trees are identical or not:
//		// "+checkIdentical(root,root1));
//		// System.out.println();
//		// System.out.println("Deleting Tree: ");
//		// deleteTree(root);
//		// System.out.println();
//		// System.out.println("Normal Tree");
//		// printInorder(root);
//		// System.out.println();
//		// System.out.println("Mirror Image: ");
//		// mirror(root);
//		// printInorder(root);
//		// System.out.println();
//		// System.out.println();
//		// System.out.println();
//		System.out.println("IreOrder without Recursion: ");
//		inOrderWithoutRecursion(root);
//		System.out.println();
//		System.out.println();
//		System.out.println("Preorder without Recursion: ");
//		preorderWithoutRecursion(root);
//		System.out.println();
//		System.out.println();
//		System.out.println("Check if a Tree is Height Balanced: ");
//		// System.out.println(isTreeHeightBalanced(root));
//		System.out.println();
//		System.out.println();
//		/*
//		 * System.out.println("Convert a Normal Tree into a tree which holds //
//		 * Children Sum Property:"); // //convert(root);//Wrong because we
//		 * cannot decrement any Value of Node // inorderWithoutRecursion(root);
//		 * // System.out.println(); // System.out.println(); //
//		 * System.out.println("Sum Of Cousin Nodes is:"); //
//		 * System.out.println(sumOfCousinNodes(root,2)); //
//		 * System.out.println(); // System.out.println(); System.out.println(
//		 * "Path Sum Equal to k:"); System.out.println(pathSumK(root,31)); //
//		 * System.out.println("Sum Of Cousin Nodes is:"); //
//		 * ConnectNodesAtSameLevel(root); //
//		 * 
//		 * System.out.println(); System.out.println(); System.out.println(
//		 * "Maximum Width Of a Binary Tree: ");
//		 * System.out.println(maximumWidthOfBinaryTree(root));
//		 */
//		System.out.println();
		System.out.println("K distance nodes from root");
		kDistanceNodesFromRoot(root, 3);
//		System.out.println();
//		System.out.println();
//		System.out.println("Grand Parent: ");
//		// findGrandParent(root,3);
//		System.out.println();
//		System.out.println();
		int paths[] = new int[100];
		System.out.println("Root To leaf paths are: ");
		printAllRootToLeafPaths(root, paths, 0);
		System.out.println("Root to Leaf Path Sum: " + findRootToLeafSumPath(root, 31));
//		System.out.println();
//		System.out.println();
//		System.out.println("Max Width of Tree is: ");
////		System.out.println(maximumWidthOfBinaryTree(root));
	}

	private static void BoundryNodesTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		printRightBoundry(root);
		System.out.println();
		printBottomBoundry(root);
		System.out.println();
		printLeftBoundry(root.left);
		System.out.println();

	}

	private static void printBottomBoundry(TreeNode root) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.data+" ");
		}
		printBottomBoundry(root.right);
		printBottomBoundry(root.left);
		
	}

	private static void printLeftBoundry(TreeNode root) {
		if(root==null) {
			return;
		}
		printLeftBoundry(root.left);
		if(root.left==null && root.right==null) {
			return;
		}
		System.out.print(root.data+" ");
	}

	private static void printRightBoundry(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) {
			return;
		}
		if(root.left ==null && root.right==null) {
			return;
		}
		System.out.print(root.data+" ");
		printRightBoundry(root.right);
	}

	private static void spiralOrderTraversal(TreeNode root) {

	}

	private static void findMin(TreeNode root) {
		if (root == null) {
			return;
		}
		if(root.left!=null && root.left.data<min) {
			min=root.left.data;
		}
		if(root.right!=null && root.right.data<min) {
			min=root.right.data;
		}
		findMin(root.left);
		findMin(root.right);
		
	}

	private static void topView(TreeNode root) {
		if(root==null)
		{
			return ;
		}
		Stack s1= new Stack<TreeNode>();
		Stack s2= new Stack<TreeNode>();
		
		s1.add(root);
		while (!s1.isEmpty()) {
			TreeNode pop = (TreeNode) s1.pop();
			if(!topViewMap.containsKey(pop.hd)) {
				topViewMap.put(pop.hd, pop);
			}
			if(pop.left!=null) {
				s2.push(pop.left);
			}
			if(pop.right!=null) {
				s2.push(pop.right);
			}
			if(s1.isEmpty()) {
				Stack temp=s1;
				s1=s2;
				s2=temp;
			}
		}
	}

	private static int HeightOfaTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		
		int leftHeight= HeightOfaTree(root.left)+1;
		int rightHeight= HeightOfaTree(root.right)+1;
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}

	private static boolean checkTreeBST(TreeNode root, int minValue, int maxValue) {
		
		if (root == null) {
			return true;
		}
		if (root.data > maxValue || root.data < minValue) {
			return false;
		}
		return checkTreeBST(root.left, minValue, root.data - 1)
				&& checkTreeBST(root.right, root.data + 1, maxValue);
	}

	private static void levelOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		currLevel.add(root);
		while (!currLevel.isEmpty()) {
			TreeNode t=currLevel.pop();
			if(leftToRight) {
				System.out.println(t.data);
				if(t.right!=null) {
					nextLevel.add(t.right);
				}
				if(t.left!=null) {
					nextLevel.add(t.left);
				}							
			}
			else {
				System.out.println(t.data);
				if(t.left!=null) {
					nextLevel.add(t.left);
				}			
				if(t.right!=null) {
					nextLevel.add(t.right);
				}
			}
			if(currLevel.isEmpty()) {
				leftToRight=!leftToRight;
				Stack<TreeNode> temp=currLevel;
				currLevel=nextLevel;
				nextLevel=temp;
			}
		}
	}

	private static void levelOrderWithoutStackQueue(TreeNode root) {
		int height=HeightOfaTree(root);
        int i;
        for (i=1; i<=height; i++)
        	levelOrderUtils(root, i);
	}

	private static void levelOrderUtils(TreeNode root, int level) {
		
			if (root == null)
	            return;
	        if (level == 1)
	            System.out.print(root.data + " ");
	        else if (level > 1)
	        {
	        	levelOrderUtils(root.left, level-1);
	        	levelOrderUtils(root.right, level-1);
	        }		
	}

	private static int Diameter(TreeNode root) {

		if(root==null)
		{
			return 0;
		}
		int lHeight=HeightOfaTree(root.left);
		int rHeight=HeightOfaTree(root.right);
		
		return Integer.max(lHeight+rHeight+1, Integer.max(HeightOfaTree(root.left), HeightOfaTree(root.right)));
	}

	private static void LeftViewMy(TreeNode root) {
		
	}

	private static void leftViewUtils(TreeNode root, int level) {

	}

	private static void BottomView(TreeNode root) {

	}

	private static void inOrderWithoutRecursion(TreeNode root) {

	}

	private static void preorderWithoutRecursion(TreeNode root) {

	}

	private static void kDistanceNodesFromRoot(TreeNode root, int dist) {
		if(root==null) {
			return;
		}
		if(dist==0) {
			System.out.println(root.data+" ");
			return;
		}
		kDistanceNodesFromRoot(root.left, dist-1);
		kDistanceNodesFromRoot(root.right, dist-1);
	}

	private static void printAllRootToLeafPaths(TreeNode root, int[] paths, int i) {

	}

	private static boolean findRootToLeafSumPath(TreeNode rootNode, int sum) {
		if (rootNode == null) {
			return false;
		}
		sum = sum - rootNode.data;
		if (sum == 0) {
			return true;
		}
		return findRootToLeafSumPath(rootNode.left, sum) || findRootToLeafSumPath(rootNode.right, sum);
		
	}

	private static char[] maximumWidthOfBinaryTree(TreeNode root) {
		return null;
	}

}