package Vertical_Order_Traversal_Of_A_Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Vertical_Order_Traversal_Of_A_Binary_Tree_1 {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		List<List<Integer>> result_verticalOrderTraversal = verticalOrderTraversal(node);
		System.out.println(result_verticalOrderTraversal);

	}

	public static List<List<Integer>> verticalOrderTraversal(TreeNode node) {

		List<List<Integer>> result = new ArrayList<>();
		if (node == null)
			return result;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(node, 0));

		Map<Integer, List<Integer>> map = new HashMap<>();
		int minhl = Integer.MAX_VALUE, maxhl = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				Pair pair = queue.remove();

				maxhl = Math.max(maxhl, pair.hl);
				minhl = Math.min(minhl, pair.hl);
					
				map.putIfAbsent(pair.hl, new ArrayList<Integer>());
				map.get(pair.hl).add(pair.node.value);

				if (pair.node.left != null)
					queue.offer(new Pair(pair.node.left, pair.hl - 1));

				if (pair.node.right != null)
					queue.offer(new Pair(pair.node.right, pair.hl + 1));
			}
		}
		for (int i = minhl; i <= maxhl; i++) {
			result.add(map.get(i));
		}
		return result;
	}

}






