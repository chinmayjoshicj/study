package tree;

public class MaxDepthOftree {

	Node root;
	
	public static int check(Node root) 
	{
		int lDepth=0;
		int rDepth=0;
		
		if (root==null)
		{
			return 0;
		}
		
		if(root.left==null && root.right==null)
			return 1;
		
		if (root.left!=null) {
			lDepth=check(root.left)+1;	
		}
		
		if (root.right!=null) {
			rDepth=check(root.right)+1;
		}
		return Math.max(lDepth, rDepth);		
	}
	public static void main(String[] args) {
		// TODO Auto-generat                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ed method stub
		MaxDepthOftree b=new MaxDepthOftree();
		
        b.root = new Node(10);
        b.root.left = new Node(2);
        b.root.right = new Node(10);
        b.root.left.left = new Node(20);
        b.root.left.right = new Node(1);
        b.root.right.right = new Node(-25);
        b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);
        
        System.out.println(check(b.root));   
        
        
	}

}
