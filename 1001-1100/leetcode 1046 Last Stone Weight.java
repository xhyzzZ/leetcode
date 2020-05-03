// leetcode 1046 Last Stone Weight

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() >= 2) {
            int first = pq.poll(), second = pq.poll();
            if (first != second) {
                pq.offer(first - second);
            }
        }
        if (pq.size() == 0) return 0;
        else return pq.poll();
    }
}