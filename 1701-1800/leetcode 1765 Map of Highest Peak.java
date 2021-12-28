// leetcode 1765 Map of Highest Peak

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] height = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isWater[r][c] == 1) {
                    height[r][c] = 0;
                    queue.offer(new int[] {r, c});
                } else {
                    height[r][c] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int r = top[0], c = top[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || height[nr][nc] != -1) continue;
                height[nr][nc] = height[r][c] + 1;
                queue.offer(new int[] {nr, nc});
            }
        }
        return height;
    }
}