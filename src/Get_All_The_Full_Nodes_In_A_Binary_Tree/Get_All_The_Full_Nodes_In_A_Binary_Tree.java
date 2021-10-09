package Get_All_The_Full_Nodes_In_A_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Get_All_The_Full_Nodes_In_A_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(2);

		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(5);

		treeNode.left.right = new TreeNode(6);
		treeNode.right.right = new TreeNode(9);

		treeNode.left.right.left = new TreeNode(1);
		treeNode.left.right.right = new TreeNode(11);
		treeNode.right.right.left = new TreeNode(4);

		// int result = countFullNodesInABinaryTree_Iterative(treeNode);
		// System.out.println(result);

		int result = countFullNodesInABinaryTree_Recursion(treeNode);
		System.out.println(result);

	}

	// Level Order Traversal
	public static int countFullNodesInABinaryTree_Iterative(TreeNode root) {

		if (root == null)
			return 0;

		int fullNodes = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node.left != null && node.right != null) {
				fullNodes++;
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return fullNodes;
	}

	public static int fullNodes = 0;

	public static int countFullNodesInABinaryTree_Recursion(TreeNode root) {

		if (root == null)
			return 0;

		/*
		 * countFullNodesInABinaryTree_Recursion(root.left);
		 * countFullNodesInABinaryTree_Iterative(root.right);
		 */

		if (root.left != null && root.right != null) {
			return (countFullNodesInABinaryTree_Recursion(root.left) + countFullNodesInABinaryTree_Iterative(root.right)
					+ 1);

		} else {
			return (countFullNodesInABinaryTree_Recursion(root.left)
					+ countFullNodesInABinaryTree_Iterative(root.right));

		}

	}
}
