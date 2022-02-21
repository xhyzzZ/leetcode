// leetcode 361 Bomb Enemy

/*
time: O(mn)
space: O(n)
*/

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int rowhits = 0;
        int[] colhits = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowhits = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++)
                        rowhits += grid[i][k] == 'E' ? 1 : 0;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colhits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++)
                        colhits[j] += grid[k][j] == 'E' ? 1 : 0;
                }
                if (grid[i][j] == '0') res = Math.max(res, rowhits + colhits[j]);
            }
        }
        return res;
    }
}