// leetcode 1499 Max Value of Equation

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        // Suppose i < j, then we can translate yi + yj + |xi - xj| to (yi - xi) + (yj + xj).
		// For a given point j, since (yj + xj) is fixed, we only need to maximize the (yi - xi) 
		// among the previously seen point_i.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - b[0] - (a[1] - a[0])));
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] cur = pq.peek();
                res = Math.max(res, point[1] + cur[1] + point[0] - cur[0]);
            }
            pq.offer(point);
        }
        
        return res;
    }
}