// leetcode 1167 Minimum Cost to Connect Sticks

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) {
            pq.offer(s);
        }
        int res = 0;
        while (pq.size() != 1) {
            int small = pq.poll(), large = pq.poll();
            int sum = small + large;
            res += sum;
            pq.offer(sum);
        }
        return res;
    }
}