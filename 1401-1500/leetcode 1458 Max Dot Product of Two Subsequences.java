// leetcode 1458 Max Dot Product of Two Subsequences

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, max = Integer.MIN_VALUE;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = nums1[i] * nums2[j];
                max = Math.max(p, max);
                p = Math.max(p, 0);
                dp[i + 1][j + 1] = Math.max(dp[i][j] + p, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }
        return max <= 0 ? max : dp[m][n];
    }
}