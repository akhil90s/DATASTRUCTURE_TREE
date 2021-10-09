package BST_Search_In_A_Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST_Search_In_A_Binary_Search_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(12);
        treeNode.right.right = new TreeNode(17);

        // inOrderTraversal(treeNode);
        TreeNode result_Recursive = searchInABinaryTree_Recursive_BST(treeNode, 5);
        System.out.println(result_Recursive.val);
        
        TreeNode result_Iterative = searchInABinaryTree_Iterative_BST(treeNode, 5);
        System.out.println(result_Iterative.val);

    }

    public static TreeNode searchInABinaryTree_Recursive_BST(TreeNode root, int data) {

        if (root == null || root.val == data)
            return root;

        if (root.val > data) {
            return searchInABinaryTree_Recursive_BST(root.left, data);
        } else {
            return searchInABinaryTree_Recursive_BST(root.right, data);
        }

    }

    public static TreeNode searchInABinaryTree_Iterative_BST(TreeNode root, int data) {

        if (root == null || root.val == data)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == data)
                return node;
            if (node.val > data)
                queue.offer(node.left);
            if (node.val < data)
                queue.offer(node.right);
        }

        return null;

    }

    public static void inOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

}
