//leetcode 35 Search Insert Position


/*
time: O(logn)
space: O(1)
*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
        	int mid = (end - start) / 2 + start;
        	if(nums[mid == target]) return mid;
        	else if(target < nums[mid]) end = mid - 1;
        	else start = mid + 1;
        }
        if(target <= nums[start]) {
        	return start;
        } 
        if(target > nums[end]) {
        	return end + 1;
        }
    }
}