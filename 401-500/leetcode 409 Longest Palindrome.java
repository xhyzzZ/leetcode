//leetcode 409 Longest Palindrome

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int longestPalindrome(String s) {
        boolean[] map = new boolean[128];
        int len = 0;
        for (char c : s.toCharArray()) {
            map[c] = !map[c];         // flip on each occurrence, false when seen n*2 times
            if (!map[c]) len += 2;
        }
        if (len < s.length()) len++; // if more than len, atleast one single is present
        return len;
    }
}