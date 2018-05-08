package tree;
public class Node
{
	public int data;
	int hd;
	public Node left;
	public Node right;
	
	public Node(int item)
	{
		data=item;
		hd=Integer.MAX_VALUE;
		left=right=null;
	}
}