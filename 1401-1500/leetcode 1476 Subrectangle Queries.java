// leetcode 1476 Subrectangle Queries

/*
time: O()
space: O()
*/

class SubrectangleQueries {
    int[][] grid;
    public SubrectangleQueries(int[][] rectangle) {
        int m = rectangle.length, n = rectangle[0].length;
        grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                grid[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return grid[row][col];
    }
}