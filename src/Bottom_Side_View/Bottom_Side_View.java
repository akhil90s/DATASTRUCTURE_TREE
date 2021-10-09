package Bottom_Side_View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Bottom_Side_View {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);

		node.left = new TreeNode(2);
		node.right = new TreeNode(3);

		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		List<Integer> result_bottomSideView = bottomSideView(node);
		System.out.println(result_bottomSideView);

	}
	
	public static List<Integer> bottomSideView(TreeNode root){
		
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		
		List<List<Integer>> verticalTraversal = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(root, 0));
		int minhl = 0, maxhl = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size != 0) {
				Pair pair = queue.poll();
				
				minhl = Math.min(pair.horizontalLevel, minhl);
				maxhl = Math.max(pair.horizontalLevel, maxhl);
				
				map.putIfAbsent(pair.horizontalLevel, new ArrayList<>());
				map.get(pair.horizontalLevel).add(pair.node.value);
				
				if(pair.node.left != null)
					queue.offer(new Pair(pair.node.left, pair.horizontalLevel - 1));
				
				if(pair.node.right != null)
					queue.offer(new Pair(pair.node.right, pair.horizontalLevel + 1));
				
				size--;
			}
		}
		
		for(int i = minhl; i <= maxhl; i++) {
			verticalTraversal.add(map.get(i));
		}
		
		for(int i = 0; i< verticalTraversal.size(); i++) {
			result.add(verticalTraversal.get(i).get(verticalTraversal.get(i).size() - 1));
		}
		
		return result;
	}

}

class Pair{
	
	TreeNode node;
	int horizontalLevel;
	
	public Pair(TreeNode node, int horizontalLevel) {
		super();
		this.node = node;
		this.horizontalLevel = horizontalLevel;
	}
	
}
