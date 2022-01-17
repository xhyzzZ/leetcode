// leetcode 2140 Solving Questions With Brainpower

/*
time: O(n)
space: O(n)
*/

class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            int point = questions[i][0], brain = questions[i][1];
            dp[i] = Math.max(dp[i + 1], point + dp[Math.min(len, i + brain + 1)]);
        }
        return dp[0];        
    }
}
