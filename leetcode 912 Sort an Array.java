//leetcode 912 Sort an Array

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int[] sortArray(int[] nums) {
	    quickSort(nums, 0, nums.length - 1);
	    return nums;
	}

	private void quickSort(int[] nums, int s, int e) {
	    if (s >= e) {
	        return;
	    }
	    int l = s;
	    int r = e;
	    int k = nums[s + (e - s) / 2];
	    while (l <= r) {
	        while (l <= r && nums[l] < k) {
	            ++l;
	        }
	        while (l <= r && nums[r] > k) {
	            --r;
	        }
	        if (l <= r) {
	            swap(nums, l++, r--);
	        }
	    }
	    quickSort(nums, s, r);
	    quickSort(nums, l, e);
	}

	private void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
   
}