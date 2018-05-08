package tree;
class Node1
{
	int data;
	Node1 left;
	Node1 right;
	
	public Node1(int item)
	{
		data=item;
		left=right=null;
	}
}
public class BinaryTreeCreation {
	Node1 root;
	
	public BinaryTreeCreation() {
		this.root = null;
	}
	
	public BinaryTreeCreation(int item) {
		this.root=new Node1(item);
	}
	public void insert(int item, Node1 root)
	{
			if(root==null)
			{
				this.root=new Node1(item);
				return;
			}
			else if(root.data>item)
			{
				if(root.left==null)
				{
					root.left=new Node1(item);
					return;
				}
				else
					insert(item,root.left);
			}
			else
			{
				if(root.right==null)
				{
					root.right=new Node1(item);
					return;
				}
				else
				{
					insert(item,root.right);
				}
			}
	}
public int MaxPathSum(Node1 node){
		
	int sum=0;
		if(node != null){
			return 0;
		}
		else
		{
			sum=0;
			return sum;
		}
	}
	
	public void inOrader(Node1 node){
		
		if(node != null){
			inOrader(node.left);
			System.out.println(node.data);
			inOrader(node.right);
		}
	}
	public static void main(String[] args) 
	{
		BinaryTreeCreation b=new BinaryTreeCreation();
		/*b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);*/
		
		/*b.insert(20,b.root);
		b.insert(10,b.root);
		b.insert(30,b.root);
		b.insert(40,b.root);
		b.insert(50,b.root);*/
		
		b.root = new Node1(10);
        b.root.left = new Node1(2);
        b.root.right = new Node1(10);
        b.root.left.left = new Node1(20);
        b.root.left.right = new Node1(1);
        b.root.right.right = new Node1(-25);
        b.root.right.right.left = new Node1(3);
        b.root.right.right.right = new Node1(4);
        
        b.MaxPathSum(b.root);
		//System.out.println(b.root.left.key);
	/*	System.out.println(b.root.right.key);
		System.out.println(b.root.left.left.key);
		System.out.println(b.root.key);	*/	
	}

}
