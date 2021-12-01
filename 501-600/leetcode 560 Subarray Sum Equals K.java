// leetcode 560 Subarray Sum Equals K


/*
time: O(n)
space: O(n)
*/

// if the cumulative sum up to two indices, say ii and jj is at a difference of kk i.e. 
// if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices ii and jj is kk

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (preSum.containsKey(sum - k)) {
        		res += preSum.get(sum - k);
        	}
        	preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}