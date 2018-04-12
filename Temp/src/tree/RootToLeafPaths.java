package tree;

public class RootToLeafPaths {

	Node root;
	int a[]= new int[1000];

	
	public void Paths(Node root, int Len) 
	{
		if(root==null)
			return;
		
		a[Len++]=root.data;

		if (root.right==null && root.left==null) {
			for (int i = 0; i < Len; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
		
		if (root.left!=null)
		{
			Paths(root.left,Len);
		}
		if (root.right!=null)
		{
			Paths(root.right,Len);
		}
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
		
		RootToLeafPaths b=new RootToLeafPaths();
        
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
//        b.inOrader(b.root);
 
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
