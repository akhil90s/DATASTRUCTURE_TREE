package Search_Element_In_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Search_Element_In_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		// boolean result = findInBinaryTree_Recursive(treeNode, 5);
		// System.out.println(result);
		
		boolean result = findInBinaryTree_Iterative(treeNode, 5);
		System.out.println(result);

	}

	public static boolean findInBinaryTree_Recursive(TreeNode root, int data) {

		if (root == null) {
			return false;
		}
		if (root.value == data) {
			return true;
		}
		return findInBinaryTree_Recursive(root.left, data) || findInBinaryTree_Recursive(root.right, data);
	}

	public static boolean findInBinaryTree_Iterative(TreeNode root, int data) {
		
		if(root == null)
			return false;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.value == data) {
				return true;
			}
			if (temp != null) {
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
		}
		return false;
	}

}
