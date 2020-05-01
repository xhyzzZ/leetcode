//leetcode 132 Palindrome Partitioning II

/*
time: O()
space: O()
*/

class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
        	return 0;
        } 
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
        	dp[i] = i;
        }
        for (int mid = 1; mid < len; mid++) { // iterate through all chars as mid point of palindrome
            // CASE 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < len && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
            // CASE 2: even len: center is between [mid-1,mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < len && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[len - 1];
    }
}
