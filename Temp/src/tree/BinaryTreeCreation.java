package tree;

class Node1 {
	int data;
	Node1 left;
	Node1 right;

	public Node1(int item) {
		data = item;
		left = right = null;
	}
}

public class BinaryTreeCreation {
	Node root;
	static int max=0;

	public BinaryTreeCreation() {
		this.root = null;
	}

	public BinaryTreeCreation(int item) {
		this.root = new Node(item);
	}

	public void insert(int item, Node1 root) {
		if (root == null) {
			this.root = new Node(item);
			return;
		} else if (root.data > item) {
			if (root.left == null) {
				root.left = new Node1(item);
				return;
			} else
				insert(item, root.left);
		} else {
			if (root.right == null) {
				root.right = new Node1(item);
				return;
			} else {
				insert(item, root.right);
			}
		}
	}

	public int MaxPathSum(Node root2, int sum) 
	{
		return sum;
		/*if (root == null) 
		{
			return sum;
		} 
		else
		{	
			sum=MaxPathSum(root.left, sum);
			sum=sum+root.data;
			if (sum>max) {
				max=sum;
			}
			sum=MaxPathSum(root.right, sum);
			if (sum>max) {
				max=sum;
			}
			return sum;
		}*/
	}

	public void inOrader(Node1 node) {

		if (node != null) {
			inOrader(node.left);
			System.out.println(node.data);
			inOrader(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeCreation b = new BinaryTreeCreation();
		/*
		 * b.root=new Node(1); b.root.left=new Node(2); b.root.right=new
		 * Node(3); b.root.left.left=new Node(4);
		 */

		/*
		 * b.insert(20,b.root); b.insert(10,b.root); b.insert(30,b.root);
		 * b.insert(40,b.root); b.insert(50,b.root);
		 */

		b.root = new Node(10);
		b.root.left = new Node(2);
		b.root.right = new Node(10);
		b.root.left.left = new Node(20);
		b.root.left.right = new Node(1);
		b.root.right.right = new Node(-25);
		b.root.right.right.left = new Node(3);
		b.root.right.right.right = new Node(4);

		b.MaxPathSum(b.root,0);
		System.out.println(max);
		// System.out.println(b.root.left.key);
		/*
		 * System.out.println(b.root.right.key);
		 * System.out.println(b.root.left.left.key);
		 * System.out.println(b.root.key);
		 */
	}

}
