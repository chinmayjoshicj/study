package tree;

import java.util.Stack;

public class PostOrderIterativeTraversal 
{

	public static void main(String[] args) 
	{
		BinaryTreeCreation b=new BinaryTreeCreation();
		/*b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);*/
		
		/*b.insert(20,b.root);
		b.insert(10,b.root);
		b.insert(30,b.root);
		b.insert(40,b.root);
		b.insert(50,b.root);*/
		
		b.root = new Node(10);
        b.root.left = new Node(2);
        b.root.right = new Node(10);
        b.root.left.left = new Node(20);
        b.root.left.right = new Node(1);
        b.root.right.right = new Node(-25);
        b.root.right.left = new Node(4);
        /*b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);*/
        
        travelIterativePost(b.root);
	}

	private static void travelIterativePost(Node root) 
	{
		Stack<Node> a=new Stack<>();
		Stack<Node> b=new Stack<>();
		a.push(root);
		while(!a.isEmpty())
		{
			root=a.pop();
			b.push(root);
			if (root.left!=null)
			{
				a.push(root.left);
			}
			if (root.right!=null)
			{
				a.push(root.right);
			}
		}
		while(!b.isEmpty())
			System.out.println(b.pop().data);
	}

}
