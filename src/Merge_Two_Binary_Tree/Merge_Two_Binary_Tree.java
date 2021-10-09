package Merge_Two_Binary_Tree;

import java.util.Stack;

public class Merge_Two_Binary_Tree {

	public static void main(String[] args) {

		TreeNode treeNode_1 = new TreeNode(1);
		treeNode_1.left = new TreeNode(3);
		treeNode_1.right = new TreeNode(2);
		treeNode_1.left.left = new TreeNode(5);

		TreeNode treeNode_2 = new TreeNode(2);
		treeNode_2.left = new TreeNode(1);
		treeNode_2.right = new TreeNode(3);
		treeNode_2.left.right = new TreeNode(4);
		treeNode_2.right.right = new TreeNode(7);

		mergeTrees_Recursive(treeNode_1, treeNode_2);
		mergeTrees_Iterative(treeNode_1, treeNode_2);

	}

	public static TreeNode mergeTrees_Recursive(TreeNode t1, TreeNode t2) {

		if (t1 == null)
			return t2;

		if (t2 == null)
			return t1;

		t1.value += t2.value;
		t1.left = mergeTrees_Recursive(t1.left, t2.left);
		t1.right = mergeTrees_Recursive(t1.right, t2.right);

		return t1;
	}

	public static TreeNode mergeTrees_Iterative(TreeNode t1, TreeNode t2) {

		Stack<TreeNode[]> stack = new Stack<>();
		stack.push(new TreeNode[] { t1, t2 });

		while (!stack.isEmpty()) {

			TreeNode[] t = stack.pop();
			if (t[0] == null && t[1] == null) {
				continue;
			}
			t[0].value += t[1].value;
			if (t[0].left == null) {
				t[0].left = t[1].left;
			} else {
				stack.push(new TreeNode[] { t[0].left, t[1].left });
			}
			if (t[0].right == null) {
				t[0].right = t[1].right;
			} else {
				stack.push(new TreeNode[] { t[0].right, t[1].right });
			}

		}

		return t1;

	}

}
