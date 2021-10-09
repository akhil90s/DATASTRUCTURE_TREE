package BST_Min_Max_In_A_Binary_Search_Tree;

public class BST_Min_Max_In_A_Binary_Search_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(12);
        treeNode.right.right = new TreeNode(17);

        // TreeNode result_Min = getMinValueNode_Iterative(treeNode);
        TreeNode result_Min = getMinValueNode_Recursive(treeNode);
        System.out.println(result_Min.val);
        // TreeNode result_Max = getMaxValueNode_Iterative(treeNode);
        TreeNode result_Max = getMaxValueNode_Recursive(treeNode);
        System.out.println(result_Max.val);

    }

    public static TreeNode getMinValueNode_Iterative(TreeNode root) {

        if (root == null)
            return null;

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static TreeNode getMaxValueNode_Iterative(TreeNode root) {

        if (root == null)
            return null;

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
    
    public static TreeNode getMinValueNode_Recursive(TreeNode root) {

        if (root.left == null)
            return root;

        return getMinValueNode_Recursive(root.left);
    }
    
    public static TreeNode getMaxValueNode_Recursive(TreeNode root) {
        
        if (root.right == null)
            return root;

        return getMaxValueNode_Recursive(root.right);
        
    }
    

}
