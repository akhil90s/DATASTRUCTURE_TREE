package Traversals_In_A_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversals_In_A_Binary_Tree {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);

		// preOrderTraversal(node);
		
		inOrderTraversal(node);
		
		// postOrderTraversal(node);

		// List<Integer> result_Queue = preOrderTraversal_Iterative_UsingQueue(node);
		// List<Integer> result_Stack = preOrderTraversal_Iterative_UsingStack(node);
		// System.out.println(result_Queue);
		// System.out.println(result_Stack);

		// List<Integer> result = inOrderTraversal_Iterative(node);
		// System.out.println(result);

		// List<Integer> result = postOrderTraversal_Iterative(node);
		// System.out.println(result);

	}

	public static void preOrderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.value + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static List<Integer> preOrderTraversal_Iterative_UsingQueue(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> stack = new LinkedList<>();
		stack.offer(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.poll();
			result.add(temp.value);

			if (temp.left != null) {
				stack.offer(temp.left);
			}

			if (temp.right != null) {
				stack.offer(temp.right);
			}
		}
		return result;
	}

	public static List<Integer> preOrderTraversal_Iterative_UsingStack(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			result.add(temp.value);

			if (temp.right != null) {
				stack.push(temp.right);
			}

			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		return result;
	}

	public static void inOrderTraversal(TreeNode root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.value + " ");
			inOrderTraversal(root.right);
		}

	}

	public static List<Integer> inOrderTraversal_Iterative(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		boolean inOrderTraversal = false;
		TreeNode currentNode = root;
		while (!inOrderTraversal) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (stack.isEmpty()) {
					inOrderTraversal = true;
				} else {
					currentNode = stack.pop();
					result.add(currentNode.value);
					currentNode = currentNode.right;
				}
			}
		}
		return result;
	}

	public static void postOrderTraversal(TreeNode root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.value + " ");
		}
	}

	public static List<Integer> postOrderTraversal_Iterative(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode currentNode = stack.peek();
			if (prev == null || prev.left == currentNode || prev.right == currentNode) {
				if (currentNode.left != null)
					stack.push(currentNode.left);
				else if (currentNode.right != null)
					stack.push(currentNode.right);

			} else if (currentNode.left == prev) {

				if (currentNode.right != null) {
					stack.push(currentNode.right);
				}
			} else {
				result.add(currentNode.value);
				stack.pop();
			}
			prev = currentNode;
		}
		return result;
	}

}
