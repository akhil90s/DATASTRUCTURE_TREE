package Diagonal_Sum_Of_A_Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diagonal_Sum_Of_A_Binary_Tree {

	public static void main(String[] args) {

		// Diagonals are left to right
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		
		List<Integer> result_diagonalSum = diagonalSum(root);
		System.out.println(result_diagonalSum);

	}

	public static List<Integer> diagonalSum(TreeNode root) {

		Map<Integer, Integer> map = new HashMap<>();

		if (root == null)
			return null;

		helperMethod(root, map, 0);

		return new ArrayList<Integer>(map.values());
	}

	private static void helperMethod(TreeNode root, Map<Integer, Integer> map, int diagonal) {

		if (root == null)
			return;
		
		map.put(diagonal, map.getOrDefault(diagonal, 0) + root.val);
		
		helperMethod(root.left, map, diagonal + 1);
		helperMethod(root.right, map, diagonal);
		

	}

}
