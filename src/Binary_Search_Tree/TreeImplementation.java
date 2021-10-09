package Binary_Search_Tree;

public class TreeImplementation {

	private Node root;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.insert(value);
		}
	}

	public void inOrderTraversal() {
		if (root != null) {
			root.inOrderTraversal();
		}
	}

	public void postOrderTraversal() {
		if (root != null) {
			root.postOrderTraversal();
		}
	}

	public void preOrderTraversal() {
		if (root != null) {
			root.preOrderTraversal();
		}
	}

	public Node get(int value) {
		if (root != null) {
			return root.get(value);
		}
		return null;
	}

	public int min() {

		if (root == null) {
			return Integer.MIN_VALUE;
		} else {
			return root.min();
		}

	}

	public int max() {

		if (root == null) {
			return Integer.MAX_VALUE;
		} else {
			return root.max();
		}

	}
	
	// Node is a leaf; Node has one child; Node has two children
	// public void delete(int value) {}

	
	
}