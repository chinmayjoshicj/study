package tree;

public class BinaryTreeToChildSumProperty 
{
	Node root;
	
	private void convert(Node root) 
	{
		int left_data=0;
		int right_data=0;
		if (root==null) 
		{
			return;
		}
		convert(root.right);
		convert(root.left);
		
		if (root.left!=null)
		{
			left_data=root.left.data;
		}
		if (root.right!=null)
		{
			left_data=root.right.data;
		}
		int diff=root.data-(left_data+right_data);
		if (diff<0)
		{
			root.data=root.data+diff;
		}
		else
		{
			
		}
		
	}
	public void inOrader(Node node)
	{
		if(node != null)
		{
			inOrader(node.left);
			System.out.print(node.data+" ");
			inOrader(node.right);
		}
	}
	
	public static void main(String[] args) 
	{
		BinaryTreeToChildSumProperty tree = new BinaryTreeToChildSumProperty();
		
	 	tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(30);
        
        tree.inOrader(tree.root);
        System.out.println();
        tree.convert(tree.root);
        tree.inOrader(tree.root);
        

	}	

}
