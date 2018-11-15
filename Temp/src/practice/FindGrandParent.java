package practice;

import java.util.HashMap;
import java.util.Map;

public class FindGrandParent 
{
	static TreeNode root=null;
	static HashMap<Integer, TreeNode> map= new HashMap<>();
	static Integer arr[]= new Integer[100];
	public static void main(String[] args) 
	{
		root=new TreeNode(20,0);
		root.left=new TreeNode(8,-1);
		root.left.left=new TreeNode(3,-2);
		
		root.right=new TreeNode(22,1);
//		root.right.right=new TreeNode(29,1);
		
		root.left.right=new TreeNode(12,0);
		root.left.right.right=new TreeNode(14,1);
		
		root.left.right.left=new TreeNode(10,-1);
		int num=10;
		 findGrandParentMethod1(root,num);
		 findGrandParentMethod2(root);
		 int parent= find(num);
		 int Grandparent= find(parent);
		 System.out.println(Grandparent);
		 findGrandParentMethod3(root,num,0);
	}
	private static void findGrandParentMethod3(TreeNode rootNode, int num, int k) 
	{
		if (rootNode==null) {
			return;
		}
		arr[k]=rootNode.data;
		if (rootNode.data==num) {
			System.out.println(arr[k-2]);
			return;
		}
		findGrandParentMethod3(rootNode.left, num, k+1);
		findGrandParentMethod3(rootNode.right, num, k+1);
	}
	private static Integer find(int num) 
	{
		return map.get(num).data;
	}
	private static void findGrandParentMethod2(TreeNode rootNode) 
	{
		if (rootNode==null)
		{
			return;
		}
		if (rootNode.left!=null) {
			map.put(rootNode.left.data, rootNode);
		}
		if (rootNode.right!=null) {
			map.put(rootNode.right.data, rootNode);
		}
		findGrandParentMethod2(rootNode.left);
		findGrandParentMethod2(rootNode.right);
	}
	private static void findGrandParentMethod1(TreeNode rootNode, int num)
	{
		if (rootNode==null) {
			return;
		}
		if (rootNode.left!=null) {
			if (rootNode.left.left!=null) {
				if (rootNode.left.left.data==num) {
					System.out.println(rootNode.data);
					return;
				}
			}
		}
		if (rootNode.left!=null) {
			if (rootNode.left.right!=null) {
				if (rootNode.left.right.data==num) {
					System.out.println(rootNode.data);
					return;
				}
			}
		}
		if (rootNode.right!=null) {
			if (rootNode.right.left!=null) {
				if (rootNode.right.left.data==num) {
					System.out.println(rootNode.data);
					return;
				}
			}
		}
		if (rootNode.right!=null) {
			if (rootNode.right.right!=null) {
				if (rootNode.right.right.data==num) {
					System.out.println(rootNode.data);
					return;
				}
			}
		}
		findGrandParentMethod1(rootNode.left, num);
		findGrandParentMethod1(rootNode.right, num);
	}
}
