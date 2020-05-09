// leetcode 1400 Construct K Palindrome Strings

/*
time: O(n)
space: O(26)
*/

class Solution {
    public boolean canConstruct(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            count[s.charAt(i) - 'a']++;
        }
        int oddNum = 0;
        for (int i = 0; i < 26; ++i) {
            oddNum += count[i] % 2;
        }
        return oddNum <= k && k <= s.length();
    }
}