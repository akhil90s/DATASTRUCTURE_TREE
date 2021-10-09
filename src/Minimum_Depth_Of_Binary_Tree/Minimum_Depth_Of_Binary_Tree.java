package Minimum_Depth_Of_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Minimum_Depth_Of_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		// treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		treeNode.right.right.right = new TreeNode(9);
	
		//int result = minimumDepthOfBinaryTree_Recursive(treeNode);
		//System.out.println(result);

		int result = minimumDepthOfBinaryTree_Iterative(treeNode);
		System.out.println(result);

	}

	public static int minimumDepthOfBinaryTree_Recursive(TreeNode root) {
		
		if (root == null)
			return 0;

		if (root.left == null && root.right == null) {
			return 1;
		}
		
		int left = minimumDepthOfBinaryTree_Recursive(root.left);
		int right = minimumDepthOfBinaryTree_Recursive(root.right);
		
		if(left==0 || right ==0)
			return Math.max(left, right) + 1;

		return (Math.min(left, right) + 1);

	}

	public static int minimumDepthOfBinaryTree_Iterative(TreeNode root) {

		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		int height = 1;
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			if (tempNode != null) {
				if (tempNode.left == null && tempNode.right == null) {
					return height;
				}
				if (tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if (tempNode.right != null) {
					queue.offer(tempNode.right);
				}
			} else {
				if (!queue.isEmpty()) {
					height++;
					queue.offer(null);
				}
			}
		}
		return height;
	}

}
