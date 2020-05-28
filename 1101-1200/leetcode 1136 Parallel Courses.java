// leetcode 1136 Parallel Courses

/*
time: O(v + e)
space: O(v + e)
*/

class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[N + 1];
        for (int[] relation : relations) {
        	int prev = relation[0];
            int next = relation[1];
            graph.computeIfAbsent(prev, l -> new ArrayList<>()).add(next);
            indegree[next]++; // count prerequisites for r[1].
        } 

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int canFinishCount = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		int curr = queue.poll(); 
	            N--;
	            if (!graph.containsKey(curr)) continue;
	            for (int adj : graph.get(curr)) {
	                indegree[adj]--;
	                if (indegree[adj] == 0) {
	                    queue.offer(adj);
	                }
	            }
	            graph.remove(curr);
        	}
            canFinishCount++;
        }
        return N == 0 ? canFinishCount : -1;
    }
}