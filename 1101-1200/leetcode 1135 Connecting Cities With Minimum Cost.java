// leetcode 1135 Connecting Cities With Minimum Cost

/*
time: O()
space: O()
*/

class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent, rank;
        
        public UnionFind(int n) {
            count = n;
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
            count--;
            return true;
        }
        
        public int count() {
            return count;
        }
    }
    
    public int minimumCost(int N, int[][] connections) {
        UnionFind uf = new UnionFind(N);
        int sum = 0;
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        
        for (int[] connection : connections) {
            int x = connection[0], y = connection[1], cost = connection[2];
            if (uf.union(x, y)) {
                sum += cost;
            };
        }
        return uf.count == 1 ? sum : -1;
    }
}