// leetcode 1335 Minimum Difficulty of a Job Schedule

/*
time: O(n^2d)
space: O(nd)
*/

class Solution {
    // F(i, j) means the minimum difficulty on i-th day who takes j-th work as its end.
    // F(i, j) = MIN{ F(i - 1, k - 1) + MAX_DIFFICULTY(k, j) }, k from i to j
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) return -1;
        int[][] dp = new int[d + 1][len + 1];

        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i <= len; i++) {
            dp[1][i] = Math.max(jobDifficulty[i - 1], dp[1][i - 1]);
        }

        for (int i = 2; i <= d; i++) {
            for (int j = i; j <= len; j++) {
                int currMax = 0;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i; k--) {
                    currMax = Math.max(currMax, jobDifficulty[k - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + currMax);
                }
            }
        }

        return dp[d][len];
    }
}