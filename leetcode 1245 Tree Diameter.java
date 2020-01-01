// leetcode 1245 Tree Diameter

/*
time: O(n)
space: O(n)
Travese all the nodes of the tree. 
The diameter of the tree is maximum of the longest path through each node.
Longest path through a node is sum of top 2 depths of children's tree.
*/

class Solution {
    int diameter = 0;

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) adj[i] = new LinkedList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        diameter = 0;
        depth(0, -1, adj);
        return diameter;
    }

    private int depth(int root, int parent, LinkedList<Integer>[] adj) {
        int maxDepth1st = 0, maxDepth2nd = 0;
        for (int child : adj[root]) {
            if (child != parent) { // Only one way from root node to child node, don't allow child node go to root node again!
                int childDepth = depth(child, root, adj);
                if (childDepth > maxDepth1st) {
                    maxDepth2nd = maxDepth1st;
                    maxDepth1st = childDepth;
                } else if (childDepth > maxDepth2nd) {
                    maxDepth2nd = childDepth;
                }
            }
        }
        int longestPathThroughRoot = maxDepth1st + maxDepth2nd; // Sum of the top 2 highest depths is the longest path through this root
        diameter = Math.max(diameter, longestPathThroughRoot);
        return maxDepth1st + 1;
    }
}