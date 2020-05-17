// leetcode 1438 Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int start = 0, end = 1, maxLen = 1;
        TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        set.add(0);
        while (end < nums.length) {
            set.add(end);
            end++;
            while (nums[set.last()] - nums[set.first()] > limit) {
                set.remove(start);
                start++;
            }
            
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}

/*
time: O(n)
space: O(n)
*/

class Solution {
	public int longestSubarray(int[] nums, int limit) {
		Deque<Integer> maxDeque = new LinkedList<>();
		Deque<Integer> minDeque = new LinkedList<>();
		int res = 1;
		int l = 0;
		// find the longest subarray for every right pointer by shrinking left pointer
		for (int r = 0; r < nums.length; ++r) {

			// update maxDeque with new right pointer
			while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
				maxDeque.removeLast();
			}
			maxDeque.addLast(nums[r]);

			// update minDeque with new right pointer
			while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
				minDeque.removeLast();
			}
			minDeque.addLast(nums[r]);

			// shrink left pointer if exceed limit
			while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
				if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
				if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
				++l;  // shrink it!
			}

			// update res
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}