// leetcode 360 Sort Transformed Array

/*
time: O(n)
space: O(n)
*/

// The difference is when a > 0, they are larger at two ends, 
// when a < 0, they are smaller at two ends. So when a > 0, 
// we just start to fill out the result array from end to beginning, 
// in other case, we start filling out it from start to the end of result array.
class Solution {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
	    int n = nums.length, start = 0, end = n - 1; 
	    int[] res = new int[n];
	    if (a > 0) {
	        for (int i = n - 1; i >= 0; i--) {
	        	int x = func(nums[start], a, b, c);    
	            int y = func(nums[end], a, b, c); 
	            if (x > y) {
		            res[i] = x;
		            start++;
		        } else {
		            res[i] = y;
		            end--;
		        }
		    }  
	    } else {
	        for (int i = 0; i < n; i++) {
	          	int x = func(nums[start], a, b, c);    
	          	int y = func(nums[end], a, b, c); 
	          	if (x < y) {
	            	res[i] = x;
	            	start++;
	          	} else {
	            	res[i] = y;
	            	end--;
	          	}
	        }            
	    }
	    return res;
	}

    private int func(int x, int a, int b, int c) {
      	return a * x * x + b * x + c;    
    }
}
