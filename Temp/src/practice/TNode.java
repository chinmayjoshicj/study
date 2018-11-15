package practice;

public class TNode {
	protected TNode left;
	protected TNode right;
	protected int data;

	public TNode(int data) {
		this.data = data;
	}

	public static void printInOrder(TNode node) {
		printInOrderLine(node);
		System.out.println();
	}

	private static void printInOrderLine(TNode node) {
		if (node == null)
			return;
		printInOrderLine(node.left);
		System.out.print(node.data + " ");
		printInOrderLine(node.right);
	}

	public static void printTree(TNode node) {
		TreePrinter.print(node);
		System.out.println();
	}

	public static TNode populateData(int... arr) {

		TNode root = new TNode(arr[0]);
		populateData(root, arr, 1);
		return root;
	}

	private static void populateData(TNode root, int[] arr, int index) {

		if (index * 2 <= arr.length) {

			root.left = new TNode(arr[2 * index - 1]);
			populateData(root.left, arr, 2 * index);

			if (index * 2  < arr.length) {
				root.right = new TNode(arr[2 * index ]);
				populateData(root.right, arr, 2 * index + 1);
			}

		}

	}

	public static void main(String[] args) {
		TNode valueOf = populateData(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14,15,16,17,18); 
		printTree(valueOf);
	}

}