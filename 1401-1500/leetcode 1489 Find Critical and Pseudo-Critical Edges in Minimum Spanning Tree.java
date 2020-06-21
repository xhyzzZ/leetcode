// leetcode 1489 Find Critical and Pseudo-Critical Edges in Minimum Spanning Tree

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
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
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

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();

        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) map.put(edges[i], i);

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int minCost = buildMST(n, edges, null, null);

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithout = buildMST(n, edges, null, edge);
            if (costWithout > minCost) {
                criticals.add(index);
            } else {
                int costWith = buildMST(n, edges, edge, null);
                if (costWith == minCost) {
                    pseduos.add(index);
                }
            }
        }
        
        return Arrays.asList(criticals, pseduos);
    }

    private int buildMST(int n, int[][] edges, int[] pick, int[] skip) {
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        if (pick != null) {
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        
        for (int[] edge : edges) {
            if (edge != skip && uf.union(edge[0], edge[1])) {
                cost += edge[2];
            }
        }
        return uf.count == 1 ? cost : Integer.MAX_VALUE;
    }
}