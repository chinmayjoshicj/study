package tree;
public class Node
{
	int data;
	int hd;
	Node left,right;
	
	public Node(int item)
	{
		data=item;
		hd=Integer.MAX_VALUE;
		left=right=null;
	}
}