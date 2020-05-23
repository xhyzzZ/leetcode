// leetcode 802 Find Eventual Safe States

/*
time: O(v + e)
space: O(v)
*/

/*when color[i] = 1 means node i is visiting.
when color[i] = 0 means node i is not visited.
when color[i] = 2 means node i has been already visited.
when color[i] = 1 and it is visited again, it is not safe, otherwise it is safe.
*/ 
// dfs
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        int[] visited = new int[len];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (topologicalSort(graph, i, visited)) res.add(i);
        }
        return res;
    }
    
    // 0 -> unvisited, 1 -> visiting, 2 -> visited
    private boolean topologicalSort(int[][] graph, int v, int[] visited) {
        if (visited[v] > 0) {
           return visited[v] == 2;
       	}
        visited[v] = 1;
        for (int neighbor : graph[v]) {
            if (visited[neighbor] == 2) continue;
            if (visited[neighbor] == 1 || !topologicalSort(graph, neighbor, visited)) return false;
        }
        visited[v] = 2;
        return true;
    }
}