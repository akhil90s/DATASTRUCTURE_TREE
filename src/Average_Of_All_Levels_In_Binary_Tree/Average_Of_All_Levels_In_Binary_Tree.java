package Average_Of_All_Levels_In_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_Of_All_Levels_In_Binary_Tree {

    // https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public static void main(String[] args) {

        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(17);
        List<Double> result = averageOfLevels(node);
        System.out.println(result);

    }

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double double_sum = 0;
        while (!queue.isEmpty()) {
            double size = queue.size();
            double_sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                double_sum += treeNode.value;
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            double level_avg = double_sum / size;
            result.add(level_avg);
        }
        return result;

    }

}
