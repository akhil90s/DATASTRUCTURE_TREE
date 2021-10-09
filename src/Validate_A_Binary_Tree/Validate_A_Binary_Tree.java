package Validate_A_Binary_Tree;

public class Validate_A_Binary_Tree {

	public static void main(String[] args) {
		
		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(5);
		treeNode.right = new TreeNode(15);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(7);
		treeNode.right.right = new TreeNode(18);
		validateBinarySearchTree(treeNode);
		
	}

	public static boolean validateBinarySearchTree(TreeNode node) {

		return true;
	}

}