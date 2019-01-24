package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
		LeftView(root, 1);
		for (Entry<Integer, TreeNode> entry : leftViewMap.entrySet()) {
			System.out.print(entry.getValue().data + " ");
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
	}

	private static void findMin(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.data < min) {
			min = root.data;
		}
		findMin(root.left);
		findMin(root.right);
	}

	private static int HeightOfaTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = HeightOfaTree(root.left) + 1;
		int right = HeightOfaTree(root.right) + 1;

		return left > right ? left : right;
	}

	private static boolean checkTreeBST(TreeNode rootNode, int minValue, int maxValue) {
		if (rootNode == null) {
			return true;
		}
		if (rootNode.data > maxValue || rootNode.data < minValue) {
			return false;
		}
		return checkTreeBST(rootNode.left, minValue, rootNode.data - 1)
				&& checkTreeBST(rootNode.right, rootNode.data + 1, maxValue);
	}

	private static void levelOrderTraversal(TreeNode root) {
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();

		currLevel.push(root);

		while (!currLevel.empty()) {
			TreeNode pop = currLevel.pop();
			System.out.print(pop.data + " ");
			if (pop.left != null) {
				nextLevel.push(pop.left);
			}
			if (pop.right != null) {
				nextLevel.push(pop.right);
			}
			if (currLevel.isEmpty()) {
				Stack<TreeNode> temp = currLevel;
				currLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}

	private static void levelOrderWithoutStackQueue(TreeNode root) {
		if (root == null) {
			return;
		}
		for (int i = 1; i <= HeightOfaTree(root); i++) {
			printLevel(root, i);
		}
	}

	private static void printLevel(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + " ");
		} else if (level > 1) {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	private static void topView(TreeNode root) {
		if (root == null) {
			return;
		}
		HashMap<Integer, TreeNode> map = new HashMap<>();
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty()) {
			TreeNode pop = s1.pop();
			if (!map.containsKey(pop.hd)) {
				map.put(pop.hd, pop);
			}
			if (pop.left != null) {
				s2.push(pop.left);
			}
			if (pop.right != null) {
				s2.push(pop.right);
			}
			if (s1.isEmpty()) {
				Stack<TreeNode> s3 = new Stack<>();
				s3 = s1;
				s1 = s2;
				s2 = s3;
			}
		}
		Set<Entry<Integer, TreeNode>> entrySet = map.entrySet();
		for (Entry<Integer, TreeNode> entry : entrySet) {
			System.out.print(entry.getValue().data + " ");
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

	private static void LeftView(TreeNode root, int level) 
	{
		if (root==null) {
			return;
		}
		if (max_level<level)
		{
			leftViewMap.put(level,root);
			max_level=level;
		}
		LeftView(root.left, level+1);
		LeftView(root.right, level+1);
	}

	private static void BottomView(TreeNode root)
	{
		if (root == null) {
			return;
		}
		HashMap<Integer, TreeNode> map = new HashMap<>();
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty()) {
			TreeNode pop = s1.pop();
				map.put(pop.hd, pop);
			if (pop.left != null) {
				s2.push(pop.left);
			}
			if (pop.right != null) {
				s2.push(pop.right);
			}
			if (s1.isEmpty()) {
				Stack<TreeNode> s3 = new Stack<>();
				s3 = s1;
				s1 = s2;
				s2 = s3;
			}
		}
		Set<Entry<Integer, TreeNode>> entrySet = map.entrySet();
		for (Entry<Integer, TreeNode> entry : entrySet) {
			System.out.print(entry.getValue().data + " ");
		}
	}

	private static void preorderWithoutRecursion(TreeNode root) {
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

	private static void printAllRootToLeafPaths(TreeNode root, int[] paths, int i) {
		if (root == null) {
			return;
		}
		paths[i] = root.data;

		if (root.left == null && root.right == null) {
			for (int j = 0; j <= i; j++) {
				System.out.print(paths[j] + " ");
			}
			System.out.println();
			return;
		}
		printAllRootToLeafPaths(root.left, paths, i + 1);
		printAllRootToLeafPaths(root.right, paths, i + 1);
	}

	private static void kDistanceNodesFromRoot(TreeNode root, int dist) {
		if (root == null) {
			return;
		}
		if (dist == 0) {
			System.out.print(root.data + " ");
		}
		kDistanceNodesFromRoot(root.left, dist - 1);
		kDistanceNodesFromRoot(root.right, dist - 1);
	}

	private static char[] isTreeHeightBalanced(TreeNode root) {
		return null;
	}

	private static void inOrderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> s1 = new Stack<>();
		s1.push(root);
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

	private static boolean findRootToLeafSumPath(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		// System.out.println(sum);
		sum = sum - root.data;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				return true;
			}
		}
		return findRootToLeafSumPath(root.left, sum) || findRootToLeafSumPath(root.right, sum);
	}
}