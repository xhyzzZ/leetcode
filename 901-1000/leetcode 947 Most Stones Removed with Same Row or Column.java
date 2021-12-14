// leetcode 947 Most Stones Removed with Same Row or Column

/*
time: O(n^2)
space: O(n)
*/

dfs
class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0]  == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j); 
                    graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i); 
                }
            }
        }
        
        int res = 0; 
        Set<Integer> visited = new HashSet<>(); 
        for(int sIndex = 0; sIndex < stones.length; sIndex++) {
            if (visited.contains(sIndex)) continue; 
            res += dfs(sIndex, visited, graph) - 1;
        }
        
        return res;
    }
    
    private int dfs(int root, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        int res = 1;
        visited.add(root); 
        if (!graph.containsKey(root)) return res;
        for (int child : graph.get(root)) {
            if (!visited.contains(child)) res += dfs(child, visited, graph); 
        }
    
        return res;
    }
}