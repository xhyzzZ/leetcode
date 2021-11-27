// leetcode 1100 Find K-Length Substrings With No Repeated Characters

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        
        while (end < s.length()) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));

            if (end - start + 1 == k) {
                ans++;
                set.remove(s.charAt(start));
                start++;
            }
            end++;
        }
        return ans;
    }
}