// leetcode 2006 Count Number of Pairs With Absolute Difference K

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
			count += map.getOrDefault(i - k, 0) + map.getOrDefault(i + k, 0);
        }
        return count;
    }
}