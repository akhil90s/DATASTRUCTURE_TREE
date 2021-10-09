package Sum_Of_Left_Leaves;

import java.util.LinkedList;
import java.util.Queue;

public class Sum_of_Left_Leaves {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3);

        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);

        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        
        int result = sumOfLeftLeaves(treeNode);
        System.out.println(result);
        
    }

    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftLeaveSum = 0;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            
            if (node.left != null)
                if (node.left.left == null && node.left.right == null)
                    leftLeaveSum += node.left.val;

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);

        }

        return leftLeaveSum;

    }

}
