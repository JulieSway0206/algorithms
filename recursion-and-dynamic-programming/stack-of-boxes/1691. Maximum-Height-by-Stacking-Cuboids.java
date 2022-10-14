// Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of cuboids and place them on each other.
// You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.
// Return the maximum height of the stacked cuboids.
// Exmp:
// Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
// Output: 190
// Explanation:
// Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
// Cuboid 0 is placed next with the 45x20 side facing down with height 50.
// Cuboid 2 is placed next with the 23x12 side facing down with height 45.
// The total height is 95 + 50 + 45 = 190

// Complexity
// Time O(n^2)
// Space O(n)

class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int[] a : cuboids) {
            Arrays.sort(a);
        }
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0])
                    return b[0] - a[0];
                if(a[1] != b[1])
                return b[1] - a[1];
                return b[2] - a[2];
            }
        });
 
        int n = cuboids.length;
        int[] dp = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for(int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;