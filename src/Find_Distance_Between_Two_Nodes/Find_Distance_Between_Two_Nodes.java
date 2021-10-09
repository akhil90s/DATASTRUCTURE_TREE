package Find_Distance_Between_Two_Nodes;

public class Find_Distance_Between_Two_Nodes {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

		int result_findDistanceBetweenTwoNodes = findDistanceBetweenTwoNodes(root, 6, 7);
		System.out.println(result_findDistanceBetweenTwoNodes);

	}

	public static int findDistanceBetweenTwoNodes(TreeNode root, int node1, int node2) {

		if (root == null)
			return 0;
		// Find LCA
		TreeNode lca = lowestCommonAncestor(root, node1, node2);

		// Find Distance Between LCA and node1
		int a = findDistance(lca, node1);

		// Find Distance Between LCA and node1
		int b = findDistance(lca, node2);

		return a + b - 2;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {

		if (root == null)
			return null;

		if (root.val == p || root.val == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else {
			return right;
		}
	}

	public static int findDistance(TreeNode root, int nodeValue) {

		if (root == null) {
			return 0;
		}
		if (root.val == nodeValue) {
			return 1;
		}
		int a = findDistance(root.left, nodeValue);
		int b = findDistance(root.right, nodeValue);

		if (a == 0 && b == 0) {
			return 0;
		} else {
			return a + b + 1;
		}
	}

}
