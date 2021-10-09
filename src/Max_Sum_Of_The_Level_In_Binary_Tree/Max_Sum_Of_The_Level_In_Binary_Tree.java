package Max_Sum_Of_The_Level_In_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;


// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
public class Max_Sum_Of_The_Level_In_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		
		int result = maxSumOfTheLevelInBinaryTree(treeNode);
		System.out.println(result);

	}

	public static int maxSumOfTheLevelInBinaryTree(TreeNode root) {

		int maxLevelSum = Integer.MIN_VALUE;
		int levelSum = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			if (tempNode != null) {
				levelSum += tempNode.value;
				if(tempNode.left != null) {
					queue.offer(tempNode.left);
				}
				if(tempNode.right != null) {
					queue.offer(tempNode.right);
				}
				if(levelSum>maxLevelSum) {
					maxLevelSum = levelSum;
				}
				
			} else {
				if (!queue.isEmpty()) {
					queue.offer(null);
					levelSum = 0;
				}
			}
		}
		return maxLevelSum;

	}

}
