// leetcode 1347 Minimum Number of Steps to Make Two Strings Anagram

/*
time: O(n)
space: O(128)
*/

class Solution {
    public int minSteps(String s, String t) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++)  
            if (map[t.charAt(i) - 'a']-- <= 0) 
                count++; 
          
        return count; 
    }
}