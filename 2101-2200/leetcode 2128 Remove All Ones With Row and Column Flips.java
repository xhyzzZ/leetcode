// leetcode 2128 Remove All Ones With Row and Column Flips

/*
time: O(mn)
space: O(1)
*/

// Each row or col can flip at most once. Flip twice convert it back to original.
// Refer to LC73, we pick row 0 and col 0 as reference.
// In order to make the whole grid 0,
// row 0 and col 0 need to be 0.

// Thus if there is a 1 in row 0 or col 0, we have to flip.
// And the flip should not affect the other 0 in the row 0 or col 0.
// so we flip the row if we find 1 in col 0 and flip the col if we find 0 in row 0.
class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) flip(grid, i, true);
        }
        
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) flip(grid, j, false);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return false;
            }
        }
        return true;
    }
    
    private void flip(int[][] grid, int x, boolean isRow) {
        int m = grid.length, n = grid[0].length;
        if (isRow) {
            for (int j = 0; j < n; j++) {
                grid[x][j] = 1 - grid[x][j];
            }
        } else {
            for (int i = 0; i < m; i++) {
                grid[i][x] = 1 - grid[i][x];
            }
        }
    }
}