//“ Boolean Parenthesization Problem ” states that we are given a sequence of true and false, and some boolean operators( AND, OR, XOR) in between them. We need to find the number of ways to parenthesize the given sequence such that the entire sequence results in TRUE. 
//Exm:
//Ways(T|F^T) = 1
//https://www.youtube.com/watch?v=MM7fXopgyjw
//Time Complexity: O(N^3)
//explanation: you have (N*N*2) state, for each state, you run a for loop for the partition to be made, so (N*N*2)*N
//Space Complexity: O(N^2)
import java.util.* ;
import java.io.*; 
public class Solution {
    static int mod = 1000000007;
    public static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              dp[i][j][1] = -1;
              dp[i][j][0] = -1;
          }
      }
        return helper(0, n-1, true, exp, dp);
    }
    public static int helper(int i, int j, boolean isTrue, String exp, int[][][] dp){
        int thirdInd = isTrue ? 1 : 0;
        if(i > j)
            return 0;
        if(i == j){
            if(isTrue)
                return exp.charAt(i) == 'T' ? 1 : 0;
            else
                return exp.charAt(i) == 'F' ? 1 : 0;
        }
        if(dp[i][j][thirdInd] != -1) {
            System.out.println(dp[i][j][thirdInd]);  
            return dp[i][j][thirdInd];
        }
            
        int ways = 0;
        for(int index = i + 1; index <= j - 1; index += 2){
            int lT = helper(i, index - 1, true, exp, dp);
            int lF = helper(i, index - 1, false, exp, dp);
            int rT = helper(index + 1, j, true, exp, dp);
            int rF = helper(index + 1, j, false, exp, dp);
            if(exp.charAt(index) == '&') {
                if(isTrue)
                    ways += (lT * rT) % mod;
                else
                    ways += (lT * rF) % mod + (lF * rT) % mod + (lF * rF) % mod;
            } else if(exp.charAt(index) == '|') {
                if(isTrue)
                    ways += (lT * rT) % mod + (lT * rF) % mod + (lF * rT) % mod;
                else
                    ways += (lF * rF) % mod;
            }
            else if(exp.charAt(index) == '^') {
                if(isTrue)
                    ways += (lT * rF) % mod + (lF * rT) % mod;
                else
                    ways += (lT * rT) % mod + (lF * rF) & mod;
            }
        }
        return dp[i][j][thirdInd] = ways;
    }
}