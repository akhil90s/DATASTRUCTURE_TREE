package Maximum_Product_Of_Splitted_Binary_Tree;

public class Maximum_Product_Of_Splitted_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		
		int result_maxProduct = maxProduct(node);
		System.out.println(result_maxProduct);

	}

	private static long totalSum = 0;

	private static long maxProduct = 0;

	public static int maxProduct(TreeNode root) {

		if (root == null)
			return 0;
		totalSum(root);
		maxProductHelper(root);

		return (int) maxProduct;
	}

	public static long maxProductHelper(TreeNode root) {

		if (root == null)
			return 0;

		long left = maxProductHelper(root.left);
		long right = maxProductHelper(root.right);
		long subTreeSum = root.val + left + right;
		maxProduct = Math.max(maxProduct, subTreeSum * (totalSum - subTreeSum));

		return subTreeSum;
	}

	public static void totalSum(TreeNode root) {

		if (root == null)
			return;

		totalSum(root.left);
		totalSum += root.val;
		totalSum(root.right);

	}

}
