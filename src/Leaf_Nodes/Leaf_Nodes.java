package Leaf_Nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leaf_Nodes {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        // List<TreeNode> result = getAllLeafNodes(treeNode);
        List<TreeNode> result = getAllLeafNodes_Iterative(treeNode);
        print(result);

    }

    static List<TreeNode> result = new ArrayList<>();

    public static List<TreeNode> getAllLeafNodes(TreeNode root) {

        if (root == null)
            return null;

        if (root.left == null & root.right == null)
            result.add(root);

        getAllLeafNodes(root.left);
        getAllLeafNodes(root.right);

        return result;
    }

    public static List<TreeNode> getAllLeafNodes_Iterative(TreeNode root) {

        if (root == null)
            return null;

        List<TreeNode> list = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            if (node.left == null && node.right == null)
                list.add(node);

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }
        return list;
    }

    public static void print(List<TreeNode> result) {

        for (TreeNode node : result) {
            System.out.print(node.value + " ");
        }

    }

}
