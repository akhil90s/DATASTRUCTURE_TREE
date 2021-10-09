package Construct_Binary_Tree_From_Postorder_And_Inorder_Traversal;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		super();
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
