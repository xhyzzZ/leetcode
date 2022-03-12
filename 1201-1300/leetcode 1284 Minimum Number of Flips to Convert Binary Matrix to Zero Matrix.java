// leetcode 1284 Minimum Number of Flips to Convert Binary Matrix to Zero Matrix

/*
time: O(m * n * 2 ^ (m * n))
space: O(2 ^ (m * n))
*/

class Solution {
    private static final int[] dirs = {0, 0, 1, 0, -1, 0};
    // [0 1] ---> "0110"b ---> 6
    // [1 0]
    public int minFlips(int[][] mat) {
        int start = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= mat[i][j] << (i * n + j); // convert the matrix to an int.
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // All 0s matrix found.
                if (cur == 0) return step;
                // traverse all m * n bits of cur.
                for (int j = 0; j < m; j++) { 
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int z = 0; z < 5; ++z) { // flip the cell (j, k) and its neighbors.
                            int r = j + dirs[z], c = k + dirs[z + 1];
                            if (r >= 0 && r < m && c >= 0 && c < n) next ^= 1 << (r * n + c);
                        }
                        if (seen.add(next)) // seen it before ?
                            queue.offer(next); // no, put it into the Queue.
                    }
                }    
            }
            step++;
        }
        return -1; // impossible to get all 0s matrix.
    }
}