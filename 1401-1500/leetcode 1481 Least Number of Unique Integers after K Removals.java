// leetcode 1481 Least Number of Unique Integers after K Removals

/*
time: O(nlogn)
space: O(n)
*/
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        pq.addAll(map.keySet());
        while (k > 0) {
            k -= map.get(pq.poll());
        }
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int remaining = map.size(), occur = 1;
        int[] occurrenceCount = new int[arr.length + 1];
        for (int v : map.values())
            occurrenceCount[v]++;
        while (k > 0) {
            if (k - occur * occurrenceCount[occur] >= 0) {
                k -= occur * occurrenceCount[occur];
                remaining -= occurrenceCount[occur++];
            } else {
                return remaining - k / occur;
            }
        }
        return remaining; 
    }
}