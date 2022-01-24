// leetcode 2146 K Highest Ranked Items Within a Price Range

/*
time: O(mnlog(mn))
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        int x = start[0], y = start[1], low = pricing[0], high = pricing[1];
        List<List<Integer>> res = new ArrayList<>();
        // PriorityQueue sorted by (distance, price, row, col).
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        	(a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] == b[2] ? 
        	a[3] - b[3] : a[2] - b[2] : a[1] - b[1] : a[0] - b[0]
        );
        pq.offer(new int[] {0, grid[x][y], x, y});
        grid[x][y] *= -1;
        while (!pq.isEmpty() && res.size() < k) {
            int[] cur = pq.poll();
            // distance, price, row & column
            int distance = cur[0], price = cur[1], r = cur[2], c = cur[3]; 
            // price in range and size less than k?
            if (low <= price && price <= high && res.size() < k) res.add(Arrays.asList(r, c));
            for (int[] dir : dirs) {
                int dr = r + dir[0], dc = c + dir[1];
                // in boundary, not wall, and not visited yet?
                if (0 <= dr && dr < m && 0 <= dc && dc < n && grid[dr][dc] > 0) {
                    pq.offer(new int[] {distance + 1, grid[dr][dc], dr, dc});
                    grid[dr][dc] *= -1;
                }
            }
        }
        return res;
    }
}