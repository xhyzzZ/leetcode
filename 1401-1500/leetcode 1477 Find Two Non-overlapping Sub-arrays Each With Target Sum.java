// leetcode 1477 Find Two Non-overlapping Sub-arrays Each With Target Sum

/*
time: O()
space: O()
*/

pq
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int currSum = arr[0];
        int start = 0, end = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        while (end < arr.length) {
            if (currSum == target) {
                int[] n = {start, end, end - start + 1};
                pq.offer(n);
            }

            if (currSum <= target) {
                end++;
                if (end < arr.length) currSum = currSum + arr[end];
            } else {
                currSum = currSum - arr[start];
                start++;
            }
        }
        
        if (pq.size() < 2) return -1;
        int[] first = pq.poll();
        int res = first[2];
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //check overlap;
            if (cur[0] > first[1] || cur[1] < first[0]) {
                res += cur[2];
                return res;
            }
        }
        return -1;
    }
}