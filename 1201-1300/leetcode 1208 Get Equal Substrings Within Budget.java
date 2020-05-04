// leetcode 1208 Get Equal Substrings Within Budget

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0, n = s.length(), cost = 0, res = 0;
        while (right < n) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}