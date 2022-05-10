// You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
// An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
// Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// Time Complexity: O(M×N). The rectangular grid given to us is of size M×N and we process each cell just once.
// Space Complexity: O(1). We are utilizing the obstacleGrid as the DP array. Hence, no extra space.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1 ? 1 : 0;
        }
        
        for (int j = 1; j < C; j++) {
            obstacleGrid[0][j] = obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1 ? 1 : 0;
        }
        
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        return obstacleGrid[R-1][C-1];
    }
}