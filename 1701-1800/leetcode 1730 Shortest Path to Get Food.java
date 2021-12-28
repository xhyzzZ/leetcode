// leetcode 1730 Shortest Path to Get Food

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int getFood(char[][] grid) {
        int n = grid.length, m = grid[0].length, steps = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*') {
                    queue.add(new int[] {i , j});
                    break;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int row = top[0], col = top[1];
                
                if (grid[row][col] == '#') return steps;
                
                for (int[] dir : dirs) {
                    int r = row + dir[0], c = col + dir[1];
                    if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] != 'X' && !visited[r][c]) {
                         visited[r][c] = true;
                         queue.add(new int[] {r, c});
                    }
                } 
            }
            steps++;
        }
        return -1;
    }
}