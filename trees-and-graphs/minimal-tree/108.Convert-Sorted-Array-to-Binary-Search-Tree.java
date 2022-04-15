/**
Given an integer array nums where the elements are sorted in ascending order, 
convert it to a height-balanced binary search tree(Minimal Height).

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
Binary Search Tree is a node-based binary tree data structure which has the following properties:
The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.

How to Traverse the Tree. DFS: Preorder, Inorder, Postorder; BFS. Different strategies:
1. DFS Preorder (Node -> Left -> Right):        2. DFS Inorder (Left -> Node -> Right)
[root.val]                                      inorder(root.left)
preorder(root.left)                             [root.val]
preorder(root.right)                            inorder(root.right)
if root else []                                 if root else []

Uses of Inorder:
In the case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. 
To get nodes of BST in non-increasing order, a variation of Inorder traversal where Inorder traversal s reversed can be used.                                


3. DFS Postorder (Left -> Right -> Node)        4. BFS (Node -> Left -> Right)
postorder(root.left)                            iterations with the queue
postorder(root.right)
[root.val]
if root else []

an iterative function is one that loops to repeat some part of the code, 
and a recursive function is one that calls itself again to repeat the code.

Approach 1: Preorder Traversal: Always Choose Left Middle Node as a Root
Implement helper function helper(left, right), which constructs BST from nums elements between indexes left and right:

If left > right, then there is no elements available for that subtree. Return None.

Pick left middle element: p = (left + right) // 2.

Initiate the root: root = TreeNode(nums[p]).

Compute recursively left and right subtrees: root.left = helper(left, p - 1), root.right = helper(p + 1, right).

Return helper(0, len(nums) - 1).
*/

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
    int[] nums;
    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p-1);
        root.right = helper(p+1, right);
        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
}