// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

//Hint: Not only the right child should be larger than the node but all the elements in the right subtree. Here is an example :
//             5
// 1                         6
//                  4                   7
//That means one should keep both upper and lower limits for each node while traversing the tree, and compare the node value not with children values but with these limits.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null) {
            return true;
        }
        if((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        } 
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root) {
            return validate(root, null, null);
    }
}


// Time complexity : \mathcal{O}(N)O(N) since we visit each node exactly once.
// Space complexity : \mathcal{O}(N)O(N) since we keep up to the entire tree.