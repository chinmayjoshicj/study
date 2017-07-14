package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class bottomViewPractice {

Node root;

public void printBottomView(Node root)
{
	if(root==null)
		return;
	Queue<Node> queue= new LinkedList<Node>();
	//.Map<Integer, Node> m=new Map<Integer, Node>(); Not allowed because Map is an Interface
	Map<Integer, Node> map=new TreeMap<Integer, Node>();
	
	int hd=0;
	root.hd=hd;
	queue.add(root);
	
	while (!queue.isEmpty()) 
	{
		Node temp=queue.remove();
		hd=temp.hd;
		map.put(hd, temp);
		
		if (temp.left!=null)
		{
			temp.left.hd=hd-1;
			queue.add(temp.left);
		}
		if (temp.right!=null)
		{
			temp.right.hd=hd+1;
			queue.add(temp.right);
		}		
	}
	Set<Entry<Integer, Node>> set= map.entrySet();
	Iterator<Entry<Integer, Node>> iterator= set.iterator();
	
	while (iterator.hasNext())
	{
		Entry<Integer, Node> me= iterator.next();
		System.out.println(me.getValue().data);
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bottomViewPractice tree = new bottomViewPractice();
	 	tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        
        tree.printBottomView(tree.root);
       
	}

}
