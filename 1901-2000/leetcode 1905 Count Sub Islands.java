// leetcode 1905 Count Sub Islands

/*
time: O(mn)
space: O(1)
*/

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (find(grid1, grid2, i, j)) ans++;
                }
            }
        }
        return ans;
    }
    
    private boolean find(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r == grid1.length || c == grid1[0].length || grid2[r][c] == 0) return true;
        if (grid1[r][c] == 0) return false;

        grid2[r][c] = 0;
        boolean a = find(grid1, grid2, r + 1, c);
        boolean b = find(grid1, grid2, r - 1, c);
        boolean x = find(grid1, grid2, r, c + 1);
        boolean y = find(grid1, grid2, r, c - 1);   
        return ((a && b) && (x && y));
    }
}