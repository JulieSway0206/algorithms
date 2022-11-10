// Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x (the number of values less than or equal to x). Implement the data structures and algorithms to support these operations. That is, implement the method getRankOfNumber(int x), which is called when each number of values less than or equal to x (not including x itself).
// And implement the method track(int x), which is called when each number is generated.

// Exmp:
// Input :  arr[] = {10, 20, 15, 3, 4, 4, 1}
//               x = 4;
// Output : Rank of 4 in stream is: 3
// There are total three elements less than
// or equal to x (and not including x)

// Input : arr[] = {5, 1, 14, 4, 15, 9, 7, 20, 11}, 
//            x = 20;
// Output : Rank of 20 in stream is: 8

// https://www.geeksforgeeks.org/rank-element-stream/
//A relatively easy way to implement this is to use an array that holds all the elements in sorted order. When a new element is inserted we would shift the elements. Then we perform a binary search on the array to get the right-most index of x and return that index. getRank(x) would work in O(log n) but insertion would be costly.
//insertion in sorted array O(n)
//https://www.geeksforgeeks.org/search-insert-and-delete-in-a-sorted-array/
//https://iq.opengenus.org/time-and-space-complexity-of-binary-search-tree/
//Average case time complexity for search in binary search tree is O(logn) (for balanced binary search tree is O(logn))
//Average case time complexity for insertion in binary search tree is O(logn)

// Java program to find rank of an
// element in a stream.
class GfG {

static class Node {
	int data;
	Node left, right;
	int leftSize;
}

static Node newNode(int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.left = null;
	temp.right = null;
	temp.leftSize = 0;
	return temp;
}

// Inserting a new Node.
static Node insert(Node root, int data)
{
	if (root == null)
		return newNode(data);

	// Updating size of left subtree.
	if (data <= root.data) {
		root.left = insert(root.left, data);
		root.leftSize++;
	}
	else
		root.right = insert(root.right, data);

	return root;
}

// Function to get Rank of a Node x.
static int getRank(Node root, int x)
{
	// Step 1.
	if (root.data == x)
		return root.leftSize;

	// Step 2.
	if (x < root.data) {
		if (root.left == null)
			return -1;
		else
			return getRank(root.left, x);
	}

	// Step 3.
	else {
		if (root.right == null)
			return -1;
		else {
			int rightSize = getRank(root.right, x);
			if(rightSize == -1) return -1; //If an element is not found in the stream or is the smallest in the stream, return -1. 
			return root.leftSize + 1 + rightSize;
		}
	}
}

// Driver code
public static void main(String[] args)
{
	int arr[] = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
	int n = arr.length;
	int x = 4;

	Node root = null;
	for (int i = 0; i < n; i++)
		root = insert(root, arr[i]);

	System.out.println("Rank of " + x + " in stream is : "+getRank(root, x));

	x = 13;
	System.out.println("Rank of " + x + " in stream is : "+getRank(root, x));

}
}
