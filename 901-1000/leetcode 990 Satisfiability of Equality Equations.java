// leetcode 990 Satisfiability of Equality Equations

/*
time: O(n)
space: O(n)
*/

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

class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.find(equation.charAt(0) - 'a') == uf.find(equation.charAt(3) - 'a')) return false;
            }
        }
        return true;
    }
}