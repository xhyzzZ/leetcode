// leetcode 2050 Parallel Courses III

/*
time: O(v + e)
space: O(v + e)
*/

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int indegree[] = new int[n];
        int completionTime[] = new int[n];
        for (int[] relation : relations) {
        	int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph.computeIfAbsent(prev, l -> new ArrayList<>()).add(next);
            indegree[next]++; // count prerequisites for r[1].
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) { // if no prerequisite add it to queue
                completionTime[i] = time[i];
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		int curr = queue.poll(); 
        		if (!graph.containsKey(curr)) continue;
	            for (int adj : graph.get(curr)) {
	                completionTime[adj] = Math.max(completionTime[adj], completionTime[curr] + time[adj]);
	                indegree[adj]--;
	                if (indegree[adj] == 0) { // when all prerequisite are complete add the next course
	                    queue.add(adj);
	                }
	            }
        	}
        }
        int res = 0;
        for (int x : completionTime) res = Math.max(res, x);
        return res;
    }
}