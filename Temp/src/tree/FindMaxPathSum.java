package tree;

public class FindMaxPathSum {
	Node root;
	
	public int MaxPathSum(Node node, int max){
		
		int sum=0;
		int rMax=0;
		int lMax=0;
			if(node == null){
				return max;
			}
			else
			{
				sum=max+node.data;
				if(sum>max)
				{
					max=sum;
				}
				lMax=MaxPathSum(node.left, sum);
				rMax=MaxPathSum(node.right, sum);
				if(lMax>rMax)
				{
					return lMax;
				}
				return rMax;
			}
		}
		
		public void inOrader(Node node){
			
			if(node != null){
				inOrader(node.left);
				System.out.println(node.data);
				inOrader(node.right);
			}
		}

	public static void main(String[] args) 
	{
		FindMaxPathSum b=new FindMaxPathSum();
		/*b.root=new Node(1);
		b.root.left=new Node(2);
		b.root.right=new Node(3);
		b.root.left.left=new Node(4);*/
		
		/*b.insert(20,b.root);
		b.insert(10,b.root);
		b.insert(30,b.root);
		b.insert(40,b.root);
		b.insert(50,b.root);*/
		int max=0;
		
		b.root = new Node(10);
        b.root.left = new Node(2);
        b.root.right = new Node(10);
        b.root.left.left = new Node(20);
        b.root.left.right = new Node(1);
        b.root.right.right = new Node(-25);
        b.root.right.right.left = new Node(3);
        b.root.right.right.right = new Node(4);
        
        System.out.println(b.MaxPathSum(b.root, max));
		//System.out.println(b.root.left.key);
	/*	System.out.println(b.root.right.key);
		System.out.println(b.root.left.left.key);
		System.out.println(b.root.key);	*/	
	}

}
