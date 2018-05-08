package conpanySpecific;

import java.util.Stack;

import tree.Node;

public class ZigZagTreeTraversal {

	static Node root=null;
	private static void insertNode(node root,int i) 
	{
		if(root.data>i)
		{
			if (root.left==null) {
				root.left=new node(i);
			}
			else
			{
				insertNode(root.left,i);
			}
		}
		else if (root.data<i) {
			if (root.right==null) {
				root.right=new node(i);
			}
			else
				insertNode(root.right, i);
		}
	}
	public static void main(String[] args)
	{
		root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        
        zigZagTraverse(root);

	}
	private static void zigZagTraverse(Node node)	 
	{
		if (node==null)
		{
			return;
		}
		
		Stack<Node> currLevel=new Stack<>();
		Stack<Node> nextLevel=new Stack<>();
		Boolean leftToRight=true;
		
		currLevel.push(node);
		
		while (!currLevel.isEmpty()) 
		{
			Node n1=currLevel.pop();
			System.out.print(n1.data+" ");
			
			if (leftToRight)
			{
				if (n1.left!=null) {
					nextLevel.push(n1.left);
				}
				if (n1.right!=null) {
					nextLevel.push(n1.right);
				}
			}
			else
			{
				if (n1.right!=null) {
					nextLevel.push(n1.right);
				}
				if (n1.left!=null) {
					nextLevel.push(n1.left);
				}
			}
			
			if (currLevel.isEmpty()) {
				leftToRight=!leftToRight;
				Stack<Node> temp=currLevel;
				currLevel=nextLevel;
				nextLevel=temp;
			}
		}
	}
}
