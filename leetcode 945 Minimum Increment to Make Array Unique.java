//leetcode 945 Minimum Increment to Make Array Unique

/*
time: O(nlogn)
space: O(1)
*/

class Solution {
    public int minIncrementForUnique(int[] A) {
    	if (A.length == 0) return 0;
	    Arrays.sort(A);
	    int pre = A[0], res = 0;
	    for (int i = 1; i < A.length; i++) {
	        pre = Math.max(pre + 1, A[i]);
	        res += pre - A[i];
	    }
	    return res;
    }
}