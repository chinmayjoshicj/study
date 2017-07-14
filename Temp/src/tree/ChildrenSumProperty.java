package tree;

public class ChildrenSumProperty {

	Node root;

	private int sumProp(Node root) {
		if (root == null) {
			return 1;
		} else {

			if ((root.left != null && root.right != null) && !(root.data == (root.left.data + root.right.data))) {
				return 0;
			}
			sumProp(root.left);
			sumProp(root.right);

			return 1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildrenSumProperty b = new ChildrenSumProperty();

		b.root = new Node(10);
		b.root.left = new Node(8);
		b.root.right = new Node(2);
		b.root.left.left = new Node(3);
		b.root.left.right = new Node(5);
		b.root.right.left= new Node(2);

		if (b.sumProp(b.root) == 1) {
			System.out.println("Satisfied");
		} else {
			System.out.println("Not Satisfied");
		}
	}

}
