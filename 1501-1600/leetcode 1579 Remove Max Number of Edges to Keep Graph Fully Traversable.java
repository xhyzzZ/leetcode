// leetcode 1579 Remove Max Number of Edges to Keep Graph Fully Traversable

/*
time: O(n^2)
space: O(n^2)
*/

class UnionFind {
    private int[] parent, rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    // find(...) amortizes to O(α(N))
    public int find(int p) {
        if (parent[p] == p) return p;
        return find(parent[p]);
    }
    
    // path compression and union by rank to optimize
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

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        
        UnionFind alice = new UnionFind(n + 1);
        UnionFind bob = new UnionFind(n + 1);
        int removedEdges = 0, totalEdges = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int a = edge[1];
            int b = edge[2];
            
            if (type == 3) {
                boolean isEdgeValidForAlice = alice.union(a, b);
                boolean isEdgeValidForBob = bob.union(a, b);

                if (isEdgeValidForAlice) totalEdges++;
                if (isEdgeValidForBob) totalEdges++;
                
                // remove the edge if it's not valid
                if (!isEdgeValidForAlice || !isEdgeValidForBob) removedEdges++;
            } else if (type == 2) {
                boolean isEdgeValidForBob = bob.union(a, b);
                if (isEdgeValidForBob) totalEdges++;   
                else removedEdges++;
            } else {
                boolean isEdgeValidForAlice = alice.union(a, b);
                if (isEdgeValidForAlice) totalEdges++;
                else removedEdges++;
            }
        }
        
        // n - 1 for alice and n - 1 for bob
        if (totalEdges != 2 * n - 2) return -1;
                
        return removedEdges;   
    }
}