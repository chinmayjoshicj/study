package tree;

public class RemoveNodesWithPathLessThanK {
	Node root;
	
	public Node remove(Node node, int level, int k)
	{
		if (node==null) {
			return null;
		}
		
		node.left=remove(node.left, level+1, k);
		node.right=remove(node.right, level+1, k);
		
		if (node.left==null && node.right==null && level<k)
		{
			return null;
		}
		
		return node;
	}
		
		public void inOrader(Node node){
			
			if(node != null){
				inOrader(node.left);
				System.out.print(node.data);
				inOrader(node.right);
			}
		}

	public static void main(String[] args) 
	{
		RemoveNodesWithPathLessThanK b=new RemoveNodesWithPathLessThanK();
		/*b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);*/
		
		/*b.insert(20,b.root);
		b.insert(10,b.root);
		b.insert(30,b.root);
		b.insert(40,b.root);
		b.insert(50,b.root);*/
		int k=4;
		
		b.root = new Node(1);
        b.root.left = new Node(2);
        b.root.right = new Node(3);
        b.root.left.left = new Node(4);
        b.root.left.left.left = new Node(7);
        b.root.left.right = new Node(5);
        b.root.right.right = new Node(6);
        b.root.right.right.left = new Node(8);
//        b.root.right.right.right = new Node(4);
        
        b.inOrader(b.root);
        System.out.println();
        b.remove(b.root, 1,k);
        b.inOrader(b.root);
		//System.out.println(b.root.left.key);
	/*	System.out.println(b.root.right.key);
		System.out.println(b.root.left.left.key);
		System.out.println(b.root.key);	*/	
	}

}
