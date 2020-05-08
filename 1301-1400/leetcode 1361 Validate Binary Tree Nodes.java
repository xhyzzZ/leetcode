// leetcode 1361 Validate Binary Tree Nodes

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
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < leftChild.length; i++) {
            int parent = i;
            int x = leftChild[i], y = rightChild[i];
            if (x != -1) {
                if (!uf.union(parent, x)) { return false; } // loop detected
            }
            if (y != -1) {
                if (!uf.union(parent, y)) { return false; } // loop detected
            }
        }
        
        return uf.count == 1;
        
    }
}