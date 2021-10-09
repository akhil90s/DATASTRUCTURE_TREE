package Diameter_Of_Binary_Tree;

public class Diameter_Of_Binary_Tree {

    TreeNode root;
    static int result = 0;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(treeNode));

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        getDiameter(root);
        return result == 0 ? 0 : result - 1;

    }

    private static int getDiameter(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = getDiameter(root.left);
        int r = getDiameter(root.right);
        result = Math.max(result, (l + r + 1));
        return Math.max(l, r) + 1;

    }

}
