package Test;


public class t {

    
//    10
//   /  \
//  6    9
// / \
//2   30

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(9);

        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(30);
        
        makeBST(treeNode);
        inOrderTraversal(treeNode);
    }

    static TreeNode previous;
    static TreeNode first;
    static TreeNode n;

    public static void makeBST(TreeNode node) {
        inOrder(node);
        int value = n.val;
        n.val = first.val;
        first.val = value;
    }

    public static void inOrder(TreeNode root) {

        if (root == null)
            return;

        inOrder(root.left);
        if (previous == null) {
            previous = root;
        } else {
            if (root.val < previous.val) {
                if (first == null) {
                    first = previous;
                }
                n = first;
            }
            previous = root;
        }
        inOrder(root.right);

    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);

    }
}
