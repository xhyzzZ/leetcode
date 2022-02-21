// leetcode 1312 Minimum Insertion Steps to Make a String Palindrome

/*
time: O(n^2)
space: O(n^2)
*/

// An example could be illustrative. e.g., "mbadm". Let's mark the characters not in LCS:
// "mbadm"
// Reverse:
// "mdabm"
// We need at least 2 insertions - b and d - to make them palindromes:
// "mbdadbm" or
// "mdbabdm"
class Solution {
    public int minInsertions(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s, r);
    }

    private int lcs(String s, String r) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i + 1][j + 1] = s.charAt(i) == r.charAt(j) ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[n][n];        
    }
}