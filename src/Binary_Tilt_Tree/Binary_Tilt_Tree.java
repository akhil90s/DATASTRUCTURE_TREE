package Binary_Tilt_Tree;

// https://leetcode.com/problems/binary-tree-tilt/
public class Binary_Tilt_Tree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(9);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(7);
        int result = findTilt(node);
        System.out.println(result);

    }

    public static int result = 0;

    public static int findTilt(TreeNode root) {
        tilt(root);
        return result;
    }

    public static int tilt(TreeNode node) {
        if (node == null)
            return 0;

        int left = tilt(node.left);
        int right = tilt(node.right);
        result += Math.abs(left - right);
        return left + right + node.value;
    }

}
