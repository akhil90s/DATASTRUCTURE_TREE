package Binary_Tree_Level_Order_Traversal_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		List<List<Integer>> result_levelOrderBottom = levelOrderBottom(node);
		System.out.println(result_levelOrderBottom);
		
		
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                
                TreeNode node = queue.poll();
                
                if(node.left != null)
                    queue.offer(node.left);
                
                if(node.right != null)
                    queue.offer(node.right);
                
                list.add(node.value);
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
	}

}
