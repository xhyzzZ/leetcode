// leetcode 1337 The K Weakest Rows in a Matrix

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < mat.length; i++) {
            int one = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) one++;  
            }
            pq.add(new int[] {i, one});
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty() && k-- > 0) {
            int index = pq.poll()[0];
            res[i++] = index;
        }
        return res;
    }
}