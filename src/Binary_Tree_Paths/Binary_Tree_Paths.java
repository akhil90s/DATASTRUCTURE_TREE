package Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/binary-tree-paths/
public class Binary_Tree_Paths {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(treeNode);
        System.out.println(result);

    }

    public static List<String> binaryTreePaths(TreeNode root) {

        if (root == null)
            return null;

        List<String> result = new ArrayList<>();

        String current_path = Integer.toString(root.val);

        if (root.left == null && root.right == null)
            result.add(current_path);

        if (root.left != null)
            helperDFS(root.left, current_path, result);

        if (root.right != null)
            helperDFS(root.right, current_path, result);

        return result;
    }

    public static void helperDFS(TreeNode node, String current_path, List<String> result) {
        current_path += " -> " + node.val;

        if (node.left == null && node.right == null) {
            result.add(current_path);
            return;
        }

        if (node.left != null)
            helperDFS(node.left, current_path, result);
       
        if (node.right != null)
            helperDFS(node.right, current_path, result);

    }

}
