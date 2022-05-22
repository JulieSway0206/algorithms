// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
//ex. Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//Backtracking
// Here n is the number of elements present in the given array.
// Time complexity: O(n⋅2^n)
// As we can see in the diagram above, this approach does not generate any duplicate subsets. Thus, in the worst case (array consists of n distinct elements), the total number of recursive function calls will be 2 ^ n 
// . Also, at each function call, a deep copy of the subset currentSubset generated so far is created and added to the subsets list. This will incur an additional O(n) time (as the maximum number of elements in the path will be n). So overall, the time complexity of this approach will beO(n⋅2^n ).

// Space complexity: O(n)
// The space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, in Java, the Arrays.sort() for primitives is implemented as a variant of quicksort algorithm whose space complexity is O(logn). The output list of subsets is not considered while analyzing space complexity. So, the space complexity of this approach is O(n).


class Solution {
    public void dfs(int[] nums, int index, ArrayList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList(path));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        ArrayList<Integer> path = new ArrayList();
        dfs(nums, 0, path, res);
        return res;
    }
}

//Iterative
// Time complexity: O(n⋅2^n)
//Space complexity: O(logn)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int subsetSize = 0;
        for(int i = 0; i < nums.length; i++) {
            int startIndex = (i >= 1 && nums[i] == nums[i-1]) ? subsetSize : 0;
            subsetSize = subsets.size();
            for(int j = startIndex; j < subsetSize; j++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(j));
                currentSubset.add(nums[i]);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}