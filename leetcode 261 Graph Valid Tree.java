//leetcode 261 Graph Valid Tree

/*
time: O(V + E)
space: O(V + E)
*/

union find
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // perform union find
        for (int[] e : edges) {
            int x = findRoot(parent, e[0]);
            int y = findRoot(parent, e[1]);
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            // union
            parent[x] = y;
        }
        return edges.length == n - 1;
    }
    
    private int findRoot(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}

dfs
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // initialize adjacency list.
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        // do DFS from vertex 0, after one round DFS, if there is no loop and visited contains all the vertexs,
        // it is a tree.
        boolean res = helper(-1, 0, visited, graph);
        if (!res) return res;
        return visited.size() == n ? true : false;
    }

    public boolean helper(int parent, int vertex, Set<Integer> visited, List<List<Integer>> graph) {
        List<Integer> subs = graph.get(vertex);
        for (int v : subs) {
            // if v is vertex's parent, continue.
            if (v == parent) continue; 
            // if v is not vertex's parent, and v is visited. that presents there is a cycle in this graph.
            if(visited.contains(v)) return false;
            visited.add(v);
            boolean res = helper(vertex, v, visited, graph);
            if (!res) return false;
        }
        return true;
    }
}