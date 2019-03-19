package practice;

import java.util.HashMap;

public class FindGrandParentPractice {
	static TreeNode root = null;
	static HashMap<Integer, TreeNode> map = new HashMap<>();
	static Integer arr[] = new Integer[100];

	public static void main(String[] args) {
		root = new TreeNode(20, 0);
		root.left = new TreeNode(8, -1);
		root.left.left = new TreeNode(3, -2);

		root.right = new TreeNode(22, 1);
		// root.right.right=new TreeNode(29,1);

		root.left.right = new TreeNode(12, 0);
		root.left.right.right = new TreeNode(14, 1);

		root.left.right.left = new TreeNode(10, -1);
		int num = 10;
		findGrandParentMethod(root, num, 0);

	}

	private static void findGrandParentMethod(TreeNode root, int num, int i) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			if (root.left.left != null && root.left.left.data == num) {
				System.out.println("Grand parent is " + root.data);
			}
			if (root.left.left != null && root.left.right.data == num) {
				System.out.println("Grand parent is " + root.data);
			}
		}
		if (root.right != null) {
			if (root.right.left != null && root.right.left.data == num) {
				System.out.println("Grand parent is " + root.data);
			}
			if (root.right.right != null && root.right.right.data == num) {
				System.out.println("Grand parent is " + root.data);
			}
		}
		findGrandParentMethod(root.left, num, i);
		findGrandParentMethod(root.right, num, i);
	}
}
