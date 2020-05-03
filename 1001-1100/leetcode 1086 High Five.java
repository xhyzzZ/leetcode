// leetcode 1086 High Five

/*
time: O(nlogk)
space: O(n)
*/

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int i = 0; i < items.length; i++) {
            int[] item = items[i];
            int id = item[0], score = item[1];
            if (!map.containsKey(id)) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(5);
                pq.offer(score);
                map.put(id, pq);
            } else {
                PriorityQueue<Integer> pq = map.get(id);
                pq.offer(score);
                if (pq.size() > 5) {
                   pq.poll();
                }
                map.put(id, pq);
            }
        }
        int index = 0;
        int[][] res = new int[map.size()][2];
        for (int key : map.keySet()) {
            res[index][0] = key;
            PriorityQueue<Integer> pq = map.get(key);
            int sum = 0;
            int size = pq.size();
           
            while (!pq.isEmpty()) {
               sum += pq.poll();
            }
            res[index][1] = sum / size;
            index++;
        }
        return res;
    }
}