// leetcode 1926 Nearest Exit from Entrance in Maze

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int steps = 0;
        
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir: dirs) {
                    int x = dir[0] + curr[0];                    
                    int y = dir[1] + curr[1];
                    
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (visited[x][y] || maze[x][y] == '+') continue;
                    
                    // check if we have reached boundary
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return steps;
                    
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;
    }
}