// leetcode 454 4Sum II

/*
time: O(n^2)
space: O(n^2)
*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    	int count = 0;
	    Map<Integer, Integer> m = new HashMap<>();
	    for (int a : nums1) {
	        for (int b : nums2) {
	            m.put(a + b, m.getOrDefault(a + b, 0) + 1);
	        }
	    }

	    for (int c : nums3) {
	        for (int d : nums4) {
	            count += m.getOrDefault(-(c + d), 0);
	        }
	    }
	    return count;
    }
}