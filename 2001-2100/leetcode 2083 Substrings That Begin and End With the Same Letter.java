// leetcode 2083 Substrings That Begin and End With the Same Letter

/*
time: O(n)
space: O(1)
*/

class Solution {
    public long numberOfSubstrings(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c -'a']++;
        
        long res = 0;
        for (long count : freq) {
            res += count * (count-1) / 2 + count;
        }
        
        return res;
    }
}