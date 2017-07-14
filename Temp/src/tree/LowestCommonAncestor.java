package tree;

public class LowestCommonAncestor {

	Node root;
	int a[]= new int[1000];
	int b[]= new int[1000];
	/*int pathLen=0;
	int pathLen2=0;*/
	public Node LCA(Node node, int n1, int n2) 
	{
		if(root==null)
			return root;
		
			if (node.data>n1 && node.data>n2) {
				return LCA(node.left,n1,n2);
			}
			if (node.data<n1 && node.data<n2) {
				return LCA(node.right,n1,n2);
			}
			return node;
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
		
		LowestCommonAncestor b=new LowestCommonAncestor();
        
       /* b.root = new Node(10);
        b.root.left = new Node(2);
        b.root.right = new Node(10);
        b.root.left.left = new Node(20);
        b.root.left.right = new Node(1);
        b.root.right.right = new Node(-25);
        b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);*/
		
		b.root = new Node(20);
        b.root.left = new Node(8);
        b.root.right = new Node(22);
        b.root.left.left = new Node(4);
        b.root.left.right = new Node(12);
        b.root.left.right.left = new Node(10);
        b.root.left.right.right = new Node(14);
        
//        b.inOrader(b.root);
        System.out.println(b.LCA(b.root,10,14).data);
	}

}
