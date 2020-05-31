// leetcode 1462 Course Schedule IV

/*
time: O(n^3)
space: O(n^2)
*/

Floyd–Warshall Algorithm

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites) {
            connected[p[0]][p[1]] = true; // p[0] -> p[1]
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            ans.add(connected[q[0]][q[1]]);
        }
        return ans;
    }
}

bfs
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            int prev = pair[0];
            int next = pair[1];
            graph.get(prev).add(next);
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(bfs(query[0], query[1], n, graph));
        }
        return res;
    }
    
    private boolean bfs(int from, int to, int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            for (int adj : graph.get(cur)) {
                if (adj == to) return true;
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }
        return false;
    }
}

dfs
class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            int prev = pair[0];
            int next = pair[1];
            graph.get(prev).add(next);
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            boolean[] visited = new boolean[n];
            res.add(dfs(query[0], query[1], visited, graph));
        }
        return res;
    }
    
    private boolean dfs(int cur, int to, boolean[] visited, List<List<Integer>> graph) {
        
        if (cur == to) return true;
        if (visited[cur]) return false;
        visited[cur] = true;
        
        for (int next : graph.get(cur)) {
            if (dfs(next, to, visited, graph)) return true;
        }
        
        return false;
    }
}

