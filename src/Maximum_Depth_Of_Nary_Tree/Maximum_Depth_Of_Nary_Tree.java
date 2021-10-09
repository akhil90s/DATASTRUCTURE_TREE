package Maximum_Depth_Of_Nary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_Of_Nary_Tree {

	public static void main(String[] args) {

	}

	// Level Order Traversal
	public int maxDepth_BreadthFirstSearch(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int depth = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				for (TreeNode child : current.children)
					queue.offer(child);
			}
			depth++;
		}
		return depth;
	}

	// Recursion
	public int maxDepth_DepthFirstSearch(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int max = Integer.MIN_VALUE;

		for (TreeNode child : root.children) {
			max = Math.max(max, maxDepth_DepthFirstSearch(child));
		}

		return 1 + Math.max(max, 0);
	}

}
