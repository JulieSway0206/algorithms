//Given a binary tree, determine if it is height-balanced.
//For this problem, a height-balanced binary tree is defined as:
// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//Hint: post order traversal indicates bottom up, pre order traversal indicates top down
//The balanced subtree definition hints at the fact that we should treat each subtree as a subproblem. The question is: in which order should we solve the subproblems?
//Intuition
//In approach 1, we perform redundant calculations when computing \texttt{height}height. In each call to \texttt{height}height, we require that the subtree's heights also be computed. Therefore, when working top down we will compute the height of a subtree once for every parent. We can remove the redundancy by first recursing on the children of the current node and then using their computed height to determine whether the current node is balanced.

//Approach 1: Top-down recursion           Time complexity : O(nlogn)
class Solution {
  // Recursively obtain the height of a tree. An empty tree has -1 height
  private int height(TreeNode root) {
    // An empty tree has height -1
    if (root == null) {
      return -1;
    }
    return 1 + Math.max(height(root.left), height(root.right));
  }

  public boolean isBalanced(TreeNode root) {
    // An empty tree satisfies the definition of a balanced tree
    if (root == null) {
      return true;
    }

    // Check if subtrees have height within 1. If they do, check if the
    // subtrees are balanced
    return Math.abs(height(root.left) - height(root.right)) < 2
        && isBalanced(root.left)
        && isBalanced(root.right);
  }
};

//Approach 2: Bottom-up recursion         Time complexity : O(n)
// Utility class to store information from recursive calls
final class TreeInfo {
  public final int height;
  public final boolean balanced;

  public TreeInfo(int height, boolean balanced) {
    this.height = height;
    this.balanced = balanced;
  }
}

class Solution {
  // Return whether or not the tree at root is balanced while also storing
  // the tree's height in a reference variable.
  private TreeInfo isBalancedTreeHelper(TreeNode root) {
    // An empty tree is balanced and has height = -1
    if (root == null) {
      return new TreeInfo(-1, true);
    }

    // Check subtrees to see if they are balanced.
    TreeInfo left = isBalancedTreeHelper(root.left);
    if (!left.balanced) {
      return new TreeInfo(-1, false);
    }
    TreeInfo right = isBalancedTreeHelper(root.right);
    if (!right.balanced) {
      return new TreeInfo(-1, false);
    }

    // Use the height obtained from the recursive calls to
    // determine if the current node is also balanced.
    if (Math.abs(left.height - right.height) < 2) {
      return new TreeInfo(Math.max(left.height, right.height) + 1, true);
    }
    return new TreeInfo(-1, false);
  }

  public boolean isBalanced(TreeNode root) {
    return isBalancedTreeHelper(root).balanced;
  }
};