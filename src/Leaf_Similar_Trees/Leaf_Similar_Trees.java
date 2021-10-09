package Leaf_Similar_Trees;

import java.util.ArrayList;
import java.util.List;

public class Leaf_Similar_Trees {

	// https://leetcode.com/problems/leaf-similar-trees/
	public static void main(String[] args) {

		TreeNode treeNode1 = new TreeNode(10);
		treeNode1.left = new TreeNode(5);
		treeNode1.right = new TreeNode(10);
		
		TreeNode treeNode2 = new TreeNode(10);
		treeNode2.left = new TreeNode(5);
		treeNode2.right = new TreeNode(10);


		boolean result = leafSimilar(treeNode1, treeNode2);
		System.out.println(result);

	}

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		helperLeafSimilar(root1, list1);
		helperLeafSimilar(root2, list2);

		if (list1.size() != list2.size())
			return false;

		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i)) {
				return false;
			}
		}
		return true;
	}

	
	public static List<Integer> helperLeafSimilar(TreeNode root, List<Integer> list) {
		
		if(root == null) return list;
		
		if(root.left == null & root.right == null) {
			list.add(root.value);
		}
		helperLeafSimilar(root.left,list);
		helperLeafSimilar(root.right, list);
		
		return list;
	}

}
