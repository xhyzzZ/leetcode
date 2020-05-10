// leetcode 1443 Minimum Time to Collect All Apples in a Tree

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) { 
            adj.add(new ArrayList<>()); 
        
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(0, adj, hasApple, visited);
    }
    
    private int dfs(int from, List<List<Integer>> adj, List<Boolean> hasApple, Set<Integer> visited) {

		visited.add(from);
		int res = 0;
		for (int child : adj.get(from)) {
			if (visited.contains(child)) continue;
			res += dfs(child, adj, hasApple, visited);
		}
		
		// res > 0 means: any of descendant has an apple, or check this node itself has an apple
		if ((res > 0 || hasApple.get(from)) && from != 0) res += 2;

		return res;
	}
}