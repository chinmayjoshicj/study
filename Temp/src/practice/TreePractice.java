package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
		// root.left.right.right.right = new TreeNode(15, 2);

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
		// System.out.println("Spiral traversal of a tree: ");
		// levelOrderTraversal(root);
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
		// topView2(root);
		for (Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
		System.out.println();
		System.out.println();

		System.out.println("Diameter of a tree:");
		System.out.println(Diameter(root));

		// System.out.println("Boundry Nodes Clockwise:");
		// BoundryNodesTraversal(root);
		System.out.println();
		System.out.println("Left View Is");
		LeftViewMy(root);
		for (Entry<Integer, TreeNode> entry : leftViewMap.entrySet()) {
			System.out.print(/* entry.getKey()+" "+ */entry.getValue().data + " ");
		}
		System.out.println();
		System.out.println("Bottom View");
		BottomView(root);
		for (Entry<Integer, TreeNode> entry : bottomViewMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
		System.out.println();
		// System.out.println("Check if 2 Trees are identical or not:
		// "+checkIdentical(root,root1));
		// System.out.println();
		// System.out.println("Deleting Tree: ");
		// deleteTree(root);
		// System.out.println();
		// System.out.println("Normal Tree");
		// printInorder(root);
		// System.out.println();
		// System.out.println("Mirror Image: ");
		// mirror(root);
		// printInorder(root);
		// System.out.println();
		// System.out.println();
		// System.out.println();
		System.out.println("IreOrder without Recursion: ");
		inOrderWithoutRecursion(root);
		System.out.println();
		System.out.println();
		System.out.println("Preorder without Recursion: ");
		preorderWithoutRecursion(root);
		System.out.println();
		System.out.println();
		System.out.println("Check if a Tree is Height Balanced: ");
		// System.out.println(isTreeHeightBalanced(root));
		System.out.println();
		System.out.println();
		/*
		 * System.out.println("Convert a Normal Tree into a tree which holds //
		 * Children Sum Property:"); // //convert(root);//Wrong because we
		 * cannot decrement any Value of Node // inorderWithoutRecursion(root);
		 * // System.out.println(); // System.out.println(); //
		 * System.out.println("Sum Of Cousin Nodes is:"); //
		 * System.out.println(sumOfCousinNodes(root,2)); //
		 * System.out.println(); // System.out.println(); System.out.println(
		 * "Path Sum Equal to k:"); System.out.println(pathSumK(root,31)); //
		 * System.out.println("Sum Of Cousin Nodes is:"); //
		 * ConnectNodesAtSameLevel(root); //
		 * 
		 * System.out.println(); System.out.println(); System.out.println(
		 * "Maximum Width Of a Binary Tree: ");
		 * System.out.println(maximumWidthOfBinaryTree(root));
		 */
		System.out.println();
		System.out.println("K distance nodes from root");
		kDistanceNodesFromRoot(root, 2);
		System.out.println();
		System.out.println();
		System.out.println("Grand Parent: ");
		// findGrandParent(root,3);
		System.out.println();
		System.out.println();
		int paths[] = new int[100];
		System.out.println("Root To leaf paths are: ");
		printAllRootToLeafPaths(root, paths, 0);
		System.out.println("Root to Leaf Path Sum: " + findRootToLeafSumPath(root, 54));
		System.out.println();
		System.out.println();
		System.out.println("Max Width of Tree is: ");
//		System.out.println(maximumWidthOfBinaryTree(root));
	}

	private static void findMin(TreeNode root) {
		if (root == null) {
			return;
		}
		if (min > root.data) {
			min = root.data;
		}
		findMin(root.left);
		findMin(root.right);
	}

	private static void topView(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode pop = s1.pop();
			if (!topViewMap.containsKey(pop.hd)) {
				topViewMap.put(pop.hd, pop);
			}
			if (pop.left != null) {
				s2.push(pop.left);
			}
			if (pop.right != null) {
				s2.push(pop.right);
			}
			if (s1.isEmpty()) {
				Stack<TreeNode> temp = s1;
				s1 = s2;
				s2 = temp;
			}
		}
	}

	private static int HeightOfaTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = HeightOfaTree(root.left) + 1;
		int right = HeightOfaTree(root.right) + 1;

		return Integer.max(right, left);
	}

	private static boolean checkTreeBST(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if ((root.left != null && root.data < root.left.data) || (root.right != null && root.data > root.right.data)) {
			return false;
		}
		return checkTreeBST(root.left, minValue, root.data - 1) && checkTreeBST(root.right, root.data + 1, maxValue);
	}

	private static void levelOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode pop = s1.pop();
			System.out.print(pop.data + " ");
			if (pop.left != null) {
				s2.push(pop.left);
			}
			if (pop.right != null) {
				s2.push(pop.right);
			}
			if (s1.isEmpty()) {
				Stack<TreeNode> temp = s1;
				s1 = s2;
				s2 = temp;
			}
		}
	}

	private static void levelOrderUtils(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		}
		levelOrderUtils(root.left, level - 1);
		levelOrderUtils(root.right, level - 1);
	}

	private static void levelOrderWithoutStackQueue(TreeNode root) {
		if (root == null) {
			return;
		}
		for (int i = 1; i <= HeightOfaTree(root); i++) {
			levelOrderUtils(root, i);
		}
	}

	private static int Diameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lh = HeightOfaTree(root.left);
		int rh = HeightOfaTree(root.right);

		return Integer.max(lh + rh + 1, Integer.max(Diameter(root.left), Diameter(root.right)));
	}

	private static void LeftViewMy(TreeNode root) {
		if (root == null) {
			return;
		}
		leftViewUtils(root, 1);
	}

	private static void leftViewUtils(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level > max_level) {
			max_level = level;
			System.out.print(root.data + " ");
		}
		leftViewUtils(root.left, level + 1);
		leftViewUtils(root.right, level + 1);
	}

	private static void BottomView(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode pop = s1.pop();
			bottomViewMap.put(pop.hd, pop);
			if (pop.left != null) {
				s2.push(pop.left);
			}
			if (pop.right != null) {
				s2.push(pop.right);
			}
			if (s1.isEmpty()) {
				Stack<TreeNode> temp = s1;
				s1 = s2;
				s2 = temp;
			}
		}
	}

	private static void inOrderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !s1.isEmpty()) {
			while (curr != null) {
				s1.push(curr);
				curr = curr.left;
			}
			curr = s1.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	private static void preorderWithoutRecursion(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s1 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode pop = s1.pop();
			System.out.print(pop.data + " ");
			if (pop.right != null) {
				s1.push(pop.right);
			}
			if (pop.left != null) {
				s1.push(pop.left);
			}
		}
	}

	private static void kDistanceNodesFromRoot(TreeNode root, int dist) {

		if (root == null) {
			return;
		}
		if (dist == 0) {
			System.out.print(root.data + " ");
			return;
		}
		kDistanceNodesFromRoot(root.left, dist - 1);
		kDistanceNodesFromRoot(root.right, dist - 1);
	}

	private static void printAllRootToLeafPaths(TreeNode root, int[] paths, int i) {
		if (root==null) {
			return;
		}
		paths[i++]=root.data;
		if (root.left==null &&  root.right==null) {
			for (int j = 0; j < i; j++) {
				System.out.print(paths[j]+" ");
			}
			System.out.println();
		}
		printAllRootToLeafPaths(root.left, paths, i);
		printAllRootToLeafPaths(root.right, paths, i);
	}

	private static String findRootToLeafSumPath(TreeNode root, int i) {
		return null;
	}

	private static char[] maximumWidthOfBinaryTree(TreeNode root) {
		return null;
	}

}