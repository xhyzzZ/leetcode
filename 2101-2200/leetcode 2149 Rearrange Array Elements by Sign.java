// leetcode 2149 Rearrange Array Elements by Sign

/*
time: O(n)
space: O(n)
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
    	int len = nums.length;
       	int[] res = new int[len];
        int pi = 0, ni = 1;
        for (int i = 0; i< len; i++) {
            if (nums[i] > 0) {
                res[pi] = nums[i];
                pi += 2;
            } else {
                res[ni] = nums[i];
                ni += 2;
            }
        }
        return res;
    }
}