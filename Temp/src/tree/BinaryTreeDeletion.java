package tree;

public class BinaryTreeDeletion {
	Node root;
	
	public BinaryTreeDeletion() {
		this.root = null;
	}
	
	public BinaryTreeDeletion(int item) {
		this.root=new Node(item);
	}
	public void inOrader(Node node){
		
		if(node != null){
			inOrader(node.left);
			System.out.println(node.data);
			inOrader(node.right);
		}
	}
	public static void main(String[] args) 
	{
		BinaryTreeDeletion b=new BinaryTreeDeletion();
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
        b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);
        
       deleteTree(b.root);
       b.inOrader(b.root);
       b.root = null;
       System.out.println("END..");
       b.inOrader(b.root);
	}

	private static void deleteTree(Node node) {
		if(node == null) return;
		
		deleteTree(node.left);
		if(node.left!=null)
		System.out.println("deleting..."+node.left.data);
		else 
				System.out.println("deleting left...null"+node.data);
		node.left = null;
		deleteTree(node.right);
		if(node.right!=null)
			System.out.println("deleting..."+node.right.data);
			else 
					System.out.println("deleting right...null"+node.data);
		node.right = null;
		
	}

}
