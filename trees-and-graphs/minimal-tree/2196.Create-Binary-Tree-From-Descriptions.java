// You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

// If isLefti == 1, then childi is the left child of parenti.
// If isLefti == 0, then childi is the right child of parenti.
// Construct the binary tree described by descriptions and return its root.

// The test cases will be generated such that the binary tree is valid.
// Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
// Output: [50,20,80,15,17,19]
// Explanation: The root node is the node with value 50 since it has no parent.
// The resulting binary tree is shown in the diagram.
//              50
//      20              80
//15         17    19   

//Hint: The node that is not a child in any of the descriptions is the root node.
//Approach: Java HashMap
//Java hash map get keys:
//for ( String key : team1.keySet() ) {
//     System.out.println( key );
// }

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
    Map<TreeNode, TreeNode> childToParent = new HashMap();
    Map<Integer, TreeNode> nodes = new HashMap();
    public TreeNode createBinaryTree(int[][] descriptions) {
        for (int[] d : descriptions) {
            nodes.putIfAbsent(d[0], new TreeNode(d[0]));
            nodes.putIfAbsent(d[1], new TreeNode(d[1]));
            if (d[2] == 1) nodes.get(d[0]).left  = nodes.get(d[1]);
            else nodes.get(d[0]).right = nodes.get(d[1]);
            
            childToParent.put(nodes.get(d[1]), nodes.get(d[0]));
        }
        
        TreeNode ans = null;
        for(TreeNode n : nodes.values()) {
            if(!childToParent.containsKey(n)) ans = n;
        }
        return ans;
    }
}