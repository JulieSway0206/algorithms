// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.
// Exp 1:
// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
// Exp 2:
// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
//https://www.educative.io/answers/coin-change-problem-2-finding-the-number-of-ways-to-make-a-sum
//https://www.youtube.com/watch?v=DJ4a7cmjZY0

//0/1 Knapsack Problem (include or exclude)
//https://leetcode.com/discuss/study-guide/1152328/01-Knapsack-Problem-and-Dynamic-Programming
//followup what if the weight is very large??

//A = amount, C = # of coins
//Time = O(A * C)
//Space = O(A * C)

class Solution {
    public int change(int amount, int[] coins) {
        int size = coins.length;
        int[][] dp = new int[size + 1][amount + 1];
		//Initializing first column of array to 1
      	// because a sum of 0 can be made
      	// in one possible way: {0}
        for(int i = 0; i < size + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < size + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(coins[i - 1] > j) // Cannot pick the highest coin:
                    dp[i][j] = dp[i - 1][j];
                else // Pick the highest coin:
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
            }
        }
        return dp[size][amount];
    }
}