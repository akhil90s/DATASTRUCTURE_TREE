package Univalued_Binary_Tree;

public class Univalued_Binary_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(1);

        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(5);
        
        boolean result = isUnivalTree(treeNode);
        System.out.println(result);

    }

    public static boolean isUnivalTree(TreeNode root) {
        
        if(root ==  null)
            return true;
        
         return helperMethod(root, root.val);
        
    }
    
    public static boolean helperMethod(TreeNode root, int val) {

        if (root == null)
            return true;

        if (root.val != val)
            return false;
        

        return helperMethod(root.left, val) && helperMethod(root.right, val);
    }

}
