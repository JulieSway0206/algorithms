// We are given N items where each item has some weight and profit associated with it. We are also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The target is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 
//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

// Time Complexity: O(N * W). As redundant calculations of states are avoided.
// Auxiliary Space: O(N * W) + O(N). The use of a 2D array data structure for storing intermediate states and O(N) auxiliary stack space(ASS) has been used for recursion stack

// A Dynamic Programming based solution
// for 0-1 Knapsack problem
 
import java.io.*;
 
public class Knapsack {
 
    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b) { return (a > b) ? a : b; }
 
    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
 
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w]
                        = max(val[i-1]
                                  + K[i - 1][w - wt[i-1]],
                              K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
 
        return K[n][W];
    }
 
    // Driver code
    public static void main(String args[])
    {
        int profit[] = new int[] { 1, 2, 5, 6 };
        int weight[] = new int[] { 2,3,4,5 };
        int W = 8;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}
    }