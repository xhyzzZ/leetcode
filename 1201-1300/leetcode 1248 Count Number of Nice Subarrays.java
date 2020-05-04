// leetcode 1248 Count Number of Nice Subarrays

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, len = nums.length;
        int[] prefix = new int[len];
        int odd = 0;
        for (int i = 0; i < len; i++) {
            prefix[odd]++;
            
            if (nums[i] % 2 == 1) {
                odd++;
            }
            if (odd >= k) {
                count += prefix[odd - k]; 
            }
        }
        return count;
    }
}