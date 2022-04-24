// leetcode 2186 Minimum Number of Steps to Make Two Strings Anagram II

/*
time: O(n)
space: O(26)
*/

class Solution {
    public int minSteps(String s, String t) {
        int res = 0;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
        }
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) res += Math.abs(map[i]);
        }
        
        return res;
    }
}