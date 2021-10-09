package Size_Of_A_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Size_Of_A_Binary_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        // int result = sizeOfABinaryTree_Recursive(treeNode);
        // System.out.println(result);

        int result = sizeOfABinaryTree_Iterative(treeNode);
        System.out.println(result);

    }

    public static int sizeOfABinaryTree_Recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSize = sizeOfABinaryTree_Recursive(root.left);
        int rightSize = sizeOfABinaryTree_Recursive(root.right);
        return leftSize + rightSize + 1;

    }

    public static int sizeOfABinaryTree_Iterative(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            size++;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return size;
    }

}
