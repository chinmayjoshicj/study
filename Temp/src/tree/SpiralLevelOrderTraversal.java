package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralLevelOrderTraversal {

	Node root;
	
	
	private void PrintSpiral(Node root) {
		
		if (root==null) {
			return;
		}
		Queue<Node> queue= new LinkedList<Node>();
		Stack<Node> stack= new Stack<Node>();
		
		queue.add(root);
		while (!queue.isEmpty() || !stack.isEmpty()) 
		{
			if (!queue.isEmpty())
			{
				Node temp=queue.poll();
				System.out.println(temp.data);
				
				if (temp.left!=null) {
					stack.push(temp.left);
				}
				if (temp.right!=null) {
					stack.push(temp.right);
				}
			}
			if (!stack.isEmpty())
			{
				Node temp=stack.pop();
				System.out.println(temp.data);
				
				if (temp.left!=null) {
					queue.add(temp.left);
				}
				if (temp.right!=null) {
					queue.add(temp.right);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		
		SpiralLevelOrderTraversal b=new SpiralLevelOrderTraversal();
        
	       /* b.root = new Node(10);
	        b.root.left = new Node(2);
	        b.root.right = new Node(10);
	        b.root.left.left = new Node(20);
	        b.root.left.right = new Node(1);
	        b.root.right.right = new Node(-25);
	        b.root.right.right.left = new Node(3);
	        b.root.right.right.right = new Node(4);*/
			
			b.root = new Node(1);
	        b.root.left = new Node(2);
	        b.root.right = new Node(3);
	        b.root.left.left = new Node(4);
	        b.root.left.right = new Node(5);
	        //b.inOrader(b.root);
	 
			/*b.root = new Node(20);
			b.root.left = new Node(8);
			b.root.right = new Node(22);
			b.root.left.left = new Node(4);
			b.root.left.right = new Node(12);
			b.root.left.right.left = new Node(10);
			b.root.left.right.right = new Node(14)*/;

			b.PrintSpiral(b.root);
	}

	

	

}
