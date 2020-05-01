//leetcode 27 Remove Element


//time: O(n)
//space: O(1)
public class Solution {
    public int removeElement(int[] nums, int val) {
    	if(nums.length == 0 || nums == null) return 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != val) {
        		nums[res++] = nums[i];
        	}
        }
        return res;
    }
}