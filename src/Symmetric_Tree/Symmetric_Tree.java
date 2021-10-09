package Symmetric_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(3);

        boolean result = isSymmetric_Approach_1(treeNode);
        System.out.println(result);
    }

    public static boolean isSymmetric_Approach_1(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        return ((node1.val == node2.val) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));

    }

}
