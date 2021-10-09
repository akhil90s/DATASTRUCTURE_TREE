package BST_Insert_In_A_Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST_Insert_In_A_Binary_Search_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        inOrderTraversal(treeNode);
        // insertInABinaryTree_Recursive_BST(treeNode, 9);
        insertInABinaryTree_Iterative(treeNode, 9);
        System.out.println();
        inOrderTraversal(treeNode);

    }

    public static void insertInABinaryTree_Recursive_BST(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode();
        } else {
            insertHelper(root, data);
        }
    }

    private static void insertHelper(TreeNode root, int data) {
        // This check is not necessary it is used in case of Binary Search Tree
        if (root.value >= data) {
            if (root.left == null)
                root.left = new TreeNode(data);
            else
                insertHelper(root.left, data);
        } else {
            if (root.right == null)
                root.right = new TreeNode(data);
            else
                insertHelper(root.right, data);
        }
    }

    // Since this is not a Binary Search Tree we can insert
    // wherever we find the node whose left or right child is null
    public static TreeNode insertInABinaryTree_Iterative(TreeNode root, int data) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode != null) {

                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                } else {
                    tempNode.left = new TreeNode(data);
                    return root;
                }

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                } else {
                    tempNode.right = new TreeNode(data);
                    return root;
                }

            }
        }
        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

}
