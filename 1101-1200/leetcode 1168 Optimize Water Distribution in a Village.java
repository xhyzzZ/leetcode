// leetcode 1168 Optimize Water Distribution in a Village

/*
time: O()
space: O()
*/

class Solution {
    class UnionFind {
        private int[] parent, rank;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
            if (parent[p] == p) return p;
            return find(parent[p]);
        }
        
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else if (rank[rootQ] < rank[rootP]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            return true;
        }
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // int[] from to cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        UnionFind u = new UnionFind(n);
        for (int[] pipe : pipes) {
            pq.offer(pipe);
        }
        
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {0, i + 1, wells[i]});
        }
        
        int sum = 0, count = 0;
        while (count < n) {
            int[] info = pq.poll();
            int from = info[0];
            int to = info[1];
            int cost = info[2];
            if (u.union(from, to)) {
                count++;
                sum += cost;
            }
        }
        return sum;
    }
}
