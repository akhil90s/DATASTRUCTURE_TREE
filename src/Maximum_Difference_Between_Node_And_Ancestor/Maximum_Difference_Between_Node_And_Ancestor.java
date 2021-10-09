package Maximum_Difference_Between_Node_And_Ancestor;

class Res {
	int r = Integer.MIN_VALUE;
}

public class Maximum_Difference_Between_Node_And_Ancestor {

	public static void main(String[] args) {

		// Root Level 0
		TreeNode treeNode = new TreeNode(8);
		// Level 1
		treeNode.left = new TreeNode(3);
		treeNode.right = new TreeNode(10);
		// Level 2 
		treeNode.left.left = new TreeNode(1);
		treeNode.left.right = new TreeNode(6);
		treeNode.right.right = new TreeNode(14);
		// Level 3
		treeNode.left.right.left = new TreeNode(4);
		treeNode.left.right.right = new TreeNode(7);
		treeNode.right.right.left = new TreeNode(13);

		int result = maximumDifferenceBetweenNodeAndAncestor(treeNode);
		System.out.println(result);

	}

	static int maximumDifference = Integer.MIN_VALUE;
	static int value = 0;

	public static int maximumDifferenceBetweenNodeAndAncestor(TreeNode root) {

		return maximumDifference;

	}

}

