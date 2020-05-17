// leetcode 1446 Consecutive Characters

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int maxPower(String s) {
        int res = 1, count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res; 
    }
}