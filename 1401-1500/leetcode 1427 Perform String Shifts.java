// leetcode 1427 Perform String Shifts

/*
time: O(n)
space: O(1)
*/

class Solution {
    public String stringShift(String s, int[][] shift) {
        int pos = 0, len = s.length();
        for (int[] sh : shift) {
            pos += sh[0] == 0 ? sh[1] : -sh[1];
        }
        
        pos %= len;
        if (pos < 0) {
            pos += len;
        }
        return s.substring(pos) + s.substring(0, pos);
    }
}