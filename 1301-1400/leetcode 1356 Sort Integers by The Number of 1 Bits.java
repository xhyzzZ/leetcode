// leetcode 1356 Sort Integers by The Number of 1 Bits

/*
time: O(nlogn)
space: O()
*/

class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int count = countSetBits(val);
            pq.add(new int[] {val, count});
        }
        
        int[] res = new int[arr.length];
        int j = 0;
        while (!pq.isEmpty()) {
            res[j++] = pq.poll()[0];
        }
        return res;
    }
    
    private int countSetBits(int n) { 
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
}