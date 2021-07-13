package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class TreeNode {
	TreeNode left = null;
	int data;
	int hd;
	TreeNode right = null;
//	TreeNode nextRight = null;

	public TreeNode(int data, int i) {
		this.data = data;
		this.hd = i;	
	}

	public TreeNode(int data) {
		this.data = data;
	}
}

public class Tree {
	static TreeNode root = null;
	static TreeNode root1 = null;
	static int min = Integer.MAX_VALUE;
	static Stack<TreeNode> currLevel = new Stack<>();
	static Stack<TreeNode> nextLevel = new Stack<>();
	static boolean leftToRight = true;
	static int height = 0;
	static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
	static ArrayList<Integer> list = new ArrayList<>();

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
		System.out.println("Height of a Tree:");
		System.out.println(HeightOfaTree(root));
		System.out.println("Is Binary Tree or Not: " + checkTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println();
		System.out.println("Is Binary Tree or Not: Method 2 " + checkTreeBST2(root, null, null));
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
		System.out.println("Top View is:");
		topView(root);
		topView2(root);
		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1) {
				for (int i = 0; i < list.size(); i++) {
					if (entry.getValue().contains(list.get(i))) {
						System.out.print(list.get(i) + " ");
						break;
					}
				}
			} else
				System.out.print(entry.getValue().get(0) + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Diameter of a tree:");
		System.out.println(Diameter(root));
		System.out.println("Boundry Nodes Clockwise:");
		BoundryNodesTraversal(root);
		System.out.println();
		System.out.println();
		System.out.println("Check if 2 Trees are identical or not: " + checkIdentical(root, root1));
		System.out.println();
		System.out.println("Deleting Tree: ");
		deleteTree(root);
		System.out.println();
		System.out.println("Normal Tree");
		printInorder(root);
		System.out.println();
		System.out.println("Mirror Image: ");
		// mirror(root);
		printInorder(root);
		System.out.println();
		System.out.println("Root to Leaf Path Sum: " + findRootToLeafSumPath(root, 54, 0));
		System.out.println();
		System.out.println();
		System.out.println("Inorder without Recursion: ");
		inorderWithoutRecursion(root);
		System.out.println();
		System.out.println();
		System.out.println("Preorder without Recursion: ");
		preorderWithoutRecursion(root);
		System.out.println();
		System.out.println();
		System.out.println("Check if a Tree is Hight Balanced: ");
		System.out.println(isTreeHeightBalanced(root));
		System.out.println();
		System.out.println();
		System.out.println("Convert a Normal Tree into a tree which holds Children Sum Property:");
		// convert(root);//Wrong because we cannot decrement any Value of Node
		inorderWithoutRecursion(root);
		System.out.println();
		System.out.println();
		System.out.println("Sum Of Cousin Nodes is:");
		System.out.println(sumOfCousinNodes(root, 2));
		System.out.println();
		System.out.println();
		System.out.println("Path Sum Equal to k:");
		System.out.println(pathSumK(root, 54));
		System.out.println("Sum Of Cousin Nodes is:");
		ConnectNodesAtSameLevel(root);
		System.out.println();
		System.out.println("K disance nodes from root");
		kDistanceNodesFromRoot(root, 2);
		System.out.println();
		System.out.println();
		int paths[] = new int[100];
		System.out.println("Root To leaf paths are: ");
		printAllRootToLeafPaths(root, paths, 0);
		System.out.println();
		System.out.println();
		System.out.println("Maximum Width Of a Binary Tree: ");
		maximumWidthOfBinaryTree(root);
		System.out.println();
		System.out.println();
		System.out.println("Level order traversal ");
		levelOrderWithoutStackQueue(root);
		System.out.println();
		System.out.println();
		TreeMap<Integer, ArrayList<Integer>> diagonalPrint = new TreeMap<>();
		printDiagonallyTree(root, 0, diagonalPrint);
		for (Entry<Integer, ArrayList<Integer>> entry : diagonalPrint.entrySet()) {
						System.out.print(entry + " ");
		}
		System.out.println();
		System.out.println();
	}

	private static void printDiagonallyTree(TreeNode root, int d, TreeMap<Integer, ArrayList<Integer>> diagonalPrint) {
		if (root == null) {
			return;
		}
		ArrayList<Integer> list = diagonalPrint.get(d);
		if (list == null) {
			list=new ArrayList<>();
			list.add(root.data);
		} else {
			diagonalPrint.get(d).add(root.data);
		}
		diagonalPrint.put(d, list);
		
		printDiagonallyTree(root.left, d+1, diagonalPrint);
		printDiagonallyTree(root.right, d, diagonalPrint);
	}

	private static void levelOrderWithoutStackQueue(TreeNode rootNode) {
		int height = HeightOfaTree(rootNode);
		for (int i = 1; i <= height; i++) {
			printGivenOrder(rootNode, i);
		}
	}

	private static void printGivenOrder(TreeNode rootNode, int level) {
		if (rootNode == null) {
			return;
		}
		if (level == 1) {
			System.out.print(rootNode.data + " ");
		} else {
			printGivenOrder(rootNode.left, level - 1);
			printGivenOrder(rootNode.right, level - 1);
		}
	}

	private static void topView2(TreeNode rootNode) {
		System.out.println();
		if (rootNode == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		Queue<TreeNode> q = new LinkedList<>();

		q.add(rootNode);
		while (!q.isEmpty()) {
			TreeNode t = q.remove();

			if (!set.contains(t.hd)) {
				System.out.print(t.data + " ");
				set.add(t.hd);
			}

			if (t.left != null) {
				q.add(t.left);
			}
			if (t.right != null) {
				q.add(t.right);
			}
		}
	}

	private static void maximumWidthOfBinaryTree(TreeNode rootNode) {
		int maxwidth = 0;
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();

		currLevel.push(rootNode);
		while (!currLevel.isEmpty()) {
			TreeNode temp = currLevel.pop();

			if (temp.left != null) {
				nextLevel.push(temp.left);
			}
			if (temp.right != null) {
				nextLevel.push(temp.right);
			}

			if (currLevel.isEmpty()) {
				if (maxwidth < nextLevel.size()) {
					maxwidth = nextLevel.size();
				}
				Stack<TreeNode> s = currLevel;
				currLevel = nextLevel;
				nextLevel = s;
			}
		}
		System.out.println(maxwidth);
	}

	private static void printAllRootToLeafPaths(TreeNode rootNode, int paths[], int k) {
		if (rootNode == null) {
			return;
		}
		paths[k] = rootNode.data;
		if (rootNode.left == null && rootNode.right == null) {
			for (int i = 0; i <= k; i++) {
				System.out.print(paths[i] + " ");
			}
			System.out.println();
		}
		printAllRootToLeafPaths(rootNode.left, paths, k + 1);
		printAllRootToLeafPaths(rootNode.right, paths, k + 1);
	}

	private static void kDistanceNodesFromRoot(TreeNode rootNode, int k) {
		if (rootNode == null) {
			return;
		}
		// System.out.println("K: "+k);
		if (k == 0) {
			System.out.print(rootNode.data + " ");
		}
		kDistanceNodesFromRoot(rootNode.left, k - 1);
		kDistanceNodesFromRoot(rootNode.right, k - 1);

	}

	private static void ConnectNodesAtSameLevel(TreeNode rootNode) {
//		Stack<TreeNode> currLevel = new Stack<>();
//		Stack<TreeNode> nextLevel = new Stack<>();
//
//		currLevel.push(rootNode);
//		while (!currLevel.isEmpty()) {
//			TreeNode temp = currLevel.pop();
//
//			if (temp.left != null) {
//				nextLevel.push(temp.left);
//			}
//			if (temp.right != null) {
//				nextLevel.push(temp.right);
//			}
//			if (currLevel.isEmpty()) {
//				TreeNode t = nextLevel.pop();
//				while (!nextLevel.isEmpty()) {
//					t.nextRight = nextLevel.peek();
//					t = nextLevel.pop();
//				}
//			}
//		}
	}

	private static boolean pathSumK(TreeNode rootNode, int k) {
		if (rootNode == null) {
			return false;
		}
		k = k - rootNode.data;
		if (k == 0) {
			return true;
		}
		return pathSumK(rootNode.left, k) || pathSumK(rootNode.right, k);
	}

	private static int sumOfCousinNodes(TreeNode rootNode, int num) {
		boolean contains = false;
		int level = 0;
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();

		TreeNode parent = findParent(rootNode, num);
		currLevel.push(rootNode);
		if (rootNode.data == num) {
			return 0;
		}
		while (!currLevel.isEmpty()) {
			level++;
			TreeNode temp = currLevel.pop();
			if (temp.left != null) {
				nextLevel.push(temp.left);
			}
			if (temp.right != null) {
				nextLevel.push(temp.right);
			}
			if (temp.left != null && temp.left.data == num) {
				contains = true;
			}
			if (temp.right != null && temp.right.data == num) {
				contains = true;
			}
			if (contains && currLevel.isEmpty()) {
				break;
			}
			if (currLevel.isEmpty()) {
				Stack<TreeNode> s1 = new Stack<>();
				s1 = currLevel;
				currLevel = nextLevel;
				nextLevel = s1;
			}
		}
		int sum = 0;
		while (!nextLevel.isEmpty()) {
			sum += nextLevel.pop().data;
		}
		if (parent == null) {
			return 0;
		}
		sum = sum - (parent.left == null ? 0 : parent.left.data) - (parent.right == null ? 0 : parent.right.data);
		return sum;
	}

	private static TreeNode findParent(TreeNode rootNode, int num) {
		if (rootNode == null) {
			return null;
		}
		if (rootNode.data == num) {
			return null;
		}
		if (rootNode.left != null && rootNode.left.data == num) {
			return rootNode;
		}
		if (rootNode.right != null && rootNode.right.data == num) {
			return rootNode;
		}
		TreeNode left = findParent(rootNode.left, num);
		TreeNode right = findParent(rootNode.right, num);

		return left == null ? right : left;
	}

	private static void convert(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		convert(rootNode.left);
		convert(rootNode.right);
		if (rootNode.left != null || rootNode.right != null) {
			if (rootNode.left != null && rootNode.right != null) {
				rootNode.data = rootNode.right.data + rootNode.left.data;
			} else if (rootNode.left == null && rootNode.right != null) {
				rootNode.data = rootNode.right.data;
			} else if (rootNode.right == null && rootNode.left != null) {
				rootNode.data = rootNode.left.data;
			}
		}
	}

	private static boolean isTreeHeightBalanced(TreeNode rootNode) {
		if (rootNode == null) {
			return true;
		}
		int leftHeight = HeightOfaTree(rootNode.left);
		int rightHeight = HeightOfaTree(rootNode.right);

		if (Math.abs(leftHeight - rightHeight) == 1 && isTreeHeightBalanced(rootNode.left)
				&& isTreeHeightBalanced(rootNode.right)) {
			return true;
		}
		return false;
	}

	private static void preorderWithoutRecursion(TreeNode rootNode) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = rootNode;

		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				System.out.print(curr.data + " ");
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			curr = curr.right;
		}
	}

	private static void inorderWithoutRecursion(TreeNode rootNode) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode curr = rootNode;
		while (curr != null || !s.isEmpty()) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	private static boolean findRootToLeafSumPath(TreeNode rootNode, int sumReq, int currSum) {
		if (rootNode == null) {
			return false;
		}
		currSum += rootNode.data;

		if (currSum == sumReq && rootNode.left == null && rootNode.right == null) {
			return true;
		}

		return findRootToLeafSumPath(rootNode.left, sumReq, currSum)
				|| findRootToLeafSumPath(rootNode.right, sumReq, currSum);
	}

	private static void printInorder(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		if (rootNode.left != null) {
			printInorder(rootNode.left);
		}
		System.out.print(rootNode.data + " ");
		if (rootNode.right != null) {
			printInorder(rootNode.right);
		}
	}

	private static void mirror(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		mirror(rootNode.left);
		mirror(rootNode.right);

		TreeNode temp = rootNode.left;
		rootNode.left = rootNode.right;
		rootNode.right = temp;

	}

	/*
	 * This function traverses tree in post order to to delete each and every
	 * node of the tree
	 */
	static void deleteTree(TreeNode node) {
		// In Java automatic garbage collection
		// happens, so we can simply make root
		// null to delete the tree

		// Commented
		/* root = null; */
	}

	private static boolean checkIdentical(TreeNode rootNode1, TreeNode rootNode2) {
		if (rootNode1 == null && rootNode2 == null) {
			return true;
		}
		if (rootNode1 == null || rootNode2 == null)// this is correct
		{
			return false;
		}

		if (rootNode1.data != rootNode2.data) {
			return false;
		}
		return (checkIdentical(rootNode1.left, rootNode2.left)) && (checkIdentical(rootNode1.right, rootNode2.right));
	}

	private static void topView(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		topView(rootNode.left);
		if (!map.containsKey(rootNode.hd)) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(rootNode.data);
			map.put(rootNode.hd, list);
		} else {
			ArrayList<Integer> list = map.get(rootNode.hd);
			list.add(rootNode.data);
		}
		topView(rootNode.right);
	}

	private static void levelOrderTraversal(TreeNode rootNode) {
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		currLevel.push(rootNode);
		while (!currLevel.isEmpty()) {
			TreeNode t = currLevel.pop();

			System.out.print(t.data + " ");
			list.add(t.data);
			if (t.left != null) {
				nextLevel.push(t.left);
			}
			if (t.right != null) {
				nextLevel.push(t.right);
			}
			int size = nextLevel.size();
			if (currLevel.isEmpty()) {
				for (int i = 0; i < size; i++) {
					currLevel.push(nextLevel.pop());
				}
			}
		}
	}

	private static void BoundryNodesTraversal(TreeNode rootNode) {
		// System.out.println(rootNode.data);
		TreeNode temp = rootNode;
		while (temp.left != null && temp.right != null) {
			System.out.print(temp.data + " ");
			temp = temp.right;
		}
		printLeafNodes(rootNode);
		temp = rootNode;
		while (temp.left != null && temp.right != null) {
			System.out.print(temp.data + " ");
			temp = temp.left;
		}
	}

	private static void printLeafNodes(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		if (rootNode.left == null && rootNode.right == null) {
			System.out.print(rootNode.data + " ");
		}
		printLeafNodes(rootNode.right);
		printLeafNodes(rootNode.left);
	}

	private static int Diameter(TreeNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		int lheight = HeightOfaTree(rootNode.left);
		int rheight = HeightOfaTree(rootNode.right);

		return Math.max(lheight + rheight + 1, Math.max(Diameter(rootNode.right), Diameter(rootNode.left)));
	}

	private static int HeightOfaTree(TreeNode rootNode) {
		if (rootNode == null) {
			return 0;
		}

		int left = HeightOfaTree(rootNode.left) + 1;
		int right = HeightOfaTree(rootNode.right) + 1;

		return left > right ? left : right;
	}

	private static void spiralOrderTraversal(TreeNode rootNode) {
		currLevel.push(rootNode);
		TreeNode t = null;
		while (!currLevel.isEmpty()) {
			t = currLevel.pop();
			System.out.print(t.data + " ");

			if (leftToRight) {
				if (t.left != null) {
					nextLevel.push(t.left);
				}
				if (t.right != null) {
					nextLevel.push(t.right);
				}
			} else {
				if (t.right != null) {
					nextLevel.push(t.right);
				}
				if (t.left != null) {
					nextLevel.push(t.left);
				}
			}
			if (currLevel.isEmpty() && !nextLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<TreeNode> temp = currLevel;
				currLevel = new Stack<>();
				currLevel = nextLevel;
				nextLevel = temp;
			}
		}
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
	private static boolean checkTreeBST2(TreeNode rootNode, TreeNode l, TreeNode r) {
		if (rootNode == null) {
			return true;
		}
		if (l != null && root.data <= l.data) 
	        return false; 
		
		 if (r != null && root.data >= r.data) 
		        return false; 
		return checkTreeBST2(rootNode.left, l, rootNode)
				&& checkTreeBST2(rootNode.right, rootNode,r);
	}

	private static void findMin(TreeNode rootNode) {
		if (rootNode == null) {
			return;
		}
		System.out.println(rootNode.data);
		if (rootNode.data < min) {
			min = rootNode.data;
		}
		if (rootNode.left != null) {
			findMin(rootNode.left);
		}
		if (rootNode.right != null) {
			findMin(rootNode.right);
		}
	}
}