// leetcode 1403 Minimum Subsequence in Non-Increasing Order

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
		Arrays.sort(nums);
		for (int num : nums) sum += num;

		List<Integer> res = new ArrayList<>();
		int seqSum = 0, idx = nums.length - 1;
		while (2 * seqSum <= sum) {
			seqSum += nums[idx];
			res.add(nums[idx--]);
		}
		return res;
    }
}