// leetcode 1208 Get Equal Substrings Within Budget

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, end = 0, n = s.length(), cost = 0, res = 0;
        while (end < n) {
            cost += Math.abs(s.charAt(end) - t.charAt(end));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}