// leetcode 1376 Time Needed to Inform All Employees

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int j = manager[i];
            if (j != -1) graph.get(j).add(i);
        }
        return dfs(graph, informTime, headID);
    }

    private int dfs(Map<Integer, List<Integer>> graph, int[] informTime, int cur) {
        int max = 0;
        for (int v : graph.get(cur)) {
            max = Math.max(max, dfs(graph, informTime, v));
        }
        return max + informTime[cur];
    }
}