package Construct_Binary_Tree_From_Postorder_And_Inorder_Traversal;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_From_Postorder_And_Inorder_Traversal {

	public static void main(String[] args) {

		int[] postorder = new int[] { 3, 9, 20, 15, 7 };
		int[] inorder = new int[] { 9, 3, 15, 20, 7 };

		TreeNode result_buildTree = buildTree(postorder, inorder);
		System.out.println(result_buildTree);
		inOrderTraversal(result_buildTree);

	}

	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static int index = 0;

	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		for (int i : inorder) {
			map.put(inorder[i], i);
		}
		index = postorder.length - 1;
		TreeNode result = helperMethod(inorder, postorder, 0, inorder.length - 1);
		return result;
	}

	private static TreeNode helperMethod(int[] inorder, int[] postorder, int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		TreeNode root = new TreeNode(postorder[index--]);
		int indexValue = map.get(root.val);
		root.right = helperMethod(inorder, postorder, indexValue + 1, end);
		root.left = helperMethod(inorder, postorder, start, indexValue - 1);
		
		return root;
	}

	private static void inOrderTraversal(TreeNode root) {

		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.val + " -> ");
		inOrderTraversal(root.right);

	}

}
