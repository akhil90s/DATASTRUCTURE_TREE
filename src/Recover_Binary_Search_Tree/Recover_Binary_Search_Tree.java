package Recover_Binary_Search_Tree;

public class Recover_Binary_Search_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(10);

		node.left = new TreeNode(5);
		node.right = new TreeNode(8);

		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(20);

		inOrderTraversal(node);
		recoverTree(node);
		System.out.println();
		inOrderTraversal(node);

	}

	private static TreeNode firstNode = null;
	private static TreeNode secondNode = null;
	private static TreeNode prev = null;

	public static void recoverTree(TreeNode root) {

		if (root == null) {
			return;
		}
		helperMethod(root);

		int temp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = temp;
	}

	public static void helperMethod(TreeNode root) {

		if (root == null)
			return;

		helperMethod(root.left);

		if (firstNode == null && prev != null && prev.val > root.val) {
			firstNode = prev;
		}

		if (firstNode != null && prev != null && prev.val > root.val) {
			secondNode = root;
		}
		prev = root;
		helperMethod(root.right);
	}

	public static void inOrderTraversal(TreeNode root) {

		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.val + " ");
		inOrderTraversal(root.right);

	}
	
}
