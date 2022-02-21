// leetcode 373 Find K Pairs with Smallest Sums

/*
time: O(klogk)
space: O(k)
*/

// Basic idea: Use min_heap to keep track on next minimum pair sum, 
// and we only need to maintain K possible candidates in the data structure
// For every numbers in nums1, its best partner(yields min sum) always strats from nums2[0] 
// since arrays are all sorted; And for a specific number in nums1, its next candidate 
// sould be [this specific number] + nums2[current_associated_index + 1], unless out of boundary;
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        } 
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(new int[] {cur[0], cur[1]});
            if (cur[2] == nums2.length - 1) continue;
            pq.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}