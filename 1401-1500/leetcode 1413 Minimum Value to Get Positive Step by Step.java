// leetcode 1413 Minimum Value to Get Positive Step by Step

/*
time: O(n)
space: O(1)
*/

class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        
        return -min + 1 > 0 ? -min + 1 : 1;
    }
}