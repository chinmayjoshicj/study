package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
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
		root = new TreeNode(20, 0);
		root.left = new TreeNode(8, -1);
		root.left.left = new TreeNode(3, -2);

		root.right = new TreeNode(22, 1);
		// root.right.right=new TreeNode(29,1);

		root.left.right = new TreeNode(12, 0);
		root.left.right.right = new TreeNode(14, 1);

		root.left.right.left = new TreeNode(10, -1);
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
		System.out.println("Is Binary Search Tree or Not: " + checkTreeBST(root, null, null));
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
		System.out.println();
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
		System.out.println("Max Width of Tree is: ");
		System.out.println(maximumWidthOfBinaryTree(root));
	}

	private static void BoundryNodesTraversal(TreeNode rootNode) {
		if(root==null) {
			return;
		}
		printRightBoundry(root);
		System.out.println();
		printBottomBoundry(root);
		System.out.println();
		printLeftBoundry(root);
		System.out.println();
		System.out.println();
		
//				TreeNode temp = rootNode;
//				while (temp.left != null && temp.right != null) {
//					System.out.print(temp.data + " ");
//					temp = temp.right;
//				}
//				printBottomBoundry(rootNode);
//				temp = rootNode;
//				while (temp.left != null && temp.right != null) {
//					System.out.print(temp.data + " ");
//					temp = temp.left;
//				}
//				System.out.println();
	}

	private static void printBottomBoundry(TreeNode root) {
		if(root==null)
		{
			return;
		}
		if(root.left==null && root.right==null) {
			System.out.print(root.data+" ");
		}
		printBottomBoundry(root.right);
		printBottomBoundry(root.left);
	}

	private static void printLeftBoundry(TreeNode root) {
		if(root==null)
		{
			return;
		}
		
		printLeftBoundry(root.left);
		
		if(root.left!=null && root.right!=null && TreePractice.root!=root) {
			System.out.print(root.data+" ");
		}
	}

	private static void printRightBoundry(TreeNode root) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.nextRight==null) {
			return;
		}
		System.out.print(root.data+" ");
	}

	private static void spiralOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		currLevel.add(root);
		while (!currLevel.isEmpty()) {
			TreeNode pop = currLevel.pop();
			System.out.print(pop.data+" ");
			if(pop!=null) {
				if(leftToRight) {
					if(pop.left!=null) {
						nextLevel.add(pop.left);
					}
					if(pop.right!=null) {
						nextLevel.add(pop.right);
					}
					
				}
				else {
					if(pop.right!=null) {
						nextLevel.add(pop.right);
					}
					if(pop.left!=null) {
						nextLevel.add(pop.left);
					}
				}
			}
			if(currLevel.isEmpty()) {
				leftToRight=!leftToRight;
				Stack<TreeNode> s=nextLevel;
				nextLevel=currLevel;
				currLevel=s;
			}
		}
	}

	private static void findMin(TreeNode root) {
		if(root==null) {
			return;
		}
		if(root.data<min) {
			min=root.data;
		}
		findMin(root.left);
		findMin(root.right);
	}

	private static void topView(TreeNode root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode> q= new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode peek = q.poll();
			if(!topViewMap.containsKey(peek.hd)) {
				topViewMap.put(peek.hd, peek);
			}
			if(peek.left!=null) {
				q.add(peek.left);
			}
			if(peek.right!=null) {
				q.add(peek.right);
			}
		}
	}

	private static int HeightOfaTree(TreeNode root) {
		
		if(root==null) {
			return 0;
		}
		int lh=HeightOfaTree(root.left);
		int rh=HeightOfaTree(root.right);
//		System.out.println("left height for "+root.data+" "+lh);
//		System.out.println("right height for "+root.data+" "+rh);
		return Integer.max(lh+1,rh+1);
															
	}

	private static boolean checkTreeBST(TreeNode rootNode, TreeNode l, TreeNode r) {
		
		if (rootNode == null) {
			return true;
		}
		if (l != null && rootNode.data <= l.data) 
	        return false; 
		
		 if (r != null && rootNode.data >= r.data) 
		        return false; 
		return checkTreeBST(rootNode.left, l, rootNode)
				&& checkTreeBST(rootNode.right, rootNode,r);
	}

	private static void levelOrderTraversal(TreeNode root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode> q= new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode pop=q.poll();
			System.out.print(pop.data+" ");
			if(pop!=null && pop.left!=null) {
				q.add(pop.left);
			}
			if(pop!=null && pop.right!=null) {
				q.add(pop.right);
			}
		}		
	}

	private static void levelOrderWithoutStackQueue(TreeNode root) {
		if(root==null) {
			return;
		}
		int height=HeightOfaTree(root);
		for (int i = 0; i <=height; i++) {
			levelOrderUtils(root, i);
		}
	}

	private static void levelOrderUtils(TreeNode root, int level) {
		if(root==null) {
			return;
		}
		if(level==1) {
			System.out.print(root.data+" ");
		}
		else {
			levelOrderUtils(root.left, level-1);
			levelOrderUtils(root.right, level-1);
		}
	}

	private static int Diameter(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int lh=HeightOfaTree(root.left);
		int rh=HeightOfaTree(root.right);
		
		return Integer.max(lh+rh+1, Integer.max(Diameter(root.left), Diameter(root.right)));
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
			System.out.print(root.data+" ");
		}
		kDistanceNodesFromRoot(root.left, dist-1);
		kDistanceNodesFromRoot(root.right, dist-1);
	}

	private static void printAllRootToLeafPaths(TreeNode root, int[] paths, int sum) {
		if(root==null) {
			return;
		}
		if(root.left ==null && root.right==null) {
			System.out.print(sum+root.data+" ");
			System.out.println();
			return;
		}
		printAllRootToLeafPaths(root.left, paths, sum+root.data);		
		printAllRootToLeafPaths(root.right, paths, sum+root.data);	
	}

	private static boolean findRootToLeafSumPath(TreeNode rootNode, int sum) {
		if(root==null) {
			return false;
		}
		if(sum==0) {
			return true;
		}
		sum=sum-rootNode.data;
		return findRootToLeafSumPath(rootNode.left, sum) ||
		findRootToLeafSumPath(rootNode.right, sum);
	}

	private static int maximumWidthOfBinaryTree(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int max=0;
		currLevel.add(root);
		
		while (!currLevel.isEmpty()) {
			TreeNode poll = currLevel.pop();
			if(!(poll.left==null)) {
				nextLevel.add(poll.left);
			}
			if(!(poll.right==null)) {
				nextLevel.add(poll.right);
			}
			if(currLevel.isEmpty()) {
				if(max<nextLevel.size()) {
					max=nextLevel.size();					
				}
				Stack<TreeNode> s=nextLevel;
				nextLevel=currLevel;
				currLevel=s;
			}
		}
		return max;
	}

}