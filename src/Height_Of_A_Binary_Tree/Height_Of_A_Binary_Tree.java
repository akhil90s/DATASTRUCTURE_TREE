package Height_Of_A_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Height_Of_A_Binary_Tree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(9);
        treeNode.right.right.right.right = new TreeNode(9);

        int result_Recursive = heightOfABinaryTree_Recursive(treeNode);
        System.out.println(result_Recursive);

        int result_Iterative = heightOfABinaryTree_Iterative_Approach(treeNode);
        System.out.println(result_Iterative);

    }

    public static int heightOfABinaryTree_Recursive(TreeNode root) {

        if (root == null)
            return 0;

        int left = heightOfABinaryTree_Recursive(root.left);
        int right = heightOfABinaryTree_Recursive(root.right);

        // return left > right ? left + 1 : right + 1;

        int height = Math.max(left, right) + 1;
        
        return height;
    }

    public static int heightOfABinaryTree_Iterative_Approach(TreeNode root) {

        if (root == null)
            return 0;
        int height = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int queueSize = queue.size();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = null;
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                temp = queue.poll();
                if (temp != null) {
                    if (temp.left != null)
                        queue.offer(temp.left);
                    if (temp.right != null)
                        queue.offer(temp.right);
                }
            }
            height++;
        }
        return height;

    }

}
