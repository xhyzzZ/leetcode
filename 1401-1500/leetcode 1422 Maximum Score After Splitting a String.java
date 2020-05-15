// leetcode 1422 Maximum Score After Splitting a String

/*
time: O(n^2)
space: O(1)
*/

class Solution {
    public int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int left = count(s.substring(0, i), '0');
            int right = count(s.substring(i), '1');
            max = Math.max(max, left + right);
        }
        return max;
    }
    
    private int count(String s, char ch) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) count++;
        }
        return count;  
    }
}