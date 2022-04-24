// leetcode 2192 All Ancestors of a Node in a Directed Acyclic Graph

/*
time: O(n^2 + e)
space: O(n^2 + e)
*/

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Build graph, and compute in degree.
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        // 1. Use a list of sets to save ancestors and to avoid duplicates.
        // 2. Use a Queue to save 0-in-degree nodes as the starting nodes for topological sort.
        List<Set<Integer>> sets = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sets.add(new HashSet<>());
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        // BFS to their neighbors and decrease the in degrees, when reaching 0, add it into queue;
        // During this procedure, get direct parent, add all ancestors of direct parents' of each child.
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int child : map.getOrDefault(cur, Arrays.asList())) {
                sets.get(child).add(cur);
                sets.get(child).addAll(sets.get(cur));
                if (--inDegree[child] == 0) queue.offer(child);
            }
        }
        
        // Sort ancestors and put into return list. 
        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : sets) ans.add(new ArrayList<>(new TreeSet<>(set)));
        return ans;
    }
}