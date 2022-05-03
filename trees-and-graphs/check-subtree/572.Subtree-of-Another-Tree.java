// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
//ex. root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//               3                                         4
//     4                   5                          1          2
//1          2
//        0


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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        if(isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        // if(subRoot == null) return true;
        // if(root == null) return false;
        if(root == null && subRoot == null) return true;
        // if(root != null && subRoot == null) return false;
        // if(root == null && subRoot != null) return false;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}
