// leetcode 1494 Parallel Courses II

/*
time: O()
space: O()
*/

class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] pair : dependencies) {
            int prev = pair[0];
            int next = pair[1];
            graph.get(prev).add(next);
            indegree[next]++;
            outdegree[prev]++;
        }

        // we must pick course which has more child first    
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(outdegree[b], outdegree[a]));
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
        
        int semesters = 0;
		int courses = 0;

		while (!pq.isEmpty()) {
			Queue<Integer> next = new LinkedList<>();
			for (int i = 0; i < k && !pq.isEmpty() && courses < n; i++) {  
				int from = pq.poll();
				courses++;
				for (int to : graph.get(from)) {
					if (--indegree[to] == 0) next.offer(to);
				}
			}
			while (!next.isEmpty()) pq.offer(next.poll());
			semesters++;
		}
		return semesters;
    }
}