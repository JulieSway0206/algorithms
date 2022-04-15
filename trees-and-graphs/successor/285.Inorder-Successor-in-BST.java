// Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.
// The successor of a node p is the node with the smallest key greater than p.val.

//Hint:
//When the node has a right child
//1. The inorder successor in this case is the leftmost node (7) in the tree rooted at the right child.
//           6 (p)
//  4                   10
//                8           12      
//            7       9
//2. In this case, the right child (10) itself will be the inorder successor of the designated node.
//           6 (p)
// 4                   10
//                           12
//When the node doesn't have a right child
// In this case, one of the ancestors (6) acts as the inorder successor. That ancestor can be the immediate parent, or, it can be one of the ancestors further up the tree.
//                     6
//     4                             10
//         5                                  12

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}

// Time Complexity: O(N) since we might end up encountering a skewed tree and in that case, we will just be discarding one node at a time. For a balanced binary-search tree, however, the time complexity will be O(logN) which is what we usually find in practice.

// Space Complexity: O(1) since we don't use recursion or any other data structures for getting our successor.