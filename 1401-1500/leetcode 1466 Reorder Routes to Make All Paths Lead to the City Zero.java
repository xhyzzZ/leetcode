// leetcode 1466 Reorder Routes to Make All Paths Lead to the City Zero

/*
time: O(v + e)
space: O(v)
*/

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] pair : connections) {
            int from = pair[0];
            int to = pair[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(new int[] {to, 1});
            graph.get(to).add(new int[] {from, 0});
        }
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    
    private int dfs(int curr, Map<Integer, List<int[]>> graph, boolean[] visited) {
        int ans = 0;
        visited[curr] = true;
        for (int[] next : graph.get(curr)) {
            if (!visited[next[0]]) {
                ans += next[1];
                ans += dfs(next[0], graph, visited);
            }
        }
        return ans;
    }
}