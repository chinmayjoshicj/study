package tree;

public class RootToLeafPathPractive {
	Node root;
	int a[]= new int[1000];
	private void Paths(Node root, int i) 
	{
		if (root==null)
		{
			return;
		}
		Paths(root.left,i);
	}
	public static void main(String[] args) {
		RootToLeafPathPractive b=new RootToLeafPathPractive();
        
	       /* b.root = new Node(10);
	        b.root.left = new Node(2);
	        b.root.right = new Node(10);
	        b.root.left.left = new Node(20);
	        b.root.left.right = new Node(1);
	        b.root.right.right = new Node(-25);
	        b.root.right.right.left = new Node(3);
	        b.root.right.right.right = new Node(4);*/
			
			/*b.root = new Node(1);
	        b.root.left = new Node(2);
	        b.root.right = new Node(3);
	        b.root.left.left = new Node(4);
	        b.root.left.right = new Node(5);
//	        b.inOrader(b.root);
	 
	*/		b.root = new Node(20);
			b.root.left = new Node(8);
			b.root.right = new Node(22);
			b.root.left.left = new Node(4);
			b.root.left.right = new Node(12);
			b.root.left.right.left = new Node(10);
			b.root.left.right.right = new Node(14);

			b.Paths(b.root, 0);
	        
	       
	        System.out.println();

	}

}
