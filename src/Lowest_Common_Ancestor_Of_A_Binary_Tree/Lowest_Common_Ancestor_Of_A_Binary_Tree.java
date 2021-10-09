package Lowest_Common_Ancestor_Of_A_Binary_Tree;

public class Lowest_Common_Ancestor_Of_A_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(3); 
	
		node.left = new TreeNode(5); 
		node.right = new TreeNode(1);

		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);
		
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		

		
		TreeNode result_lowestCommonAncestor = lowestCommonAncestor(node, node.left.left, node.left.right.right);
		System.out.println(result_lowestCommonAncestor.value);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null)
			return null;
		
		if(root.value == p.value || root.value == q.value) 
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null) {
			return root;
		}else if (left != null) {
			return left;
		} else {
			return right;
		}
		
	}

}
