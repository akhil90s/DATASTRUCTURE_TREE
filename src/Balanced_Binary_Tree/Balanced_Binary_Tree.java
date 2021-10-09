package Balanced_Binary_Tree;

// https://leetcode.com/problems/balanced-binary-tree/
public class Balanced_Binary_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        // treeNode.right.left = new TreeNode(6);
        // treeNode.right.right = new TreeNode(7);

        treeNode.left.left.left = new TreeNode(8);
        treeNode.left.left.right = new TreeNode(9);

        int result = isBalanced(treeNode);
        System.out.println("Height Of The Tree : " + result + " Is the tree balanced : " + isBalanced);

    }

    static boolean isBalanced = true;

    public static int isBalanced(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = isBalanced(root.left);
        int rh = isBalanced(root.right);

        int gap = Math.abs(rh - lh);

        if (gap > 1)
            isBalanced = false;

        int height = Math.max(lh, rh) + 1;

        return height;
    }

}
