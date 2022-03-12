// leetcode 1606 Find Servers That Handled Most Number of Requests

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counter = new int[k];
        // use a tree to track available servers
        TreeSet<Integer> available = new TreeSet<Integer>();
        for (int num = 0; num < k; num++) available.add(num);
        // use a PQ to maintain the availability at current arrival time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        for (int i = 0; i < arrival.length; i++) {
            int curTime = arrival[i];
            int endTime = curTime + load[i];
            while (!pq.isEmpty() && pq.peek()[0] <= curTime) {
                int free = pq.poll()[1];
                available.add(free);
            }
            if (available.size() == 0) continue; // all busy
            Integer assignNum = available.ceiling(i % k);
            if (assignNum == null) {
                assignNum = available.first();
            }
            counter[assignNum]++;
            available.remove(assignNum);
            pq.offer(new int[] {endTime, assignNum});
        }
        
        return findMaxesInCounter(counter);
    }
    
    private List<Integer> findMaxesInCounter(int[] counter) {
        int max = 0;
        for (int i = 0; i < counter.length; i++) {
            max = Math.max(max, counter[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}