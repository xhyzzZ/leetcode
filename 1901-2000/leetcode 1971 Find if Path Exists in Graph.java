// leetcode 1971 Find if Path Exists in Graph

/*
time: O(v + e)
space: O(v + e)
*/

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
    
        for (var edge : edges) {
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }

        return validPath(map, new HashSet<>(), start, end);
    }

    private boolean validPath(Map<Integer, Set<Integer>> map, Set<Integer> visited, int current, int end) {
        if (current == end) return true;
            
        if (!visited.add(current)) return false;
            
        for (int neighbor : map.getOrDefault(current, new HashSet<>())) {
            if (validPath(map, visited, neighbor, end)) return true;
        }
                
        return false;
    }
}
