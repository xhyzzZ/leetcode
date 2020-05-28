// leetcode 1229 Meeting Scheduler

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] s : slots1) {
            if (s[1] - s[0] >= duration) pq.offer(s);
        }
        for (int[] s : slots2) {
            if (s[1] - s[0] >= duration) pq.offer(s);
        }
        while (pq.size() > 1) {
        	int[] cur = pq.poll();
        	int[] next = pq.peek();
            if (cur[1] >= next[0] + duration) {
                return Arrays.asList(next[0], next[0] + duration);
            }
        }
        return Arrays.asList();
    }
}