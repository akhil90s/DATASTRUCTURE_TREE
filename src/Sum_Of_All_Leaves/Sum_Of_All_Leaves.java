package Sum_Of_All_Leaves;

import java.util.LinkedList;
import java.util.Queue;

public class Sum_Of_All_Leaves {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);

        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);

        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(12);
        treeNode.right.right = new TreeNode(17);
        
        // int result = sumOfAllLeaves_Recursion(treeNode);
        int result = sumOfAllLeaves_Iterative(treeNode);
        System.out.println(result);
        
        
    }
    
    static int result = 0;
    public static int sumOfAllLeaves_Recursion(TreeNode root) {
        
        helperDFS(root);
        return result;

    }
    
    public static int sumOfAllLeaves_Iterative(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if(node.left == null && node.right == null)
                result += node.val;
            
            if(node.left != null)
                queue.offer(node.left);
            
            if(node.right != null)
                queue.offer(node.right);
        }
        
        
        return result;
    }
    
    public static void helperDFS(TreeNode root) {
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            result += root.val;
        
        if(root.left != null)
            helperDFS(root.left);
        
        if(root.right != null)
            helperDFS(root.right);
        
    }

}
