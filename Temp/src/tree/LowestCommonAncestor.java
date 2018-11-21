package tree;

import java.util.LinkedList;

public class LowestCommonAncestor {

	Node root;
	LinkedList<Integer> path1 = new LinkedList<>();
	LinkedList<Integer> path2 = new LinkedList<>();

	public void LCA(Node root, int n1, int n2) {
		findPath(root, n1, path1);
		findPath(root, n2, path2);
		int dist = 0;
		// int com = 0;
		System.out.println(path1);
		System.err.println(path2);

		for (int i = 0; path1.size() > i && path2.size() > i; i++) {
			if (path1.get(i).equals(path2.get(i))) {
				System.out.println("LCA " + path1.get(i));
			}
			for (Integer k : path1) {
				if (k == path1.get(i)) {
					dist++;
				}
			}
			for (Integer k : path2) {
				if (k == path1.get(i)) {
					dist++;
				}
			}
			break;
		}
		System.out.println(dist + 1);
	}

	private boolean findPath(Node root, int n1, LinkedList<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.data);

		if (root.data == n1) {
			return true;
		}

		if (root.left != null && findPath(root.left, n1, path)) {
			return true;
		}
		if (root.right != null && findPath(root.right, n1, path)) {
			return true;
		}
		path.remove(path.size() - 1);

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LowestCommonAncestor b = new LowestCommonAncestor();

		/*
		 * b.root = new Node(10); b.root.left = new Node(2); b.root.right = new
		 * Node(10); b.root.left.left = new Node(20); b.root.left.right = new
		 * Node(1); b.root.right.right = new Node(-25); b.root.right.right.left
		 * = new Node(3); b.root.right.right.right = new Node(4);
		 */

		b.root = new Node(20);
		b.root.left = new Node(8);
		b.root.right = new Node(22);
		b.root.left.left = new Node(4);
		b.root.left.right = new Node(12);
		b.root.left.right.left = new Node(10);
		b.root.left.right.right = new Node(14);

		// b.inOrader(b.root);
		b.LCA(b.root, 10, 14);
	}

}
