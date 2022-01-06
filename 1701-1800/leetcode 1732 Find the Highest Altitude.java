// leetcode 1732 Find the Highest Altitude

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < gain.length; i++) {
            cur += gain[i]; 
            max = Math.max(cur, max);
        }
        return max;
    }
}