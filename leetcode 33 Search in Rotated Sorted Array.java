//leetcode 33 Search in Rotated Sorted Array


/* 
time: O(logn)
space: O(1)

*/ 
public class Solution {
    public int search(int[] nums, int target) {
        if(nums = null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
        	int mid = (end - start) / 2 + start;
        	if(nums[mid] == target) return mid;
        	if(nums[start] < nums[mid]) {
        		if(nums[start] <= target && target <= nums[mid]) { /*   4 5 6 7 0 1 2   */ 
        			end = mid - 1;
        		} else start = mid + 1;
        	} else {
        		if(nums[mid] <= target && target <= nums[mid]) {.  /*   4 5 6 0 1 2 3  */
        			start = mid + 1;
        		} else end = mid - 1;
        	}
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}