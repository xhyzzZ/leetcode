// leetcode 1252 Cells with Odd Values in a Matrix

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] grid = new int[n][m];
        for (int[] indice : indices) {
            int row = indice[0];
            int col = indice[1];
            for (int i = 0; i < m; i++) {
                grid[row][i]++;
            }
            for (int j = 0; j < n; j++) {
                grid[j][col]++;
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % 2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}