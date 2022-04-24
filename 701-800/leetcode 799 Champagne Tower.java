// leetcode 799 Champagne Tower

/*
time: O(n^2)
space: O(n^2)
*/

class Solution {
    // In general, if a glass has flow-through X, then Q = (X - 1.0) / 2.0 quantity of champagne will equally flow left and right.
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_glass + 2];
        dp[0][0] = poured;
        
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                double rest = Math.max(dp[i][j] - 1.0, 0);
                dp[i + 1][j] += rest / 2.0;
                dp[i + 1][j + 1] += rest / 2.0;
            }
        }
        
        return Math.min(dp[query_row][query_glass], 1.0);
    }
}