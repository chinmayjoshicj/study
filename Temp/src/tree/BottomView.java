package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BottomView {
	
	Node root;
	
	public void checkBottomView()
	{
		if (root==null)
		{
			return;
		}
		int hd=0;//Initialise hd to 0 for root node
		Map<Integer, Integer> map=new TreeMap<Integer, Integer>();
		Queue<Node> queue=new LinkedList<Node>();
		
		root.hd=hd;
		queue.add(root);
		
		while (!queue.isEmpty())
		{
			Node temp=queue.remove();
			hd=temp.hd;
			map.put(hd, temp.data);
			
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
		Set<Entry<Integer, Integer>>set=map.entrySet();
		
		Iterator<Entry<Integer,Integer>> iterator= set.iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<Integer,Integer> me=iterator.next();
			System.out.println(me.getValue()+" ");
		}	
	}
	public static void main(String[] args) {
			BottomView tree = new BottomView();
		 	tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(5);
	        tree.root.left.right = new Node(3);
	        tree.root.right.left = new Node(4);
	        tree.root.right.right = new Node(25);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	       
	        System.out.println("Bottom view of the given binary tree:");
	        tree.checkBottomView();
	}
}
