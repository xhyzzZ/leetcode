// leetcode 2185 Counting Words With a Given Prefix

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) res++;
        }
        
        return res;
    }
}