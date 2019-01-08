//leetcode 80 Remove Duplicates from Sorted Array II


/*
time: O(n)
space: O(1)
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int count = 2;
        for(int i = 2; i < nums.length; i++) {
        	if(nums[i] != nums[count - 2]) {
        		nums[count++] = nums[i];
        	}
        }
        return count;
    }
}