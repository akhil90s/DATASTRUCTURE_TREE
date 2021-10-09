package Search_In_A_Binary_Search_Tree;

public class Search_In_A_Binary_Search_Tree {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);

        node.left = new TreeNode(2);
        node.right = new TreeNode(7);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(9);

        node.right.right.left = new TreeNode(8);
        node.right.right.right = new TreeNode(11);

        TreeNode result_recursive = searchBST_Recursive(node, 5);
        System.out.println(result_recursive.val);

        TreeNode result_iterative = searchBST_Iterative(node, 5);
        System.out.println(result_iterative.val);

    }

    public static TreeNode searchBST_Recursive(TreeNode root, int val) {

        if (root == null)
            return null;
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            root = searchBST_Recursive(root.left, val);
        } else {
            root = searchBST_Recursive(root.right, val);
        }

        return root;
    }
    
    public static TreeNode searchBST_Iterative(TreeNode root, int val) {

        while (root != null) {
            if (root.val == val)
                return root;
            else if (root.val > val)
                root = root.left;
            else
                root = root.right;
        }

        return null;
    }
    
}
