package Path_Sum;

import java.util.Stack;

public class Path_Sum {

    
    // https://leetcode.com/problems/path-sum/
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);

        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);

        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);

        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.right = new TreeNode(1);

        // boolean result = hasPathSum_Recursive_1(treeNode,0, 22);
        // boolean result = hasPathSum_Recursive_2(treeNode, 22);
        boolean result = hasPathSum_Iterative(treeNode, 26);
        System.out.println(result);
    }

    // Adding to the current sum
    public static boolean hasPathSum_Recursive_1(TreeNode root, int currentSum, int targetSum) {

        if (root == null)
            return false;

        currentSum = currentSum + root.val;

        if (root.left == null && root.right == null)
            if (currentSum == targetSum)
                return true;

        return hasPathSum_Recursive_1(root.left, currentSum, targetSum)
                || hasPathSum_Recursive_1(root.right, currentSum, targetSum);

    }

    // Subtracting from the target sum
    public static boolean hasPathSum_Recursive_2(TreeNode root, int targetSum) {

        if (root == null && targetSum != 0)
            return false;

        if (root == null && targetSum == 0)
            return true;

        return hasPathSum_Recursive_2(root.left, targetSum - root.val)
                || hasPathSum_Recursive_2(root.right, targetSum - root.val);
    }

    
    // Iterative
    public static boolean hasPathSum_Iterative(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        Stack<TreeNode> stack_node = new Stack<>();
        stack_node.push(root);

        Stack<Integer> stack_sum = new Stack<>();
        stack_sum.push(targetSum - root.val);

        while (!stack_node.isEmpty()) {

            TreeNode node = stack_node.pop();
            int current_sum = stack_sum.pop();

            if (node.left == null && node.right == null && current_sum == 0)
                return true;

            if (node.left != null) {
                stack_node.push(node.left);
                stack_sum.push(current_sum - node.left.val);
            }
            
            if (node.right != null) {
                stack_node.add(node.right);
                stack_sum.push(current_sum - node.right.val);
            }
        }
        return false;
    }

}
