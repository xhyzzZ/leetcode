//leetcode 213 House Robber II

/*
time: O()
space: O()
*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        return Math.max(rob1(Arrays.copyOfRange(nums, 1, nums.length)), nums[0] + rob1(Arrays.copyOfRange(nums, 2, nums.length - 1)));
    }
    
    public int rob1(int[] nums) {
        int preno = 0;
        int preyes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = preyes;
            preyes = preno + nums[i];
            preno = Math.max(preno, tmp);
        }
        return Math.max(preyes, preno);
    }
}