package Boundary_Traversal_Of_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal_Of_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		List<Integer> result_boundaryLevelTraversal = boundaryLevelTraversal(node);
		System.out.println(result_boundaryLevelTraversal);

	}

	private static List<Integer> list = new ArrayList<>();

	public static List<Integer> boundaryLevelTraversal(TreeNode root) {

		if (root == null)
			return list;
		list.add(root.value);

		leftBoundaryTraversal(root.left);
		leafNodesTraversal(root);
		rightBoundaryTraversal(root.right);

		return list;
	}

	public static void leftBoundaryTraversal(TreeNode root) {

		if (root == null)
			return;
		if (root.left != null && root.right != null) {
			if (root.left != null) {
				list.add(root.value);
				leftBoundaryTraversal(root.left);
			} else {
				list.add(root.value);
				leftBoundaryTraversal(root.right);
			}
		}
	}

	public static void leafNodesTraversal(TreeNode root) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			list.add(root.value);
		}
		leafNodesTraversal(root.left);
		leafNodesTraversal(root.right);

	}

	public static void rightBoundaryTraversal(TreeNode root) {

		if (root == null)
			return;
		if (root.left != null && root.right != null) {
			if (root.right != null) {
				rightBoundaryTraversal(root.right);
				list.add(root.value);
			} else {
				rightBoundaryTraversal(root.left);
				list.add(root.value);
			}
		}

	}

}
