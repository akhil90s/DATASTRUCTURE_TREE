package Number_Of_Full_Nodes_In_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Number_Of_Full_Nodes_In_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(4);
		treeNode.left.right = new TreeNode(5);
		treeNode.right.left = new TreeNode(6);
		treeNode.right.right = new TreeNode(7);
		treeNode.left.left.left = new TreeNode(8);
		//treeNode.left.left.right = new TreeNode(9);
		treeNode.right.right.left = new TreeNode(10);
		//treeNode.right.right.right = new TreeNode(11);

		int result = numberOfFullNodesInBinaryTree(treeNode);
		System.out.println(result);

	}

	public static int numberOfFullNodesInBinaryTree(TreeNode root) {

		int numberOfFullNodesInBinaryTree = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			TreeNode tempNode = queue.poll();
			if (tempNode != null) {
				if (tempNode.left != null && tempNode.right != null) {
					numberOfFullNodesInBinaryTree++;
				}
				if(tempNode.left != null) {queue.offer(tempNode.left);}
				if(tempNode.right != null) {queue.offer(tempNode.right);}
				
			}
		}
		return numberOfFullNodesInBinaryTree;
	}

}
