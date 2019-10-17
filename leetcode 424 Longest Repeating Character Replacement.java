// leetcode 424 Longest Repeating Character Replacement

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int uniqueCount = 0;
        int start = 0;
        int max = 0;
        int[] count = new int[26];
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            uniqueCount = Math.max(uniqueCount, ++count[c - 'A']);
            int replaceCount = end - start + 1 - uniqueCount;
            if (replaceCount > k) {
                // invalid window
                count[s.charAt(start) - 'A']--;
                start++;
            } else {
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}