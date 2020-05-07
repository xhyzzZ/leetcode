// leetcode 1351 Count Negative Numbers in a Sorted Matrix

/*
time: O(n^2)
space: O(1)
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) count++;
            }
        }
        return count;
    }
}