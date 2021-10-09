package Maximum_Element_In_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


public class Maximum_Element_In_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);

		// int result = maxInABinaryTree_Recursive(treeNode);
		// System.out.println(result);
		
		int result = maxInABinaryTree_Iterative(treeNode);
		System.out.println(result);	

	}

	public static int maxInABinaryTree_Recursive(TreeNode root) {
		int maxValue = Integer.MIN_VALUE;
		if (root != null) {
			int leftMax = maxInABinaryTree_Recursive(root.left);
			int rightMax = maxInABinaryTree_Recursive(root.right);

			if (leftMax > rightMax) {
				maxValue = leftMax;
			} else {
				maxValue = rightMax;
			}
			if (root.value > maxValue) {
				maxValue = root.value;
			}
		}
		return maxValue;
	}

	public static int maxInABinaryTree_Iterative(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int maxValue = Integer.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.value > maxValue) {
				maxValue = temp.value;
			}
			if (temp != null) {
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
		}
		return maxValue;
	}

}
