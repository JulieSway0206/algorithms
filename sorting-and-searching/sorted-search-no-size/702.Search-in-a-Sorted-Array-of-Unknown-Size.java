// This is an interactive problem.
// You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
// returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
// returns 231 - 1 if the i is out of the boundary of the array.
// You are also given an integer target.
// Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
// You must write an algorithm with O(log n) runtime complexity.
// Exmp:
// Input: secret = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in secret and its index is 4.

// Input: secret = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in secret so return -1.

// A single left shift multiplies a binary number by 2
// For positive numbers, a single logical right shift divides a number by 2
// https://www.interviewcake.com/concept/java/bit-shift
// Prerequisites: left and right shifts
// To speed up, one could use here bitwise shifts:
// Left shift: x << 1. The same as multiplying by 2: x * 2.
// Right shift: x >> 1. The same as dividing by 2: x / 2.



//Approach:
// Define Search Boundaries:
// The idea is quite simple. Let's take two first indexes, 0 and 1, as left and right boundaries. If the target value is not among these zeroth and the first element, then it's outside the boundaries, on the right.
// That means that the left boundary could moved to the right, and the right boundary should be extended. To keep logarithmic time complexity, let's extend it twice as far: right = right * 2.
//Time complexity : O(logT), where T is an index of target value.
//Space complexity : O(1) since it's a constant space solution.
class Solution {
  public int search(ArrayReader reader, int target) {
    if (reader.get(0) == target) return 0;

    // search boundaries
    int left = 0, right = 1;
    while (reader.get(right) < target) {
      left = right;
      right <<= 1;
    }

    // binary search
    int pivot, num;
    while (left <= right) {
      pivot = left + ((right - left) >> 1);
      num = reader.get(pivot);

      if (num == target) return pivot;
      if (num > target) right = pivot - 1;
      else left = pivot + 1;
    }

    // there is no target element
    return -1;
  }
}