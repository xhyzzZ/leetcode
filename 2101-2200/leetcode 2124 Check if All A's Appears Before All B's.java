// leetcode 2124 Check if All A's Appears Before All B's

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean checkString(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a') return false;
        }
        return true;
    }
}