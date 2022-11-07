// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
// You must write an algorithm that runs in O(n) time and uses only constant extra space.
// Exp:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]

//Approach 1: Sort and Compare Adjacent Elements
// Time complexity : O(nlogn) + O(n) ≃ O(nlogn).
// Space complexity : No extra space required, other than the space for the output list. Sorting can be done in-place.
//Arrays.sort(int[] a) in recent JDK is implemented with Dual-pivot Quicksort algorithm which has O(n log n) average complexity and is performed in-place (e.g. requires no extra space).
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans.add(nums[i]);
                i++;        // skip over next element
            }
        }

        return ans;
    }
}

//Approach 2: Mark Visited Elements in the Input Array itself
//Time complexity : O(n). 
//Space complexity : No extra space required, other than the space for the output list. We re-use the input array to store visited status
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) { // seen before
                ans.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }

        return ans;
    }
}