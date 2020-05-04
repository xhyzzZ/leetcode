// leetcode 1232 Check If It Is a Straight Line

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 3 || coordinates[0].length == 0) return false;
        
        int[] p = coordinates[0];
        int[] q = coordinates[1];
        
        for (int i = 2; i < coordinates.length; i++) {
            int[] curr = coordinates[i];
            
            if ((curr[0] - p[0]) * (q[1] - p[1]) != (curr[1] - p[1]) * (q[0] - p[0])) return false;
        }
        
        return true;
    }
}