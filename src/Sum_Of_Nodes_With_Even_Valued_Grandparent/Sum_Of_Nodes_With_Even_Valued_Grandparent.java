package Sum_Of_Nodes_With_Even_Valued_Grandparent;

public class Sum_Of_Nodes_With_Even_Valued_Grandparent {
	
	

	// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
	public static void main(String[] args) {

		// Root Level 0
		TreeNode treeNode = new TreeNode(6);
		// Level 1
		treeNode.left = new TreeNode(7);
		treeNode.right = new TreeNode(8);
		// Level 2
		treeNode.left.left = new TreeNode(2);
		treeNode.left.right = new TreeNode(7);
		treeNode.right.left = new TreeNode(1);
		treeNode.right.right = new TreeNode(3);
		// Level 3
		treeNode.left.left.left = new TreeNode(8);
		treeNode.left.right.left = new TreeNode(1);
		treeNode.left.right.right = new TreeNode(4);
		// treeNode.right.right.left = new TreeNode(5);
		treeNode.right.right.right = new TreeNode(5);

		int result = sumOfNodesWithEvenValuedGrandparent(treeNode);
		System.out.println(result);
	}

	public static int sum = 0;

	public static int sumOfNodesWithEvenValuedGrandparent(TreeNode root) {

		if (root == null)
			return 0;
		sumOfNodesWithEvenValuedGrandparentHelper(root, null, null);
		return sum;
	}

	public static void sumOfNodesWithEvenValuedGrandparentHelper(TreeNode root, TreeNode parent, TreeNode grandparent) {

		if (root == null)
			return;

		if (grandparent != null && grandparent.value % 2 == 0)
			sum += root.value;

		if (root.left != null)
			sumOfNodesWithEvenValuedGrandparentHelper(root.left, root, parent);

		if (root.right != null)
			sumOfNodesWithEvenValuedGrandparentHelper(root.right, root, parent);

	}

}
