package Binary_Search_Tree;

public class Node {

	private int data;
	private Node leftChild;
	private Node rightChild;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public void insert(int value) {
		if (value == data) {
			return;
		}
		if (value < data) {
			if (leftChild == null) {
				leftChild = new Node(value);
			} else {
				leftChild.insert(value);
			}
		} else {
			if (rightChild == null) {
				rightChild = new Node(value);
			} else {
				rightChild.insert(value);
			}
		}
	}

	public void inOrderTraversal() {

		if (leftChild != null) {
			leftChild.inOrderTraversal();
		}
		
		System.out.print(data + " ");

		if (rightChild != null) {
			rightChild.inOrderTraversal();
		}
	}

	
	
	// PreOrder Traversal : Root Left Right
	public void preOrderTraversal() {
		
		System.out.print(data + " ");
		
		if (leftChild != null) {
			leftChild.preOrderTraversal();
		}
		
		if (rightChild != null) {
			rightChild.preOrderTraversal();
		}
		
	}
	
	// PostOrder Traversal : Left Right Root
	public void postOrderTraversal() {
		
		if (leftChild != null) {
			leftChild.postOrderTraversal();
		}
		
		if (rightChild != null) {
			rightChild.postOrderTraversal();
		}
		
		System.out.print(data + " ");
	}

	
	public Node get(int value) {

		if (value == data) {
			return this;
		}

		if (value < data) {
			if (leftChild != null) {
				return leftChild.get(value);
			}
		} else {
			if (rightChild != null) {
				return rightChild.get(value);
			}
		}

		return null;
	}

	public int min() {
		if (leftChild == null) {
			return data;
		} else {
			return leftChild.min();
		}
	}

	public int max() {

		if (rightChild == null) {
			return data;
		} else {
			return rightChild.max();
		}
	}

}