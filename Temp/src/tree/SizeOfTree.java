package tree;

public class SizeOfTree {

	Node root;
	int size;
	public int size(Node root) {
		
		if (root==null) {
			return 0;
		}
		size++;
		size(root.left);
		size(root.right);
		return size;
	}
	public static void main(String[] args)
	{
		SizeOfTree b=new SizeOfTree();
		
		b.root = new Node(10);
        b.root.left = new Node(2);
        b.root.right = new Node(10);
        b.root.left.left = new Node(20);
        b.root.left.right = new Node(1);
        b.root.right.right = new Node(-25);
        b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);
        
        System.out.println(b.size(b.root));

	}

}
