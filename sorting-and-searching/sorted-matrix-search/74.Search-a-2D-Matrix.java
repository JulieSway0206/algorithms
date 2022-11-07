// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.

// Approach 1: Binary Search
// Time complexity : O(log(mn)) since it's a standard binary search.
// Space complexity : O(1).
//For "(left + right) // 2", using "left + (right - left) // 2" might be better since left+right might cause overflow issue if both left and right is very large.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = left + (right - left) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }
}