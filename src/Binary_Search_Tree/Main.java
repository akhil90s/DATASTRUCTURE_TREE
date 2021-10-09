package Binary_Search_Tree;

public class Main {

	public static void main(String[] args) {

		TreeImplementation treeImplementation = new TreeImplementation();

		treeImplementation.insert(25);
		treeImplementation.insert(20);
		treeImplementation.insert(15);
		treeImplementation.insert(27);
		treeImplementation.insert(30);
		treeImplementation.insert(29);
		treeImplementation.insert(26);
		treeImplementation.insert(22);
		treeImplementation.insert(32);
		treeImplementation.insert(17);
		
		treeImplementation.inOrderTraversal();
		// treeImplementation.postOrderTraversal();
		// treeImplementation.preOrderTraversal();
		
		System.out.println();
		System.out.println("Min Value : " + treeImplementation.min());
		System.out.println("Max Value : " + treeImplementation.max());

	}

}
