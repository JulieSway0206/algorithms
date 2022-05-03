// https://gist.github.com/kean/40a1e592a608154b117a0dac48baf25f
// A binary search tree was created by traversing through an array from left to right and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
//Solution.
//Let's start with an example.
//     4
//    / \
//   2   5 
//  / \   \
// 1   3   6
//To construct this tree we must insert the node 4 first. This node is always going to be the first element in each of the possible solution. Lets remove this node from the tree.
//   2    5    
//  / \    \
// 1   3    6
// To continue construcing the tree from the example we now have a choice of eather inserting 2 or 5. Notice that both are the roots of the respective subtrees. Lets start with node 2 and remove it from the tree.
// 1   3   5
//          \
//           6
//We are left with 3 subtrees. We now have a choice of removing either 1, 3 or 5.
//You can clearly see that there is an inductive step which we can use to implement our solution:
// start with a root of the tree (the only valid choice)

// for each of the current valid choices:
// - remove one of the roots (valid choices), add its children to the set of choices
// - recursively find all possible solutions for the new set of choices
// - append the root to the head of each of those solutions

// the recursion ends when there are no remaining nodes (choices) left
/*public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 */
 //        3
 // 1             4
 //    2             5
// Input: nums = [3,4,5,1,2]
// Output: 5
// Explanation: The following 5 arrays will yield the same BST: 
// [3,1,2,4,5]
// [3,1,4,2,5]
// [3,1,4,5,2]
// [3,4,1,2,5]
// [3,4,1,5,2]
import java.util.ArrayList;
public class MyClass {
    public static ArrayList<ArrayList<Integer>> visit(ArrayList<TreeNode> roots) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for(int i = 0; i < roots.size(); i++) {
            ArrayList<TreeNode> choices = (ArrayList<TreeNode>)roots.clone();
            choices.remove(i);
            TreeNode root = roots.get(i);
            if(root.left != null){
                choices.add(root.left);
            }
            if(root.right != null) {
                choices.add(root.right);
            }
            Integer rootVal = root.val;
            if(choices.size() > 0) {
                ArrayList<ArrayList<Integer>> sequences = visit(choices);
                for(ArrayList<Integer> sequence : sequences) {
                    sequence.add(0, rootVal);
                    output.add(sequence);
                }
             } else {
                 ArrayList<Integer> leafArray = new ArrayList<>(); 
                 leafArray.add(rootVal);
                 output.add(leafArray);
             }
            
        }
        return output;
    }
    public static void main(String args[]) {
      TreeNode two = new TreeNode(2, null, null);
      TreeNode one = new TreeNode(1, null, two);
      TreeNode five = new TreeNode(5, null, null);
      TreeNode four = new TreeNode(4, null, five);
      TreeNode three = new TreeNode(3, one, four);
      ArrayList<TreeNode> roots = new ArrayList<TreeNode>();
      roots.add(three);
      System.out.println("all possible arrays: " + visit(roots));
    }
}
// def bst_sequences(root: TreeNode):
//     def __visit(roots: List):
//         output = []
//         for root in roots:
//             choices = [choice for choice in roots if choice != root]
//             if root.left:
//                 choices.append(root.left)
//             if root.right:
//                 choices.append(root.right)

//             if len(choices) > 0:
//                 sequences = __visit(choices)
//                 for sequence in sequences:
//                     output.append([root.value] + sequence)
//             else:
//                 output.append([root.value])
//         return output

//     return __visit([root])
