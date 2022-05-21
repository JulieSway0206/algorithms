// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
//ex. Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), 
//backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
// Time complexity: O(N*2^N) to generate all subsets and then copy them into output list.

// Space complexity: O(N). We are using O(N) space to maintain path, and are modifying path in-place with backtracking. 
// Note that for space complexity analysis, we do not count space that is only used for the purpose of returning output, so the output array is ignored.



class Solution {
    public void dfs(int[] nums, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList(path));
        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        ArrayList<Integer> path = new ArrayList();
        dfs(nums, 0, path, res);
        return res;
    }
}
