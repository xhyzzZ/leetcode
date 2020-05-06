// leetcode 1338 Reduce Array Size to The Half

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int size = arr.length;
        int sum = 0;
        int res = 0;
        while (sum < size / 2) {
            Map.Entry m = pq.poll();
            sum += (int) m.getValue();
            res++;
        }
        return res;
    }
}