package tree;

public class CheckIdenticalTrees {

	Node root;
	
	public static boolean check(Node root1, Node root2) 
	{
		boolean c=true;
		if ((root1==null && root2==null)) {
			return c;
		}
		if (root1.data!=root2.data) {
			return !c;
		}
		if (root1!= null && root2!=null )
		{
			return ((root1.data==root2.data) && (check(root1.left,root2.left) && (check(root1.right, root2.right))));
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDepthOftree a=new MaxDepthOftree();
		MaxDepthOftree b=new MaxDepthOftree();
		
		a.root = new Node(10);
        a.root.left = new Node(2);
        a.root.right = new Node(10);
        a.root.left.left = new Node(20);
        a.root.left.right = new Node(1);
        a.root.right.right = new Node(-25);
        a.root.right.right.left = new Node(3);
        a.root.right.right.right = new Node(4);
        
        b.root = new Node(10);
        b.root.left = new Node(2);
        b.root.right = new Node(10);
        b.root.left.left = new Node(20);
        b.root.left.right = new Node(1);
        b.root.right.right = new Node(-25);
        b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);
        
        System.out.println(check(a.root, b.root));   
        
        
	}

}
