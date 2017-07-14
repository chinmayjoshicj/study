package tree;

public class MirrorOfTree {

	Node root;
	
	public void mirror(Node root) 
	{
		if(root==null)
			return;
		Node temp;
		
		mirror(root.left);
		mirror(root.right);
		
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		
	}
public void inOrader(Node node){
		
		if(node == null){
			return;
		}
			inOrader(node.left);
			System.out.println(node.data);
			inOrader(node.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MirrorOfTree b=new MirrorOfTree();
        
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
        b.inOrader(b.root);
        b.mirror(b.root);
        System.out.println();
        b.inOrader(b.root);
        
	}

}
