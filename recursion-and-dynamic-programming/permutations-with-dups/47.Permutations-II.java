// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
//Based on Permutation, we can add a set to track if an element is duplicate and no need to swap.
//hashset is implemented using a hash table. elements are not ordered. the add, remove, and contains methods has constant time complexity o(1).
//https://www.geeksforgeeks.org/distinct-permutations-string-set-2/
class Solution {
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        // System.out.print(nums + "\n");
        if(first == n) {
            output.add(new ArrayList<Integer>(nums));
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = first; i < n; i++) {
            if(set.contains(nums.get(i))) {
                continue;
            }
            set.add(nums.get(i));
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, i, first);
        }
    }
  
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> nums_lst = new ArrayList();
        for(int num : nums) {
            nums_lst.add(num);
        }
        Collections.sort(nums_lst);
        backtrack(nums.length, nums_lst, output, 0);
        return output;
    }
}
