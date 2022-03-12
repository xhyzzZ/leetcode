// leetcode 727 Minimum Window Subsequence

/*
time: O(n^2)
space: O(n^2)
*/

// dp[i][j] means: for S(0~i) & T(0~j), the "largest" starting index in S which matches T
class Solution {
    public String minWindow(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                // largest starting index matches only first char in T
                dp[i][0] = i;        
            } else {
                if (i == 0) {
                    // S, T both have 1 char, if !match, fill -1 means we can't find a substring for S(0) & T(0)
                    dp[i][0] = -1; 
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }

        for (int j = 1; j < s2.length(); j++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0) {
                        //  Actually, if j > i, dp[i][j] is always -1, cause we cant find a substring of a shorter string matches a longer string
                        dp[i][j] = -1;       
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];  // As share2017 mentioned in his post
                    }
                } else {
                    if (i == 0) {
                        dp[i][j] = -1;      
                    } else {
                        dp[i][j] = dp[i - 1][j];  
                    }
                }
            }
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < s1.length(); i++) {
            if (dp[i][s2.length() - 1] != -1) {
                if (i - dp[i][s2.length() - 1] + 1 < len) {
                    len = i - dp[i][s2.length() - 1] + 1;
                    start = dp[i][s2.length() - 1];
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s1.substring(start, start + len);
    }
}