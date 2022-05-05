// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

// The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
//Solution:
//Prefix sum technique
//https://leetcode.com/problems/path-sum-iii/solution/
// Time complexity: \mathcal{O}(N)O(N), where NN is a number of nodes. During preorder traversal, each node is visited once.

// Space complexity: up to \mathcal{O}(N)O(N) to keep the hashmap of prefix sums, where NN is a number of nodes.


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
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();
    public void preorder(TreeNode node, int currSum) {
        if(node == null)
            return;
        currSum += node.val;
        if(currSum == k) 
            count++;
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        preorder(node.left, currSum);
        preorder(node.right, currSum);
        h.put(currSum, h.get(currSum) - 1);
        
    }
    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0);
        return count;
    }
}