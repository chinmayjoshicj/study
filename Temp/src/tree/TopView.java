package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TopView {
	

Node root;


	private void printTopView(Node root) 
	{
 		int hd=0;
		root.hd=hd;
		
		Queue<Node> queue = new LinkedList<Node>();
		Map<Integer, Node> map= new TreeMap<Integer, Node>();
		root.hd=hd;
		queue.add(root);
		
		while (!queue.isEmpty())
		{
			Node temp=queue.remove();
			hd=temp.hd;
			if(map.get(temp.hd)==null){
				map.put(temp.hd, temp);
			}			
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
		Set<Entry<Integer, Node>>set=map.entrySet();
		
		Iterator<Entry<Integer, Node>> iterator= set.iterator();
		
		while (iterator.hasNext())
		{
			Entry<Integer, Node> me=iterator.next();
			System.out.println(me.getValue().data+" aa");
		}	
		
	}

	public static void main(String[] args) {
		TopView tree = new TopView();
	 	tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right= new Node(6);
        /*tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);*/
        /*tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);*/
        
        tree.printTopView(tree.root);
	}
	

}
