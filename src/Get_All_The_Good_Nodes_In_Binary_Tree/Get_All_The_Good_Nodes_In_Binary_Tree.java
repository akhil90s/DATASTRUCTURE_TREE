package Get_All_The_Good_Nodes_In_Binary_Tree;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class Get_All_The_Good_Nodes_In_Binary_Tree {

    public static void main(String[] args) {

        // Root Level 0
        TreeNode treeNode = new TreeNode(3);
        // Level 1
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        // Level 2
        treeNode.left.left = new TreeNode(3);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(5);
        // Level 3

        int result = goodNodes(treeNode);
        System.out.println(result);

    }

    public static int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        return goodNodesHelper(root, root.value);
    }

    public static int goodNodesHelper(TreeNode root, int max) {

        if (root == null)
            return 0;

        max = Math.max(max, root.value);

        if (root.value >= max)
            return goodNodesHelper(root.left, max) + goodNodesHelper(root.right, max) + 1;
        else
            return goodNodesHelper(root.left, max) + goodNodesHelper(root.right, max);

    }

}
