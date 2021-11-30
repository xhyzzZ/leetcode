Union Find Template

// Let E be the number of edges, and N be the number of nodes.

// α(N) is the Inverse Ackermann Function, will never have a value larger than 4

// Time Complexity : O(N * α(N)) the worst case is when E = N - 1

// Space Complexity : O(N)

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
        count--;
        return true;
    }
    
    public int count() {
        return count;
    }
}

public class Solution {
    
    public boolean template(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!uf.union(x, y)) { return false; }  // loop detected
        }
        return uf.count == 1;
    }
}