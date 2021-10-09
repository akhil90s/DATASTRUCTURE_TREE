package Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Right_Side_View {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		List<Integer> result_rightSideView = rightSideView(node);
		System.out.println(result_rightSideView);

	}

	public static List<Integer> rightSideView(TreeNode node) {

		List<Integer> list = new ArrayList<>();

		if (node == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);

		while (!queue.isEmpty()) {

			int n = queue.size();

			for (int i = 0; i < n; i++) {

				TreeNode current_node = queue.poll();
				if (i == 0)
					list.add(current_node.value);

				if (current_node.right != null)
					queue.offer(current_node.right);
				if (current_node.left != null)
					queue.offer(current_node.left);
			}

		}

		return list;
	}

}
