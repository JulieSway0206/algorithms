//You are implementing a binary tree class from scratch which, in addition to isert, find, and delete, has a method
//getRandomNode() which returns a random node from that tree. All nodes should be equally likely to be chosen..
//https://iq.opengenus.org/select-random-node-from-binary-tree/
//Approach: Inorder traversal using ArrayList
// Time Complexity : O(n), where n is the number of nodes in the tree
// Auxiliary Space Complexity : Theta(1)
import java.util.ArrayList;
class Node {
	int item;
	Node left, right;
	
	public Node(int key) {
		item = key;
		left = right = null;
	}
}

class Tree {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	Node root;
	Tree() {
		root = null;
	}

	static void inOrder(Node node) {
		if(node == null) 
			return;
		inOrder(node.left);
		list.add(node.item);
		inOrder(node.right);
	}

	public void getrandom(Node val) {
		inOrder(val);
		int n = list.size();
		int min = 0;
		int max = n - 1;
		int b = (int)(Math.random()*(max - min + 1) + min);
		int random = list.get(b);
		System.out.println("Random Node : " + random);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(12);
		tree.root.right = new Node(9);
		tree.root.left.left = new Node(5);
		tree.root.left.right = new Node(6);

		tree.getrandom(tree.root);
	}
}