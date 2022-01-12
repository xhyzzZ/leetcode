// leetcode 1615 Maximal Network Rank

/*
time: O(n^2)
space: O(n)
*/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], s -> new HashSet<>()).add(road[1]);
            graph.computeIfAbsent(road[1], s -> new HashSet<>()).add(road[0]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set1 = graph.getOrDefault(i, Collections.emptySet());
                Set<Integer> set2 = graph.getOrDefault(j, Collections.emptySet());
                int duplicate = set1.contains(j) ? 1 : 0;
                max = Math.max(max, set1.size() + set2.size() - duplicate);
            }
        }
        return max;
    }
}