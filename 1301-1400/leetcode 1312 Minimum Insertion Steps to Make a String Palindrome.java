// leetcode 1312 Minimum Insertion Steps to Make a String Palindrome

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public int minInsertions(String s) {
        int len = s.length();
        // Create a table of size n*n. table[i][j] 
        // will store minumum number of insertions 
        // needed to convert str[i..j] to a palindrome. 
        int[][] dp = new int[len][len]; 
   
        for (int gap = 1; gap < len; gap++) {
            for (int left = 0, right = gap; right < len; left++, right++) {
                dp[left][right] = (s.charAt(left) == s.charAt(right)) ? dp[left + 1][right - 1] : (Integer.min(dp[left][right - 1], dp[left + 1][right]) + 1);
            }
        }
        
        return dp[0][len - 1];
    }
}