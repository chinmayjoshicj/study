package crackingCodingInterview;

/*https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem*/
/*Incomplete*/
class TreeNode {
	int data;
	int hd;
	TreeNode left;
	TreeNode right;

	public TreeNode(int item) {
		data = item;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}

public class BinaryTreeCheck {

	static TreeNode root;
	static int check = 0;
	static int min = 0;
	static int max = 0;
	
	public static void main(String[] args) {
		BinaryTreeCheck tree = new BinaryTreeCheck();
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.left.left=new TreeNode(1);
		tree.root.right.right = new TreeNode(6);
		tree.root.right.right.right = new TreeNode(7);
		/*tree.root.right.left = new TreeNode(2);
		tree.root.right.right = new TreeNode(25);
		tree.root.left.right.left = new TreeNode(1);
		tree.root.left.right.right = new TreeNode(27);*/
		checkBST();
		if (check == 1)
			System.out.println("No");
		else
			System.out.println("Yes");
	}
	private static void checkBST() {
		traverse(root);
	}
	private static void traverse(TreeNode root) {
		if (root != null) 
		{
			if (root.data>max) {
				max=root.data;
			}
			if (root.data<min) {
				min=root.data;
			}
			if (root.left!=null)
			{
					if (root.left.data<root.data && root.left.data<min) {
						traverse(root.left);
					}
					else
					{
						check =1;
						return;
					}
			}
			if (root.right!=null)
			{
				if (root.right.data>root.data && root.right.data>max) {
					traverse(root.right);
				}
				else
				{
					check =1;
					return;
				}
			}
			if (root.left != null && root.right != null) {
				if (root.data < root.left.data) {
					check = 1;
					return;
				}
			}
			if (root.right == null) 
			{
				if (root.left == null) 
				{
					return;
				} 
				else
				{
					if (root.data < root.left.data) 
					{
						check = 1;
						return;
					}
				}
			}
			else if (root.left == null) 
			{
				if (root.right == null) 
				{
					return;
				} 
				else {
					if (root.data > root.right.data) {
						check = 1;
						return;
					}
				}
			}

		}
	}
}
