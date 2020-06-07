// leetcode 1471 The k Strongest Values in an Array

/*
time: O(nlogn)
space: O(k)
*/

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int median = arr[(len - 1) / 2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a - median) == Math.abs(b - median) ? (a - b) : Math.abs(a - median) - Math.abs(b - median));
        for (int i = 0; i < len; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }
}
